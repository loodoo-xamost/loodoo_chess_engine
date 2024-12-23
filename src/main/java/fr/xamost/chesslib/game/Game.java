package fr.xamost.chesslib.game;

import fr.xamost.chesslib.app.gui.GameGUI;

public class Game
{
    public GameGUI gui;
    public GameManager manager;

    public Game()
    {
        gui = new GameGUI();
        manager = new GameManager();
    }

    public void initGame()
    {
        this.manager.initGame();
        this.gui.init(this.manager);
    }

    public void gameLoop()
    {
        updateGameGUI();
        if(this.manager.getGameState() == GameState.PLAYING)
        {
            updateGameLogic();

        }
        updateGameGraphics();
    }
    public void updateGameLogic()
    {
        this.manager.logicUpdate();
    }

    public void updateGameGUI()
    {
        this.gui.draw();
    }

    public void updateGameGraphics()
    {
        this.manager.graphicUpdate();
    }
}
