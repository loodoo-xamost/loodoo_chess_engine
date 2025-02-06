package fr.xamost.chesslib.gui.panel;

import fr.xamost.chesslib.gui.component.Component;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.shapes.ShapeSquare;
import fr.xamost.chesslib.render.utils.XColor;

import java.util.ArrayList;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public abstract class SquarePanel extends Panel
{
    private int size;
    private ShapeSquare texture;
    private ArrayList<Component> components;

    public SquarePanel(Vector2D position)
    {
        super(position);
        this.size = BOARD_SQUARE_SIZE;
        this.texture = new ShapeSquare(this.getGraphicPosition(), size, this.getBackgroundColor());
        this.components = new ArrayList<>();
    }

    public SquarePanel(Vector2D position, XColor backgroundColor) {
        super(position, backgroundColor);
        this.size = BOARD_SQUARE_SIZE;
        this.texture = new ShapeSquare(this.getGraphicPosition(), size, this.getBackgroundColor());
        this.components = new ArrayList<>();
    }

    public SquarePanel(Vector2D position, XColor backgroundColor, int size)
    {
        super(position, backgroundColor);
        this.size = size;
        this.texture = new ShapeSquare(this.getGraphicPosition(), size, backgroundColor);
        this.components = new ArrayList<>();
    }

    public SquarePanel(Vector2D position, int size)
    {
        super(position);
        this.size = size;
        this.texture = new ShapeSquare(this.getGraphicPosition(), size, this.getBackgroundColor());
        this.components = new ArrayList<>();
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ShapeSquare getTexture() {
        return texture;
    }

    public void setTexture(ShapeSquare texture) {
        this.texture = texture;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }
}
