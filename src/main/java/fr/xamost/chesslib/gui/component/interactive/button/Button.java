package fr.xamost.chesslib.gui.component.interactive.button;

import fr.xamost.chesslib.gui.component.interactive.ClickableComponent;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.utils.XColor;
import static fr.xamost.chesslib.render.utils.XStaticColor.TRANSPARENT;

public abstract class Button extends ClickableComponent
{
    private XColor color;
    public Button(Vector2D graphicPosition)
    {
        super(graphicPosition);
        this.color = TRANSPARENT;
    }
    public Button(Vector2D graphicPosition, XColor color)
    {
        super(graphicPosition);
        this.color = color;
    }

    public XColor getColor() {
        return color;
    }

    public void setColor(XColor color) {
        this.color = color;
    }
}
