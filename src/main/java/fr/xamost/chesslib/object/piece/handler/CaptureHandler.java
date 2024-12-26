package fr.xamost.chesslib.object.piece.handler;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;

public class CaptureHandler
{
    protected Piece instance;
    public void init(Piece instance)
    {
        this.instance = instance;
    }

    public boolean isCaptureMove(Piece hittingPiece)
    {
        return false;
    }
    public boolean isCaptureEnPassant(Piece lastMovedPiece)
    {
        return false;
    }

    public boolean isPawnCaptureMoveWhite(Vector2D boardCoords, Vector2D boardPreCoords)
    {
        if(instance.getPieceColor() == PieceSides.WHITE)
        {
            if(boardCoords.Y() == boardPreCoords.Y() - 1)
            {
                return Math.abs(boardCoords.X() - boardPreCoords.X()) == 1;
            }
        }
        return false;
    }

    public boolean isPawnCaptureMoveBlack(Vector2D boardCoords, Vector2D boardPreCoords)
    {
        if(instance.getPieceColor() == PieceSides.BLACK)
        {
            if(boardCoords.Y() == boardPreCoords.Y() + 1)
            {
                return Math.abs(boardCoords.X() - boardPreCoords.X()) == 1;
            }
        }
        return false;
    }
}
