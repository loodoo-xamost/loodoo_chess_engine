package fr.xamost.chesslib.frame;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.gui.GUI;
import fr.xamost.chesslib.render.utils.XColor;

import java.util.ArrayList;

public abstract class Frame
{
    public App appInstance;
    public XColor backgroundColor;
    public GUI guiManager;
    public Frame(GUI guiManager, XColor backgroundColor)
    {
        this.guiManager = guiManager;
        this.backgroundColor = backgroundColor;
        this.appInstance = App.instance;
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw();

    public XColor getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(XColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public GUI getGuiManager() {
        return guiManager;
    }

    public void setGuiManager(GUI guiManager) {
        this.guiManager = guiManager;
    }
}
