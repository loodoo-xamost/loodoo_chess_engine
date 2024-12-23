package fr.xamost.chesslib.render.window;


import static com.raylib.Raylib.*;
import static fr.xamost.chesslib.render.window.WindowGlobals.*;

public class WindowManager
{


    public WindowManager()
    {
        InitWindow(WIDTH, HEIGHT, WINDOW_TITLE);
        SetTargetFPS(TARGET_FPS);
    }

    public boolean windowShouldClose()
    {
        return WindowShouldClose();
    }

    public void Close()
    {
        CloseWindow();
    }

    public void DrawStart()
    {
        BeginDrawing();
    }

    public void DrawStop()
    {
        EndDrawing();
    }
}
