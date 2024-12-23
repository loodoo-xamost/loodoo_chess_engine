package fr.xamost.chesslib.input.app.listeners;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.app.input.mouse.AppLeftClickPressedEvent;
import fr.xamost.chesslib.events.app.input.mouse.AppLeftClickReleasedEvent;
import fr.xamost.chesslib.input.Listener;
import fr.xamost.chesslib.input.object.Mouse;

public class AppMouseListener implements Listener
{
    private final App appInstance;
    private Mouse mouse;
    public AppMouseListener(App appInstance)
    {
        this.appInstance = appInstance;
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
        if(mouse.isLeftClickPressed())
        {
            new AppLeftClickPressedEvent();
        }
        if(mouse.isLeftClickReleased())
        {
            new AppLeftClickReleasedEvent();
        }

    }
}
