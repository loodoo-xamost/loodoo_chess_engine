package fr.xamost.chesslib.object.board.square;

import fr.xamost.chesslib.math.BoardCoordsTuples;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.shapes.ShapeSquare;
import fr.xamost.chesslib.render.utils.XColor;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public class SquareObject
{
    private final Vector2D position;
    private final BoardCoordsTuples coords;

    private ShapeSquare texture;
    private final XColor color;

    public SquareObject(Vector2D position, XColor color, BoardCoordsTuples coords)
    {
        this.position = position;
        this.color = color;
        this.coords = coords;
        generateTexture();
    }

    private void generateTexture()
    {
        this.texture = new ShapeSquare(position, BOARD_SQUARE_SIZE ,color);
    }

    public void draw()
    {
        texture.draw();
    }

    @Override
    public String toString()
    {
        return "Board Square : x = " + position.X() + ", y = " + position.Y() + ", color = " + color.toString() + ", Coords = " + coords.toString();
    }

    public Vector2D getPosition() {
        return position;
    }

    public BoardCoordsTuples getCoords() {
        return coords;
    }

    public int getPosX() {
        return position.X();
    }

    public int getPosY() {
        return position.Y();
    }

    public ShapeSquare getTexture() {
        return texture;
    }

    public XColor getColor() {
        return color;
    }
}
