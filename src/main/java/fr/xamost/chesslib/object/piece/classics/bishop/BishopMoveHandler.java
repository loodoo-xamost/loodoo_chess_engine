package fr.xamost.chesslib.object.piece.classics.bishop;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.handler.MoveHandler;
import fr.xamost.chesslib.object.piece.handler.PieceMoveHandler;

import static fr.xamost.chesslib.object.piece.utils.RayChecks.diagonalChecks;

public class BishopMoveHandler extends MoveHandler implements PieceMoveHandler {
    @Override
    public boolean isValidMove() {
        return isPieceMove() && !diagonalChecks(this.instance.position.boardCoords, this.instance.position.boardPreCoords,this.instance.gameInstance.piecesOnBoard, this.instance);
    }

    @Override
    public boolean isPieceMove()
    {
        return isTargetPositionOnDiagonalLine() && isTargetOnBoard();
    }

    @Override
    public boolean canMove(Vector2D boardCoords) {
        return isTargetPositionOnDiagonalLine(this.instance.position.boardCoords, boardCoords) && !diagonalChecks(this.instance.position.boardCoords, boardCoords, this.instance.gameInstance.piecesOnBoard, this.instance);
    }
}
