package fr.xamost.chesslib.events.app.input.mouse;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.frame.game.playing.gui.component.buttons.PromotionButton;
import fr.xamost.chesslib.game.GameState;
import fr.xamost.chesslib.gui.component.interactive.ClickableComponent;
import fr.xamost.chesslib.input.object.Mouse;

import static fr.xamost.chesslib.frame.game.playing.gui.panel.GameInfoPanel.clickableComponents;
import static fr.xamost.chesslib.frame.game.playing.gui.panel.GameInfoPanel.promotionButtons;
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
            for(PromotionButton component : promotionButtons)
            {
                if(hitbox(mouse.getMousePos(), component.getGraphicPosition(), component.getSize()) && component.isClickable())
                {
                    System.out.println("Component CallBack " + component.getSize() + " " + component.getSize());
                    component.onClick();
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
