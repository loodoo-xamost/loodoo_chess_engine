package fr.xamost.chesslib.gui.panel;

import fr.xamost.chesslib.gui.component.Component;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.shapes.ShapeRect;
import fr.xamost.chesslib.render.utils.XColor;

import java.util.ArrayList;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public abstract class RectPanel extends Panel
{
    private Vector2D size;
    private ShapeRect texture;
    private ArrayList<Component> components;

    public RectPanel(Vector2D position) {
        super(position);
        this.size = new Vector2D(BOARD_SQUARE_SIZE,BOARD_SQUARE_SIZE);
        this.texture = new ShapeRect(this.getGraphicPosition(), this.size, this.getBackgroundColor());
        this.components = new ArrayList<>();
    }

    public RectPanel(Vector2D position, XColor backgroundColor) {
        super(position, backgroundColor);
        this.size = new Vector2D(BOARD_SQUARE_SIZE,BOARD_SQUARE_SIZE);
        this.texture = new ShapeRect(this.getGraphicPosition(), this.size, this.getBackgroundColor());
        this.components = new ArrayList<>();
    }

    public RectPanel(Vector2D position, XColor backgroundColor, Vector2D size)
    {
        super(position, backgroundColor);
        this.size = size;
        this.texture = new ShapeRect(this.getGraphicPosition(), this.size, backgroundColor);
        this.components = new ArrayList<>();
    }

    public RectPanel(Vector2D position, Vector2D size)
    {
        super(position);
        this.size = size;
        this.texture = new ShapeRect(this.getGraphicPosition(), this.size, this.getBackgroundColor());
        this.components = new ArrayList<>();
    }



    public Vector2D getSize() {
        return size;
    }

    public void setSize(Vector2D size) {
        this.size = size;
    }

    public ShapeRect getTexture() {
        return texture;
    }

    public void setTexture(ShapeRect texture) {
        this.texture = texture;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }
}
