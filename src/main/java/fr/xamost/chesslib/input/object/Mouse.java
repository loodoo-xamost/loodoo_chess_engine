package fr.xamost.chesslib.input.object;

import com.raylib.Raylib;
import fr.xamost.chesslib.math.Vector2D;

import static com.raylib.Raylib.*;
import static fr.xamost.chesslib.math.Coords2D.integerToIndex;

public class Mouse
{
    private Vector2D position;
    private boolean leftClickPressed, leftClickReleased, rightClickPressed, rightClickReleased;

    public Mouse()
    {
        this.leftClickPressed = false;
        this.leftClickReleased = true;
        this.rightClickPressed = false;
        this.rightClickReleased = true;
    }

    public void init()
    {
        setMousePos();
    }
    public boolean isLeftClickPressed()
    {
        if(IsMouseButtonPressed(MOUSE_BUTTON_LEFT))
        {
            this.leftClickPressed = true;
            this.leftClickReleased = false;
            return true;
        }
        return false;
    }
    public boolean isLeftClickReleased()
    {
        if(IsMouseButtonReleased(MOUSE_BUTTON_LEFT))
        {
            this.leftClickPressed = false;
            this.leftClickReleased = true;
            return true;
        }
        return false;
    }

    public boolean isRightClickPressed()
    {
        if(IsMouseButtonPressed(MOUSE_BUTTON_RIGHT))
        {
            this.rightClickPressed = true;
            this.rightClickReleased = false;
            return true;
        }
        return false;
    }
    public boolean isRightClickReleased()
    {
        if(IsMouseButtonReleased(MOUSE_BUTTON_RIGHT))
        {
            this.rightClickPressed = false;
            this.rightClickReleased = true;
            return true;
        }
        return false;
    }



    public void setMousePos(Vector2D pos)
    {
        this.position = pos;
    }
    public void setMousePos(Raylib.Vector2 pos)
    {
        setMousePos( new Vector2D((int) pos.x(), (int) pos.y()));
    }
    public void setMousePos()
    {
        setMousePos(GetMousePosition());
    }

    public Vector2D getMousePos()
    {
        return position;
    }

    public Vector2D getMouseCoords()
    {
        return new Vector2D(integerToIndex(this.position.X()) , integerToIndex(this.position.Y()));
    }
}
