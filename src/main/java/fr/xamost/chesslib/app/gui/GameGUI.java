package fr.xamost.chesslib.app.gui;

import fr.xamost.chesslib.app.gui.component.buttons.promotion.QueenPromotionButton;
import fr.xamost.chesslib.app.gui.component.panels.GameInfoPanel;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.render.utils.XColor;

import static com.raylib.Colors.BLACK;
import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.DrawFPS;

public class GameGUI implements GUI
{
    private final GameInfoPanel gameInfoPanel;

    private GameManager gameInstance;
    public GameGUI()
    {
        this.gameInfoPanel = new GameInfoPanel(700, 50, 325, 600, new XColor(50, 50, 50, 255));
    }
    @Override
    public void init(GameManager gameInstance)
    {
        this.gameInstance = gameInstance;
        this.gameInfoPanel.init(gameInstance);

    }
    @Override
    public void init()
    {
    }

    @Override
    public void draw()
    {
        ClearBackground(BLACK);
        DrawFPS(1000, 20);
        gameInfoPanel.draw();
    }
}
