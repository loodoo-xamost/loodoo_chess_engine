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
    public boolean isVerticalKnightMove(Vector2D boardCoords, Vector2D boardPreCoords) {
        return Math.abs(boardCoords.Y() - boardPreCoords.Y()) == 2 && Math.abs(boardCoords.X() - boardPreCoords.X()) == 1;
    }


    public boolean isHorizontalKnightMove() {
        return Math.abs(this.instance.position.boardCoords.Y() - this.instance.position.boardPreCoords.Y()) == 1 && Math.abs(this.instance.position.boardCoords.X() - this.instance.position.boardPreCoords.X()) == 2;
    }
    public boolean isHorizontalKnightMove(Vector2D boardCoords, Vector2D boardPreCoords) {
        return Math.abs(boardCoords.Y() - boardPreCoords.Y()) == 1 && Math.abs(boardCoords.X() - boardPreCoords.X()) == 2;
    }

    @Override
    public boolean canMove(Vector2D boardCoords) {
        return isHorizontalKnightMove(boardCoords, this.instance.position.boardCoords) || isVerticalKnightMove(boardCoords, this.instance.position.boardCoords);
    }
}
