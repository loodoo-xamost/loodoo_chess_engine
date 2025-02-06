package fr.xamost.chesslib.game;


public class Game
{
    public GameManager manager;

    public Game()
    {

        manager = new GameManager();
    }

    public void initGame()
    {
        this.manager.initGame();

    }

    public void gameLoop()
    {
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


    public void updateGameGraphics()
    {
        this.manager.graphicUpdate();
    }
}
