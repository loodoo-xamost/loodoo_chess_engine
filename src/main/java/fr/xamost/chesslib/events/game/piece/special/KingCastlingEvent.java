package fr.xamost.chesslib.events.game.piece.special;

import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.classics.king.King;
import fr.xamost.chesslib.object.piece.classics.knight.CastlingType;

import static fr.xamost.chesslib.object.piece.classics.king.KingMoveHandler.getCaslingPiece;
import static fr.xamost.chesslib.object.piece.handler.MoveHandler.moveAccepted;

public class KingCastlingEvent implements Event
{
    private GameManager instance;
    public KingCastlingEvent(GameManager instance)
    {
        this.instance = instance;
        Callback();
    }
    @Override
    public void Callback()
    {
        if(this.instance.selectedPiece.moveHandler.isCastlingMove())
        {
            King king = (King) this.instance.selectedPiece;
            if(king.isWhite())
            {
                if(king.position.boardCoords.X() == king.position.boardPreCoords.X() + 2)
                {
                    Piece rook = getCaslingPiece(this.instance.piecesOnBoard, CastlingType.WHITE_KING_SIDE);
                    kingCastling(rook);
                }
                if(king.position.boardCoords.X() == king.position.boardPreCoords.X() - 2)
                {
                    Piece rook = getCaslingPiece(this.instance.piecesOnBoard, CastlingType.WHITE_QUEEN_SIDE);
                    kingCastling(rook);
                }
            }
            if(king.isBlack())
            {
                if(king.position.boardCoords.X() == king.position.boardPreCoords.X() + 2)
                {
                    Piece rook = getCaslingPiece(this.instance.piecesOnBoard, CastlingType.BLACK_KING_SIDE);
                    kingCastling(rook);
                }
                if(king.position.boardCoords.X() == king.position.boardPreCoords.X() - 2)
                {
                    Piece rook = getCaslingPiece(this.instance.piecesOnBoard, CastlingType.BLACK_QUEEN_SIDE);
                    kingCastling(rook);
                }
            }
        }
        StatTrace();
    }

    public void kingCastling(Piece rook) {
        if(rook != null)
        {
            rook.position.updateBoardPos(new Vector2D(rook.position.boardPreCoords.X() - 2, rook.position.boardPreCoords.Y()));
            rook.position.syncBoardCoords();
            rook.moveHandler.incrementMove();
            moveAccepted(instance);
        }
    }


    @Override
    public void StatTrace() {
        System.out.println("King castling Event");
    }

}
