package fr.xamost.chesslib.object.piece.handler;

import fr.xamost.chesslib.object.piece.Piece;

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
}
