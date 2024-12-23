package fr.xamost.chesslib.object.piece.classics.pawn;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.handler.MoveHandler;
import fr.xamost.chesslib.object.piece.handler.PieceMoveHandler;

public class PawnMoveHandler extends MoveHandler implements PieceMoveHandler
{
    @Override
    public boolean isPromotionMove() {
        return isStraightMove() && (isPromotionMoveWhite() || isPromotionMoveBlack());
    }
    public boolean isPromotionMoveWhite()
    {
        return this.instance.isWhite() && this.instance.position.boardCoords.Y() == 0;
    }
    public boolean isPromotionMoveBlack()
    {
        return this.instance.isBlack() && this.instance.position.boardCoords.Y() == 7;
    }
    @Override
    public boolean isValidMove() {
        return isStraightMove() && isTargetOnBoard();
    }



    public boolean isStraightMove()
    {
        return (isStraightMoveBlack() || isStraightMoveWhite()) && this.instance.position.boardCoords.X() == this.instance.position.boardPreCoords.X();
    }

    public boolean isStraightMoveWhite()
    {
        if(instance.isWhite())
        {
            if(this.instance.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() - 1)
                return true;
            return this.moveCount == 0 && this.instance.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() - 2;
        }
        return false;
    }
    public boolean isStraightMoveBlack()
    {
        if(this.instance.isBlack())
        {
            if(this.instance.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() + 1)
                return true;
            return this.moveCount == 0 && this.instance.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() + 2;
        }
        return false;
    }






}
