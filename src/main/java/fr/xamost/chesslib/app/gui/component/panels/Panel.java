package fr.xamost.chesslib.app.gui.component.panels;

import fr.xamost.chesslib.render.shapes.ShapeRect;
import fr.xamost.chesslib.render.utils.XColor;

public class Panel
{
    private final ShapeRect rect;
    public Panel(int x, int y, int width, int height, XColor color)
    {
        this.rect = new ShapeRect(x, y, width, height, color);
    }

    public void draw()
    {
        this.rect.draw();
    }
}
