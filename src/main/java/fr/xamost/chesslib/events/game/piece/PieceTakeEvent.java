package fr.xamost.chesslib.events.game.piece;

import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameManager;

import static fr.xamost.chesslib.object.piece.handler.MoveHandler.moveAccepted;

public class PieceTakeEvent implements Event
{
    private GameManager instance;
    public PieceTakeEvent(GameManager instance)
    {
        this.instance = instance;
        Callback();
    }

    @Override
    public void Callback()
    {
        if( instance.hittingPiece.getPieceColor() != instance.selectedPiece.getPieceColor())
        {
            this.instance.piecesOnBoard.remove(this.instance.hittingPiece);
            moveAccepted(instance);
        }

        StatTrace();
    }

    @Override
    public void StatTrace()
    {
        System.out.println("Piece take Event");
    }
}
