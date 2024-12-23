package fr.xamost.chesslib.object.piece.classics.pawn;

import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.handler.CaptureHandler;

public class PawnCaptureHandler extends CaptureHandler
{

    @Override
    public boolean isCaptureMove(Piece hittingPiece)
    {
        return hittingPiece != null && (isCaptureMoveBlack() || isCaptureMoveWhite());
    }

    public boolean isCaptureMoveWhite()
    {
        if(instance.getPieceColor() == PieceSides.WHITE)
        {
            if(this.instance.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() - 1)
            {
                return Math.abs(this.instance.position.boardCoords.X() - this.instance.position.boardPreCoords.X()) == 1;
            }
        }
        return false;
    }
    public boolean isCaptureMoveBlack()
    {
        if(instance.getPieceColor() == PieceSides.BLACK)
        {
            if(this.instance.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() + 1)
            {
                return Math.abs(this.instance.position.boardCoords.X() - this.instance.position.boardPreCoords.X()) == 1;
            }
        }
        return false;
    }
    @Override
    public boolean isCaptureEnPassant(Piece lastMovedPiece)
    {
        return (lastMovedPiece.getPieceColor() != this.instance.getPieceColor() && this.instance.position.boardCoords.Y() == lastMovedPiece.position.boardCoords.Y() && Math.abs(this.instance.position.boardCoords.X() - lastMovedPiece.position.boardCoords.X()) == 1);
    }
}
