package fr.xamost.chesslib.object.piece.classics.rook;

import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.handler.CaptureHandler;

public class RookCaptureHandler extends CaptureHandler
{
    @Override
    public boolean isCaptureMove(Piece hittingPiece) {
        return hittingPiece != null && this.instance.moveHandler.isPieceMove();
    }
}
