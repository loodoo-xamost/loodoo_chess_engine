package fr.xamost.chesslib.render.utils;

import com.raylib.Raylib.Color;

public class XColor extends Color
{
    private int r, g, b, a;
    private Color color;
    public XColor (int r, int g, int b, int a)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;

        initColor();
    }

    public XColor (int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;

        initColor();
    }

    private void initColor()
    {
        this.color = new Color().r((byte) r).g((byte) g).b((byte) b).a((byte) a);
    }

    public int getR() {
        return r;
    }

    public void setR(int r)
    {
        this.color.r((byte) r);
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g)
    {
        this.color.g((byte) g);
        this.g = g;
    }

    public int getB()
    {
        return b;
    }

    public void setB(int b)
    {
        this.color.b((byte) b);
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a)
    {
        this.color.a((byte) a);
        this.a = a;
    }

    public Color getColor()
    {
        return color;
    }

    @Override
    public String toString()
    {
        return "Color : Red : " + r + ", Green : " + g + ", Blue : " + b + ", Alpha : " + a;
    }
}
