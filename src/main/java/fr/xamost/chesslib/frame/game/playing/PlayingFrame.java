package fr.xamost.chesslib.frame.game.playing;

import fr.xamost.chesslib.frame.Frame;
import fr.xamost.chesslib.frame.game.playing.gui.GameGUI;
import fr.xamost.chesslib.game.GameManager;

import static com.raylib.Raylib.ClearBackground;
import static fr.xamost.chesslib.render.utils.XStaticColor.BLACK;

public class PlayingFrame extends Frame
{
    public GameManager gameInstance;
    public PlayingFrame(GameManager gameInstance)
    {
        super(new GameGUI(), BLACK);
        this.gameInstance = gameInstance;
    }

    @Override
    public void init()
    {
        this.guiManager.init();
    }

    @Override
    public void update()
    {
        this.guiManager.update();
    }

    @Override
    public void draw()
    {
        ClearBackground(this.backgroundColor);
        this.guiManager.draw();
    }
}
