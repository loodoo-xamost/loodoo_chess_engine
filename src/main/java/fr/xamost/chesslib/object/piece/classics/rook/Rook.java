package fr.xamost.chesslib.object.piece.classics.rook;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;

public class Rook extends Piece
{
    public Rook(GameManager instance, SquareObject square, PieceSides side)
    {
        super(instance, square, PieceTypes.ROOK, side, new RookMoveHandler(), new RookCaptureHandler());
    }
}
