package fr.xamost.chesslib.events.app.input.mouse;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.app.gui.component.ClickableComponent;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameState;
import fr.xamost.chesslib.input.object.Mouse;

import static fr.xamost.chesslib.app.gui.component.panels.GameInfoPanel.clickableComponents;
import static fr.xamost.chesslib.math.HitBox.hitbox;

public class AppLeftClickPressedEvent implements Event
{
    private final Mouse mouse;
    public AppLeftClickPressedEvent()
    {
        this.mouse = App.mouse;
        Callback();
    }

    @Override
    public void Callback()
    {
        if(App.game.manager.getGameState() == GameState.PROMOTION)
        {
            for(ClickableComponent component : clickableComponents)
            {
                if(hitbox(mouse.getMousePos(), component.getPosition(), component.getSize()) && component.isEnabled())
                {
                    System.out.println("Component CallBack " + component.getPosition() + " " + component.getSize());
                    component.callback();
                    return;
                }
            }
        }
        StatTrace();

    }

    @Override
    public void StatTrace()
    {
        System.out.println("[AppLeftClickPressedEvent]");
    }
}
