package fr.xamost.chesslib.render.sprites;


import fr.xamost.chesslib.math.Vector2D;

import static com.raylib.Colors.WHITE;
import static com.raylib.Raylib.*;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;


public class Sprite2D
{
    private int x, y;
    private Rectangle source;
    private final Rectangle destination;
    private final Vector2 origin;
    private Texture texture;
    private final String imagePath;

    public Sprite2D(String ref, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.origin = new Vector2().x(x).y(y);
        this.imagePath = ref;
        this.destination = new Rectangle().x(origin.x()).y(origin.y()).width(BOARD_SQUARE_SIZE).height(BOARD_SQUARE_SIZE);

    }

    public Sprite2D(String ref, Vector2D position)
    {
        this.x = position.X();
        this.y = position.Y();
        this.origin = new Vector2().x(x).y(y);
        this.imagePath = ref;
        this.destination = new Rectangle().x(origin.x()).y(origin.y()).width(BOARD_SQUARE_SIZE).height(BOARD_SQUARE_SIZE);

    }

    public void initSprite2d()
    {
        Image image = LoadImage(imagePath);
        this.texture = LoadTextureFromImage(image);
        UnloadImage(image);
    }
    public void draw()
    {
        if(this.texture == null)
            initSprite2d();
        DrawTexture(this.texture, this.x, this.y, WHITE);
    }

    public void drawP()
    {
        if(this.texture == null)
            initSprite2d();
        DrawTextureEx(this.texture,origin, 0, 0.75f, WHITE);
    }

    public void unloadSprite()
    {
        UnloadTexture(this.texture);
    }

    public void updatePos(int x, int y)
    {
        setX(x);
        setY(y);
    }
    public void updatePos(Vector2D pos)
    {
        setX(pos.X());
        setY(pos.Y());
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.origin.x(x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.origin.y(y);
    }
}
