package fr.xamost.chesslib.gui.panel;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.utils.XColor;

import static fr.xamost.chesslib.render.utils.XStaticColor.TRANSPARENT;

public abstract class Panel
{
    private Vector2D graphicPosition;
    private XColor backgroundColor;
    public Panel(Vector2D position)
    {
        this.graphicPosition = position;
        this.backgroundColor = TRANSPARENT;
    }

    public Panel(Vector2D position, XColor backgroundColor)
    {
        this.graphicPosition = position;
        this.backgroundColor = backgroundColor;
    }

    public abstract void init();
    public abstract void draw();
    public abstract void update();



    public Vector2D getGraphicPosition() {
        return graphicPosition;
    }

    public void setGraphicPosition(Vector2D graphicPosition) {
        this.graphicPosition = graphicPosition;
    }

    public XColor getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(XColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
