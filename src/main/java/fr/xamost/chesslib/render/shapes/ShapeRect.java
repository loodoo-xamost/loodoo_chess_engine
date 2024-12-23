package fr.xamost.chesslib.render.shapes;

import com.raylib.Raylib.Vector2;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.utils.XColor;

import static com.raylib.Raylib.DrawRectangle;
import static fr.xamost.chesslib.render.shapes.ShapesGlobals.BASE_SIZE;
import static fr.xamost.chesslib.render.utils.XStaticColor.PURPLE;


public class ShapeRect
{
    private int x, y, width, height;
    private XColor color;

    public ShapeRect()
    {
        this.x = 0;
        this.y = 0;
        this.width = BASE_SIZE;
        this.height = BASE_SIZE;
        this.color = PURPLE;
    }

    public ShapeRect(Vector2 pos)
    {
        this.x = (int) pos.x();
        this.y = (int) pos.y();
        this.width = BASE_SIZE;
        this.height = BASE_SIZE;
        this.color = PURPLE;
    }

    public ShapeRect(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.width = BASE_SIZE;
        this.height = BASE_SIZE;
        this.color = PURPLE;
    }

    public ShapeRect(Vector2 pos, int width, int height, XColor color)
    {
        this.x = (int) pos.x();
        this.y = (int) pos.y();
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public ShapeRect(Vector2D pos, int width, int height, XColor color)
    {
        this.x = pos.X();
        this.y = pos.Y();
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public ShapeRect(Vector2D pos, Vector2D size, XColor color)
    {
        this.x = pos.X();
        this.y = pos.Y();
        this.width = size.X();
        this.height = size.Y();
        this.color = color;
    }

    public ShapeRect(int x, int y, int width, int height, XColor color)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }



    public void draw()
    {
        DrawRectangle(x, y, width, height, color.getColor());
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


    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public XColor getColor()
    {
        return color;
    }

    public void setColor(XColor color) {
        this.color = color;
    }
}
