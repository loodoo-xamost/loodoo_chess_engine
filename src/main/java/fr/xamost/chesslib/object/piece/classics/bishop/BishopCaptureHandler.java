package fr.xamost.chesslib.object.piece.classics.bishop;

import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.handler.CaptureHandler;

public class BishopCaptureHandler extends CaptureHandler
{
    @Override
    public boolean isCaptureMove(Piece hittingPiece) {
        return hittingPiece != null && this.instance.moveHandler.isPieceMove();
    }
}
