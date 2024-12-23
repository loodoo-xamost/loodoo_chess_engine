package fr.xamost.chesslib.events.game.piece.special;

import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.game.GameState;
import fr.xamost.chesslib.object.piece.classics.pawn.Pawn;

public class PawnPromotionEvent implements Event
{
    private GameManager instance;
    public PawnPromotionEvent(GameManager instance)
    {
        this.instance = instance;
        if(this.instance.selectedPiece != null && this.instance.selectedPiece instanceof Pawn)
            Callback();
    }


    @Override
    public void Callback()
    {
        this.instance.setGameState(GameState.PROMOTION);
        StatTrace();
    }

    @Override
    public void StatTrace()
    {
        System.out.println("Pawn promotion Event");
    }
}
