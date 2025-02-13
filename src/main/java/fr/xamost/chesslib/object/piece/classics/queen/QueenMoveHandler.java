package fr.xamost.chesslib.object.piece.classics.queen;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.handler.MoveHandler;
import fr.xamost.chesslib.object.piece.handler.PieceMoveHandler;

import static fr.xamost.chesslib.object.piece.utils.RayChecks.*;

public class QueenMoveHandler extends MoveHandler implements PieceMoveHandler
{
    @Override
    public boolean isValidMove() {
        return isPieceMove() && !allDirectionChecks(this.instance.position.boardCoords, this.instance.position.boardPreCoords,this.instance.gameInstance.piecesOnBoard, this.instance);
    }

    @Override
    public boolean isPieceMove() {
        return (isTargetPositionOnDiagonalLine() || isTargetPositionOnStraightLine()) && isTargetOnBoard();
    }

    @Override
    public boolean canMove(Vector2D boardCoords) {
        return (isTargetPositionOnDiagonalLine(boardCoords, this.instance.position.boardCoords) || isTargetPositionOnDiagonalLine(boardCoords, this.instance.position.boardPreCoords)) && !allDirectionChecks(this.instance.position.boardCoords, boardCoords, this.instance.gameInstance.piecesOnBoard, this.instance);
    }
}
