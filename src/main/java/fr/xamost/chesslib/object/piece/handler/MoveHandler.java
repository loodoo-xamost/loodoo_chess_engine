package fr.xamost.chesslib.object.piece.handler;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;

import static fr.xamost.chesslib.math.Coords2D.integerToIndex;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_HALF_SIZE;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public class MoveHandler implements PieceMoveHandler
{
    public int moveCount;
    protected Piece instance;
    public void init(Piece instance)
    {
        this.instance = instance;
        this.moveCount = 0;

    }


    public boolean isTargetPositionOnStraightLine()
    {
        return (
                this.instance.position.boardPreCoords.X() == this.instance.position.boardCoords.X() && this.instance.position.boardPreCoords.Y() != this.instance.position.boardCoords.Y()
        ) || (
                this.instance.position.boardPreCoords.X() != this.instance.position.boardCoords.X() && this.instance.position.boardPreCoords.Y() == this.instance.position.boardCoords.Y()
        );
    }

    public boolean isTargetPositionOnDiagonalLine()
    {
        return (Math.abs(this.instance.position.boardCoords.X() - this.instance.position.boardPreCoords.X()) == Math.abs(this.instance.position.boardCoords.Y() - this.instance.position.boardPreCoords.Y())) &&
                this.instance.position.boardPreCoords != this.instance.position.boardCoords;
    }

    public static boolean isSame(Vector2D v1, Vector2D v2)
    {
        return (v1.X() == v2.X() && v1.Y() == v2.Y());
    }

    @Override
    public boolean isValidMove() {
        return false;
    }
    public boolean isPieceMove()
    {
        return false;
    }
    public boolean isPieceOneTargetStraightLine()
    {
        for(int col = this.instance.position.boardPreCoords.X()-1; col > this.instance.position.boardCoords.X(); col--)
        {
            for(Piece piece : this.instance.gameInstance.piecesOnBoard)
            {
                if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == this.instance.position.boardCoords.Y())
                {
                    return true;
                }
            }
        }
        for(int col = this.instance.position.boardPreCoords.X()+1; col < this.instance.position.boardCoords.X(); col++)
        {
            for(Piece piece : this.instance.gameInstance.piecesOnBoard)
            {
                if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == this.instance.position.boardCoords.Y())
                {
                    return true;
                }
            }
        }

        for(int row = this.instance.position.boardPreCoords.Y()-1; row > this.instance.position.boardCoords.Y(); row--)
        {
            for(Piece piece : this.instance.gameInstance.piecesOnBoard)
            {
                if(piece.position.boardCoords.X() == this.instance.position.boardCoords.X() && piece.position.boardCoords.Y() == row)
                {
                    return true;
                }
            }
        }
        for(int row = this.instance.position.boardPreCoords.Y()+1; row < this.instance.position.boardCoords.Y(); row++)
        {
            for(Piece piece : this.instance.gameInstance.piecesOnBoard)
            {
                if(piece.position.boardCoords.X() == this.instance.position.boardCoords.X() && piece.position.boardCoords.Y() == row)
                {
                    return true;
                }
            }
        }


        return false;
    }

    public boolean isPieceOneTargetDiagonalLine()
    {
        if(this.instance.position.boardCoords.Y() < this.instance.position.boardPreCoords.Y())
        {
            //up left
            for(int col = this.instance.position.boardPreCoords.X()-1; col > this.instance.position.boardCoords.X(); col--)
            {
                int diff = Math.abs(col - this.instance.position.boardPreCoords.X());
                for(Piece piece : this.instance.gameInstance.piecesOnBoard)
                {
                    if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() - diff)
                    {
                        return true;
                    }
                }
            }
            // up right
            for(int col = this.instance.position.boardPreCoords.X() + 1; col < this.instance.position.boardCoords.X(); col++)
            {
                int diff = Math.abs(col - this.instance.position.boardPreCoords.X());
                for(Piece piece : this.instance.gameInstance.piecesOnBoard)
                {
                    if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() - diff)
                    {
                        return true;
                    }
                }
            }
        }
        if(this.instance.position.boardCoords.Y() > this.instance.position.boardPreCoords.Y())
        {
            //down right
            for(int col = this.instance.position.boardPreCoords.X()-1; col > this.instance.position.boardCoords.X(); col--)
            {
                int diff = Math.abs(col - this.instance.position.boardPreCoords.X());
                for(Piece piece : this.instance.gameInstance.piecesOnBoard)
                {
                    if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() + diff)
                    {
                        return true;
                    }
                }
            }
            //down right
            for(int col = this.instance.position.boardPreCoords.X()+1; col < this.instance.position.boardCoords.X(); col++)
            {
                int diff = Math.abs(col - this.instance.position.boardPreCoords.X());
                for(Piece piece : this.instance.gameInstance.piecesOnBoard)
                {
                    if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() + diff)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isTargetOnBoard()
    {
        return (this.instance.position.boardCoords.X() < 8) && (this.instance.position.boardCoords.Y() < 8);
    }

    public boolean isPromotionMove()
    {
        return false;
    }

    public void incrementMove()
    {
        this.moveCount++;
    }
    public int getMoveCount()
    {
        return this.moveCount;
    }

    public boolean isCastlingMove() {
        return false;
    }
}
