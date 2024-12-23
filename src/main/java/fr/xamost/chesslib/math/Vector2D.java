package fr.xamost.chesslib.math;

public class Vector2D
{
    private int x;
    private int y;

    public Vector2D()
    {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D vector)
    {
        this.x = vector.X();
        this.y = vector.Y();
    }

    public int X() {
        return x;
    }

    public int Y() {
        return y;
    }

    public void X(int x)
    {
        this.x = x;
    }
    public void Y(int y)
    {
        this.y = y;
    }

    public static Vector2D sub(Vector2D a, Vector2D b)
    {
        return new Vector2D(a.X() - b.X(), a.Y() - b.Y());
    }

    public static Vector2D multiply(Vector2D a, Vector2D b)
    {
        return new Vector2D(a.X() * b.X(), a.Y() * b.Y());
    }


    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
