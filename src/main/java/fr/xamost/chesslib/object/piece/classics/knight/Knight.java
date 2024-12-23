package fr.xamost.chesslib.object.piece.classics.knight;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;
import fr.xamost.chesslib.object.piece.classics.king.KingCaptureHandler;

public class Knight extends Piece
{
    public Knight(GameManager instance, SquareObject square, PieceSides side) {
        super(instance, square, PieceTypes.KNIGHT, side, new KnightMoveHandler(), new KingCaptureHandler());
    }
}
