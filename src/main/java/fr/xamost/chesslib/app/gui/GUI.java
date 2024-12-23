package fr.xamost.chesslib.app.gui;

import fr.xamost.chesslib.game.GameManager;

public interface GUI
{
    public void init();

    public void init(GameManager gameInstance);

    public void draw();
}
