package fr.xamost.chesslib.gui.component;

import fr.xamost.chesslib.math.Vector2D;

public abstract class Component
{
    private Vector2D graphicPosition;
    private boolean visible;
    public Component(Vector2D graphicPosition)
    {
        this.graphicPosition = graphicPosition;
        this.visible = false;
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw();

    public Vector2D getGraphicPosition() {
        return graphicPosition;
    }

    public void setGraphicPosition(Vector2D graphicPosition) {
        this.graphicPosition = graphicPosition;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible() {
        this.visible = !this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
