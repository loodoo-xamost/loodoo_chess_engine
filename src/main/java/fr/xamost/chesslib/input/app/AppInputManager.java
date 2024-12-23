package fr.xamost.chesslib.input.app;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.input.app.listeners.AppMouseListener;
import fr.xamost.chesslib.input.inputManager;

public class AppInputManager implements inputManager
{
    private App appInstance;
    private AppMouseListener mouseListener;
    public AppInputManager(App appInstance)
    {
        this.appInstance = appInstance;
    }


    @Override
    public void init() {
        this.mouseListener = new AppMouseListener(appInstance);
    }

    @Override
    public void updateListeners()
    {
        this.mouseListener.update();
    }
}
