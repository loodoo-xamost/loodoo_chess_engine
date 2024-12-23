package fr.xamost.chesslib.object.piece.utils;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;

import java.util.ArrayList;

public class RayChecks
{
    public static boolean allDirectionChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        if((start.X() == stop.X() && start.Y() != stop.Y())  || (start.X() != stop.X() && start.Y() == stop.Y())) {
            return straightChecks(start, stop, pieces, currentPiece);
        }
        else if (Math.abs(start.X() - stop.X()) == Math.abs(start.Y() - stop.Y()))
        {
            return diagonalChecks(start, stop, pieces, currentPiece);
        }
        return false;
    }

    public static boolean straightChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        if(start.X() == stop.X())
        {
            return straightVerticalChecks(start, stop, pieces,currentPiece);
        } else if ( start.Y() == stop.Y()) {
            return straightHorizontalChecks(start, stop, pieces,currentPiece);
        }
        return false;
    }

    public static boolean straightHorizontalChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        if(start.X() > stop.X())
        {
            return straightHorizontalLeftChecks(start, stop, pieces, currentPiece);
        } else if ( start.X() < stop.X())
        {
            return straightHorizontalRightChecks(start, stop, pieces, currentPiece);
        }
        return false;
    }
    public static boolean straightHorizontalLeftChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        for(Piece piece : pieces)
        {
            for(int col = start.X(); col > stop.X(); col--)
            {
                if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == start.Y() && piece != currentPiece)
                    return true;
            }
        }
        return false;
    }
    public static boolean straightHorizontalRightChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        for(Piece piece : pieces)
        {
            for(int col = start.X(); col < stop.X(); col++)
            {
                if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == start.Y() && piece != currentPiece)
                    return true;
            }
        }
        return false;
    }

    public static boolean straightVerticalChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        if(start.Y() > stop.Y())
        {
            return straightVerticalDownChecks(start, stop, pieces, currentPiece);
        } else if ( start.Y() < stop.Y())
        {
            return straightVerticalUpChecks(start, stop, pieces, currentPiece);
        }
        return false;
    }
    public static boolean straightVerticalUpChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        for(Piece piece : pieces)
        {
            for(int row = start.Y(); row < stop.Y(); row++)
            {
                if(piece.position.boardCoords.Y() == row && piece.position.boardCoords.X() == start.X() && piece != currentPiece)
                    return true;
            }
        }
        return false;
    }
    public static boolean straightVerticalDownChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        for(Piece piece : pieces)
        {
            for(int row = start.Y(); row > stop.Y(); row--)
            {
                if(piece.position.boardCoords.Y() == row && piece.position.boardCoords.X() == start.X() && piece != currentPiece)
                    return true;
            }
        }
        return false;
    }

    public static boolean diagonalChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        if(start.Y() < stop.Y())
        {
            // up = <
            // down = >
            return diagonalUpChecks(start, stop, pieces, currentPiece);
        } else if (start.Y() > stop.Y()) {
            return diagonalDownChecks(start, stop, pieces, currentPiece);
        }
        return false;
    }

    public static boolean diagonalUpChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {

        // left = <
        // right = >
        if(start.X() < stop.X())
        {
            return diagonalUpLeftChecks(start, stop, pieces, currentPiece);
        } else if ( start.X() > stop.X())
        {
            return diagonalUpRightChecks(start, stop, pieces, currentPiece);
        }
        return false;
    }

    public static boolean diagonalUpLeftChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        // up = <
        // left = <
        for(Piece piece : pieces)
        {
            int col = start.X();
            int row = start.Y();
            while(col < stop.X() && row < stop.Y())
            {
                if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == row && piece != currentPiece)
                    return true;
                col++;
                row++;
            }
        }
        return false;
    }
    public static boolean diagonalUpRightChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        // up = <
        // right = >
        for(Piece piece : pieces)
        {
            int col = start.X();
            int row = start.Y();
            while(col > stop.X() && row < stop.Y())
            {
                if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == row && piece != currentPiece)
                    return true;
                col--;
                row++;
            }
        }
        return false;
    }


    public static boolean diagonalDownChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        // left = <
        // right = >
        if(start.X() < stop.X())
        {
            return diagonalDownLeftChecks(start, stop, pieces, currentPiece);
        } else if ( start.X() > stop.X())
        {
            return diagonalDownRightChecks(start, stop, pieces, currentPiece);
        }
        return false;
    }


    public static boolean diagonalDownLeftChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        // down = >
        // left = <
        for(Piece piece : pieces)
        {
            int col = start.X();
            int row = start.Y();
            while(col < stop.X() && row > stop.Y())
            {
                if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == row && piece != currentPiece)
                    return true;
                col++;
                row--;
            }
        }
        return false;
    }

    // down = >
    // right = >
    public static boolean diagonalDownRightChecks(Vector2D start, Vector2D stop, ArrayList<Piece> pieces, Piece currentPiece)
    {
        for(Piece piece : pieces)
        {
            int col = start.X();
            int row = start.Y();
            while(col > stop.X() && row > stop.Y())
            {
                if(piece.position.boardCoords.X() == col && piece.position.boardCoords.Y() == row && piece != currentPiece)
                    return true;
                col--;
                row--;
            }
        }
        return false;
    }
}
