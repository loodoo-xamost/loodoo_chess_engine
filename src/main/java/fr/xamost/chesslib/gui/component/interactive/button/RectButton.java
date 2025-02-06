package fr.xamost.chesslib.gui.component.interactive.button;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.shapes.ShapeRect;
import fr.xamost.chesslib.render.utils.XColor;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public abstract class RectButton extends Button
{
    private final ShapeRect texture;
    private Vector2D size;
    public RectButton(Vector2D graphicPosition) {
        super(graphicPosition);
        this.size = new Vector2D(BOARD_SQUARE_SIZE,BOARD_SQUARE_SIZE);
        this.texture = new ShapeRect(this.getGraphicPosition(), this.size, this.getColor());
    }

    public RectButton(Vector2D graphicPosition, Vector2D size) {
        super(graphicPosition);
        this.size = size;
        this.texture = new ShapeRect(this.getGraphicPosition(), this.size, this.getColor());
    }

    public RectButton(Vector2D graphicPosition, XColor color)
    {
        super(graphicPosition, color);
        this.size = new Vector2D(BOARD_SQUARE_SIZE,BOARD_SQUARE_SIZE);
        this.texture = new ShapeRect(this.getGraphicPosition(), this.size, this.getColor());
    }

    public RectButton(Vector2D graphicPosition, XColor color, Vector2D size)
    {
        super(graphicPosition, color);
        this.size = size;
        this.texture = new ShapeRect(this.getGraphicPosition(), this.size, this.getColor());
    }


    public ShapeRect getTexture()
    {
        return texture;
    }

    public Vector2D getSize() {
        return size;
    }

    public void setSize(Vector2D size) {
        this.size = size;
    }
}
