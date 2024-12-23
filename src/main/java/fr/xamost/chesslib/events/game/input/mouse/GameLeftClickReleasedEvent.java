package fr.xamost.chesslib.events.game.input.mouse;

import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.events.game.piece.PieceMoveEvent;
import fr.xamost.chesslib.game.GameManager;

public class GameLeftClickReleasedEvent implements Event
{
    private GameManager instance;
    public GameLeftClickReleasedEvent(GameManager instance)
    {
        this.instance = instance;
        Callback();
    }
    @Override
    public void Callback() {
        if( instance.selectedPiece != null)
        {
            this.instance.selectedPiece.position.revertBoardCoords();
            new PieceMoveEvent(instance);
        }

        StatTrace();
    }

    @Override
    public void StatTrace() {
        System.out.println("Left click released Event");
    }
}
