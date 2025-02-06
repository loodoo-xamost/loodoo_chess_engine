package fr.xamost.chesslib.frame.game.playing.gui;

import fr.xamost.chesslib.frame.game.playing.gui.panel.GameInfoPanel;
import fr.xamost.chesslib.gui.GUI;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.utils.XColor;

public class GameGUI extends GUI
{
    private GameInfoPanel gameInfoPanel;
    @Override
    public void init() {
        this.gameInfoPanel = new GameInfoPanel(new Vector2D(700, 50),new XColor(50, 50, 50, 255), new Vector2D(325, 600));
        this.gameInfoPanel.init();
    }

    @Override
    public void update() {
        this.gameInfoPanel.update();
    }

    @Override
    public void draw() {
        this.gameInfoPanel.draw();
    }
}
