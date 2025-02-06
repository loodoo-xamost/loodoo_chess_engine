package fr.xamost.chesslib.gui.component.interactive.button;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.shapes.ShapeSquare;
import fr.xamost.chesslib.render.utils.XColor;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public abstract class SquareButton extends Button
{
    private int size;
    private final ShapeSquare texture;

    public SquareButton(Vector2D graphicPosition) {
        super(graphicPosition);
        this.size = BOARD_SQUARE_SIZE;
        this.texture = new ShapeSquare(this.getGraphicPosition(), size, this.getColor());
    }
    public SquareButton(Vector2D graphicPosition, int size) {
        super(graphicPosition);
        this.size = size;
        this.texture = new ShapeSquare(this.getGraphicPosition(), size, this.getColor());
    }

    public SquareButton(Vector2D graphicPosition, XColor color) {
        super(graphicPosition, color);
        this.size = BOARD_SQUARE_SIZE;
        this.texture = new ShapeSquare(this.getGraphicPosition(), size, this.getColor());
    }
    public SquareButton(Vector2D graphicPosition, XColor color, int size) {
        super(graphicPosition, color);
        this.size = size;
        this.texture = new ShapeSquare(this.getGraphicPosition(), size, this.getColor());
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
}
