package fr.xamost.chesslib.gui.component;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.utils.XColor;

import static fr.xamost.chesslib.render.utils.XStaticColor.WHITE;

public abstract class TextComponent
{
    private String text;
    private Vector2D graphicPosition;
    private XColor textColor;
    private int fontSize;

    public TextComponent(String text, Vector2D graphicPosition, XColor textColor, int fontSize)
    {
        this.text = text;
        this.graphicPosition = graphicPosition;
        this.textColor = textColor;
        this.fontSize = fontSize;
    }
    public TextComponent(String text, Vector2D graphicPosition, XColor textColor)
    {
        this.text = text;
        this.graphicPosition = graphicPosition;
        this.textColor = textColor;
        this.fontSize = 20;
    }
    public TextComponent(String text, Vector2D graphicPosition)
    {
        this.text = text;
        this.graphicPosition = graphicPosition;
        this.textColor = WHITE;
        this.fontSize = 20;
    }

    public abstract void draw();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Vector2D getGraphicPosition() {
        return graphicPosition;
    }

    public void setGraphicPosition(Vector2D graphicPosition) {
        this.graphicPosition = graphicPosition;
    }

    public XColor getTextColor() {
        return textColor;
    }

    public void setTextColor(XColor textColor) {
        this.textColor = textColor;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
