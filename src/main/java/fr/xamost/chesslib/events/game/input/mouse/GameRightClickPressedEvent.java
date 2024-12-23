package fr.xamost.chesslib.events.game.input.mouse;

import fr.xamost.chesslib.events.Event;

public class GameRightClickPressedEvent implements Event
{
    public GameRightClickPressedEvent()
    {
        Callback();
    }

    @Override
    public void Callback()
    {
        StatTrace();
    }

    @Override
    public void StatTrace()
    {
        System.out.println("Right click pressed Event");
    }
}
