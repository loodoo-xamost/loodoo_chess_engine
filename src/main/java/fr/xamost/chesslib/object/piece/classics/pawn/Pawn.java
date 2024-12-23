package fr.xamost.chesslib.object.piece.classics.pawn;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;

public class Pawn extends Piece {
    public Pawn(GameManager instance, SquareObject square, PieceSides side)
    {
        super(instance, square, PieceTypes.PAWN, side, new PawnMoveHandler(), new PawnCaptureHandler());
    }

}
