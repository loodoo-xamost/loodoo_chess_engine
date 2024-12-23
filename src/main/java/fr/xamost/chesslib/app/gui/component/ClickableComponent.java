package fr.xamost.chesslib.app.gui.component;

import fr.xamost.chesslib.math.Vector2D;

public class ClickableComponent
{
    private Vector2D position;
    private int size;
    private boolean enabled;
    public ClickableComponent(Vector2D position, int size)
    {
        this.position = position;
        this.size = size;
        this.enabled = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void callback()
    {

    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
