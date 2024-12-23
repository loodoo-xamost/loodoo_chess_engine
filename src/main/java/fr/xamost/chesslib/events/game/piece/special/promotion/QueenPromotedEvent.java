package fr.xamost.chesslib.events.game.piece.special.promotion;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.game.GameState;
import fr.xamost.chesslib.math.BoardCoordsTuples;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.classics.queen.Queen;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.SQUARE_PRIMARY_COLOR;

public class QueenPromotedEvent implements Event
{
    private final GameManager instance;
    public QueenPromotedEvent(GameManager instance)
    {
        this.instance = instance;
        Callback();
    }


    @Override
    public void Callback()
    {
        SquareObject square = new SquareObject(this.instance.selectedPiece.position.getGraphicPosFromCoords(), SQUARE_PRIMARY_COLOR, new BoardCoordsTuples(BoardCoordsTuples.genColStr(this.instance.selectedPiece.position.boardCoords.X()), this.instance.selectedPiece.position.boardCoords.Y()));
        Queen newQueen = new Queen(App.game.manager, square, this.instance.selectedPiece.getPieceColor());
        this.instance.piecesOnBoard.remove(this.instance.selectedPiece);
        this.instance.piecesOnBoardBeforeUpdate = this.instance.piecesOnBoard;
        this.instance.selectedPiece = null;
        this.instance.piecesOnBoard.add(newQueen);
        this.instance.changeSide();
        this.instance.setGameState(GameState.PLAYING);
        StatTrace();
    }

    @Override
    public void StatTrace() {
        System.out.println("Queen promoted");
    }
}
