package fr.xamost.chesslib.object.piece.classics.king;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;

public class King extends Piece
{
    public King(GameManager instance, SquareObject square, PieceSides side)
    {
        super(instance, square, PieceTypes.KING, side, new KingMoveHandler(), new KingCaptureHandler());
    }
}
