package fr.xamost.chesslib.input.game.listeners;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.game.piece.PieceDraggedEvent;
import fr.xamost.chesslib.events.game.input.mouse.GameLeftClickPressedEvent;
import fr.xamost.chesslib.events.game.input.mouse.GameLeftClickReleasedEvent;
import fr.xamost.chesslib.events.game.input.mouse.GameRightClickPressedEvent;
import fr.xamost.chesslib.events.game.input.mouse.GameRightClickReleasedEvent;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.input.Listener;
import fr.xamost.chesslib.input.object.Mouse;

public class GameMouseListener implements Listener
{
    private final GameManager instance;
    private final Mouse mouse;
    public GameMouseListener(GameManager instance)
    {
        this.instance = instance;
        this.mouse = App.mouse;
    }

    @Override
    public void init()
    {

    }

    @Override
    public void update()
    {
        this.mouse.setMousePos();
        if(this.mouse.isLeftClickPressed() && this.instance.selectedPiece != null)
        {
            new PieceDraggedEvent(instance);
        }

        if(this.mouse.isLeftClickPressed())
        {
            new GameLeftClickPressedEvent(instance);
        }
        if(this.mouse.isLeftClickReleased())
        {
            new GameLeftClickReleasedEvent(instance);
        }

        if(this.mouse.isRightClickPressed())
        {
            new GameRightClickPressedEvent();
        }
        if(this.mouse.isRightClickReleased())
        {
            new GameRightClickReleasedEvent();
        }
    }

    public Mouse getListenerObject()
    {
        return this.mouse;
    }
}
