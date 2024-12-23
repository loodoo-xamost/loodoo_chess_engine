package fr.xamost.chesslib.object.piece.classics.queen;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;
import fr.xamost.chesslib.object.piece.handler.MoveHandler;

public class Queen extends Piece
{
    public Queen(GameManager instance, SquareObject square, PieceSides side) {
        super(instance, square, PieceTypes.QUEEN, side, new QueenMoveHandler(), new QueenCaptureHandler());
    }
}
