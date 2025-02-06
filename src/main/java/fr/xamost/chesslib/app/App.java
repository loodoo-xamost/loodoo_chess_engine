package fr.xamost.chesslib.app;

import fr.xamost.chesslib.frame.Frame;
import fr.xamost.chesslib.frame.game.playing.PlayingFrame;
import fr.xamost.chesslib.game.Game;
import fr.xamost.chesslib.input.app.AppInputManager;
import fr.xamost.chesslib.input.object.Mouse;
import fr.xamost.chesslib.render.window.WindowManager;

public class App
{
    public static Mouse mouse;
    public static App instance;
    private WindowManager window;
    private AppInputManager inputManager;
    public static Game game;
    public static Frame frame;

    public App()
    {
        initApp();
        game = new Game();
        game.initGame();
        frame = new PlayingFrame(game.manager);
        frame.init();
        instance = this;
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
        frame.draw();
        game.gameLoop();
        this.window.DrawStop();
    }

    private void logicUpdate()
    {
        frame.update();
        this.inputManager.updateListeners();
    }
    private void closeApp()
    {
        window.Close();
    }
}
