package fr.xamost.chesslib.events.game.piece;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.events.game.piece.special.KingCastlingEvent;
import fr.xamost.chesslib.events.game.piece.special.PawnEnPassantEvent;
import fr.xamost.chesslib.events.game.piece.special.PawnPromotionEvent;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.math.BoardCoordsTuples;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceTypes;
import fr.xamost.chesslib.object.piece.classics.king.King;
import fr.xamost.chesslib.object.piece.classics.pawn.Pawn;

import java.util.ArrayList;
import java.util.Objects;

import static fr.xamost.chesslib.math.Vector2D.multiply;
import static fr.xamost.chesslib.math.Vector2D.sub;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_HALF_SIZE;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;
import static fr.xamost.chesslib.object.piece.handler.IllegalHandler.isIllegal;
import static fr.xamost.chesslib.object.piece.handler.MoveHandler.isSame;
import static fr.xamost.chesslib.object.piece.handler.MoveHandler.moveAccepted;

public class PieceMoveEvent implements Event
{
    private static Vector2D PIECE_OFFSIDE = new Vector2D(BOARD_SQUARE_SIZE,BOARD_SQUARE_SIZE);


    private final GameManager instance;
    private final Vector2D mouseCoords;

    public PieceMoveEvent(GameManager instance)
    {
        this.instance = instance;
        this.mouseCoords = App.mouse.getMouseCoords();
        if(instance.selectedPiece != null && !isSame(instance.selectedPiece.position.boardCoords, mouseCoords))
            Callback();
    }

    @Override
    public void Callback()
    {
        if(!isSame(instance.selectedPiece.position.boardCoords, mouseCoords))
        {
            instance.selectedPiece.position.updateBoardPos(mouseCoords);
            for(Piece piece : instance.piecesOnBoard)
            {
                if(piece != instance.selectedPiece && isSame(piece.position.boardCoords, mouseCoords))
                {
                    instance.hittingPiece = piece;
                    System.out.println(instance.hittingPiece);
                }
            }

            if(!isIllegal(instance.getCurrentColorKing()))
            {
                if(instance.hittingPiece == null && instance.selectedPiece.moveHandler.isCastlingMove())
                {
                    new KingCastlingEvent(instance);
                }
                else if(instance.hittingPiece == null && instance.lastMovedPiece != null && instance.lastMovedPiece instanceof Pawn && instance.selectedPiece instanceof Pawn && instance.selectedPiece != instance.lastMovedPiece && this.instance.selectedPiece.captureHandler.isCaptureEnPassant(instance.lastMovedPiece))
                {
                    new PawnEnPassantEvent(instance);
                } else if (instance.hittingPiece == null && instance.selectedPiece instanceof Pawn && instance.selectedPiece.moveHandler.isPromotionMove())
                {
                    new PawnPromotionEvent(instance);
                    return;

                }else if(instance.selectedPiece.captureHandler.isCaptureMove(instance.hittingPiece) && this.instance.selectedPiece instanceof Pawn && this.instance.selectedPiece.position.isOnLastRank())
                {
                    new PieceTakeEvent(instance);
                    new PawnPromotionEvent(instance);
                    return;
                }
                else if(instance.selectedPiece.moveHandler.isValidMove() && instance.hittingPiece == null)
                {
                    moveAccepted(instance);
                }
                else if(instance.selectedPiece.captureHandler.isCaptureMove(instance.hittingPiece))
                {
                    if(this.instance.selectedPiece instanceof Pawn && this.instance.selectedPiece.position.isOnLastRank())
                    {
                        new PieceTakeEvent(instance);
                        new PawnPromotionEvent(instance);
                        return;
                    }
                    new PieceTakeEvent(instance);
                    moveAccepted(instance);
                }
            }
            instance.selectedPiece.position.revertBoardCoords();
            instance.hittingPiece = null;
            instance.selectedPiece = null;

        }

        StatTrace();
    }


    @Override
    public void StatTrace() {
        System.out.println("Piece move Event");
    }
}
