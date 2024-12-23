package fr.xamost.chesslib.events.game.input.mouse;

import fr.xamost.chesslib.events.Event;

public class GameRightClickReleasedEvent implements Event
{
    public GameRightClickReleasedEvent()
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
        System.out.println("Right click released Event");
    }
}
