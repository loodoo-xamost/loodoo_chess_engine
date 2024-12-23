package fr.xamost.chesslib.app;

import fr.xamost.chesslib.app.gui.GameGUI;
import fr.xamost.chesslib.game.Game;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.game.GameState;
import fr.xamost.chesslib.input.app.AppInputManager;
import fr.xamost.chesslib.input.object.Mouse;
import fr.xamost.chesslib.render.window.WindowManager;

public class App
{
    public static Mouse mouse;

    private WindowManager window;
    private AppInputManager inputManager;
    public static Game game;

    public App()
    {
        initApp();
        game = new Game();
        game.initGame();
    }
    public void initApp()
    {

        this.window = new WindowManager();
        mouse = new Mouse();
        this.inputManager = new AppInputManager(this);
        this.inputManager.init();
    }

    public void AppLoop()
    {
        while(!window.windowShouldClose())
        {
            logicUpdate();
            graphicUpdate();
        }
        closeApp();
    }

    private void graphicUpdate()
    {
        this.window.DrawStart();
        game.gameLoop();
        this.window.DrawStop();
    }

    private void logicUpdate()
    {
        this.inputManager.updateListeners();
    }
    private void closeApp()
    {
        window.Close();
    }
}
