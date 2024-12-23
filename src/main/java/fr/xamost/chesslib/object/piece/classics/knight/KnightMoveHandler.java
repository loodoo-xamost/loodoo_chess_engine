package fr.xamost.chesslib.object.piece.classics.knight;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.classics.rook.Rook;
import fr.xamost.chesslib.object.piece.handler.MoveHandler;
import fr.xamost.chesslib.object.piece.handler.PieceMoveHandler;

import java.util.ArrayList;

public class KnightMoveHandler extends MoveHandler implements PieceMoveHandler {
    @Override
    public boolean isValidMove() {
        return isPieceMove();
    }

    @Override
    public boolean isPieceMove() {
        return isKnightMove() && isTargetOnBoard();
    }

    public boolean isKnightMove() {
        return isVerticalKnightMove() || isHorizontalKnightMove();
    }

    public boolean isVerticalKnightMove() {
        return Math.abs(this.instance.position.boardCoords.Y() - this.instance.position.boardPreCoords.Y()) == 2 && Math.abs(this.instance.position.boardCoords.X() - this.instance.position.boardPreCoords.X()) == 1;
    }

    public boolean isHorizontalKnightMove() {
        return Math.abs(this.instance.position.boardCoords.Y() - this.instance.position.boardPreCoords.Y()) == 1 && Math.abs(this.instance.position.boardCoords.X() - this.instance.position.boardPreCoords.X()) == 2;
    }

}
