package fr.xamost.chesslib.input.game;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.input.game.listeners.GameMouseListener;
import fr.xamost.chesslib.input.inputManager;

public class GameInputManager implements inputManager
{
    private final GameManager instance;
    private GameMouseListener mouseListener;
    public GameInputManager(GameManager gameManager)
    {
        this.instance = gameManager;
    }

    @Override
    public void init()
    {
        this.mouseListener = new GameMouseListener(this.instance);
    }

    @Override
    public void updateListeners()
    {
        this.mouseListener.update();
    }
}
