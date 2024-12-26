package fr.xamost.chesslib.events.game.piece.special;

import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.piece.classics.pawn.Pawn;

import static fr.xamost.chesslib.object.piece.handler.MoveHandler.moveAccepted;

public class PawnEnPassantEvent implements Event
{
    private GameManager instance;
    public PawnEnPassantEvent(GameManager instance)
    {
        this.instance = instance;
        if(this.instance.selectedPiece != null && this.instance.selectedPiece instanceof Pawn && this.instance.lastMovedPiece != null && this.instance.lastMovedPiece instanceof  Pawn)
            Callback();
    }


    @Override
    public void Callback()
    {
        if(this.instance.lastMovedPiece.moveHandler.getMoveCount() == 1)
        {
            if(Math.abs(this.instance.lastMovedPiece.position.boardCoords.X() - this.instance.selectedPiece.position.boardPreCoords.X()) == 1 && this.instance.selectedPiece.position.boardPreCoords.Y() == this.instance.lastMovedPiece.position.boardCoords.Y())
            {
                this.instance.piecesOnBoard.remove(this.instance.lastMovedPiece);
                moveAccepted(instance);

            }
        }

        StatTrace();

    }

    @Override
    public void StatTrace() {

    }
}
