package fr.xamost.chesslib.gui.component.interactive;

import fr.xamost.chesslib.gui.component.Component;
import fr.xamost.chesslib.math.Vector2D;

public abstract class ClickableComponent extends Component
{
    private boolean isClickable;

    public ClickableComponent(Vector2D graphicPosition)
    {
        super(graphicPosition);
        isClickable = false;
    }

    public abstract void onClick();


    public boolean isClickable() {
        return isClickable;
    }

    public void setClickable() {
        isClickable = !this.isClickable;
    }

    public void setClickable(boolean clickable) {
        isClickable = clickable;
    }
}
