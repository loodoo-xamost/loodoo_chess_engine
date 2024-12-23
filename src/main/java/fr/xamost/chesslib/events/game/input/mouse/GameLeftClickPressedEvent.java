package fr.xamost.chesslib.events.game.input.mouse;

import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.events.game.piece.PieceMoveEvent;
import fr.xamost.chesslib.events.game.piece.SelectingPieceEvent;
import fr.xamost.chesslib.game.GameManager;

public class GameLeftClickPressedEvent implements Event
{
    private final GameManager instance;
    public GameLeftClickPressedEvent(GameManager instance)
    {
        this.instance = instance;
        Callback();
    }
    @Override
    public void Callback()
    {
        if(instance.selectedPiece == null)
        {
            new SelectingPieceEvent(instance);
        }
        if(instance.selectedPiece != null)
        {
            new PieceMoveEvent(instance);
        }
        StatTrace();
    }

    @Override
    public void StatTrace()
    {
        System.out.println("Left click pressed Event");
    }


}
