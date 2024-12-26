package fr.xamost.chesslib.events.game.piece.special.promotion;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.game.GameState;
import fr.xamost.chesslib.math.BoardCoordsTuples;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.classics.queen.Queen;
import fr.xamost.chesslib.object.piece.classics.rook.Rook;

import static fr.xamost.chesslib.events.game.piece.special.PawnPromotionEvent.promotionAccepted;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.SQUARE_PRIMARY_COLOR;

public class RookPromotedEvent implements Event {
    private GameManager instance;
    public RookPromotedEvent(GameManager instance)
    {
        this.instance = instance;
        Callback();
    }

    @Override
    public void Callback()
    {
        SquareObject square = new SquareObject(this.instance.selectedPiece.position.getGraphicPosFromCoords(), SQUARE_PRIMARY_COLOR, new BoardCoordsTuples(BoardCoordsTuples.genColStr(this.instance.selectedPiece.position.boardCoords.X()), this.instance.selectedPiece.position.boardCoords.Y()));
        Rook newRook = new Rook(App.game.manager, square, this.instance.selectedPiece.getPieceColor());
        promotionAccepted(instance, newRook);
        StatTrace();
    }

    @Override
    public void StatTrace()
    {
        System.out.println("RookPromotedEvent");

    }
}
