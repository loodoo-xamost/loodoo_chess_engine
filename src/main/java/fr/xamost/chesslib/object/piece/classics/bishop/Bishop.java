package fr.xamost.chesslib.object.piece.classics.bishop;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;
import fr.xamost.chesslib.object.piece.handler.MoveHandler;

public class Bishop extends Piece {
    public Bishop(GameManager instance, SquareObject square, PieceSides side) {
        super(instance, square, PieceTypes.BISHOP, side, new BishopMoveHandler(), new BishopCaptureHandler());
    }
}
