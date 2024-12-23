package fr.xamost.chesslib.render.shapes;

import com.raylib.Raylib.Vector2;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.utils.XColor;

import static com.raylib.Raylib.DrawRectangle;
import static fr.xamost.chesslib.render.shapes.ShapesGlobals.BASE_SIZE;
import static fr.xamost.chesslib.render.utils.XStaticColor.PURPLE;

public class ShapeSquare
{
    private int x, y, size;
    private XColor color;

    public ShapeSquare()
    {
        this.x = 0;
        this.y = 0;
        this.size = BASE_SIZE;
        this.color = PURPLE;
    }

    public ShapeSquare(Vector2D pos)
    {
        this.x = pos.X();
        this.y = pos.Y();
        this.size = BASE_SIZE;
        this.color = PURPLE;
    }

    public ShapeSquare(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.size = BASE_SIZE;
        this.color = PURPLE;
    }

    public ShapeSquare(Vector2D pos, int size)
    {
        this.x = pos.X();
        this.y = pos.Y();
        this.size = size;
        this.color = PURPLE;
    }
    public ShapeSquare(int x, int y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = PURPLE;
    }

    public ShapeSquare(Vector2D pos, int size, XColor color)
    {
        this.x = pos.X();
        this.y = pos.Y();
        this.size = size;
        this.color = color;
    }

    public ShapeSquare(int x, int y, int size, XColor color)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void draw()
    {
        DrawRectangle(x, y, size, size, color.getColor());
    }

    public void updatePos(Vector2 pos)
    {
        this.x = (int) pos.x();
        this.y = (int) pos.y();
    }

    public void updatePos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }



    public Vector2 getPos()
    {
        return new Vector2().x(this.x).y(this.y);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public XColor getColor() {
        return color;
    }

    public void setColor(XColor color) {
        this.color = color;
    }
}
