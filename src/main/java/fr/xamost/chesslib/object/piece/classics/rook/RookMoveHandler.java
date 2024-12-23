package fr.xamost.chesslib.object.piece.classics.rook;

import fr.xamost.chesslib.object.piece.handler.MoveHandler;
import fr.xamost.chesslib.object.piece.handler.PieceMoveHandler;

import static fr.xamost.chesslib.object.piece.utils.RayChecks.straightChecks;

public class RookMoveHandler extends MoveHandler implements PieceMoveHandler
{
    @Override
    public boolean isValidMove() {
        return isPieceMove() && !straightChecks(this.instance.position.boardCoords, this.instance.position.boardPreCoords,this.instance.gameInstance.piecesOnBoard, this.instance);
    }

    @Override
    public boolean isPieceMove() {
        return isTargetPositionOnStraightLine() && isTargetOnBoard();
    }
}
