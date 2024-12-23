package fr.xamost.chesslib.game;

public enum GameState {
    INITIALISING(false),
    PLAYING(true),
    FINISHED(true),
    DONE(true),
    PAUSED(true),
    PROMOTION(true),
    NONE(false);

    private final boolean isInitialized;
    private GameState(boolean isInitialized)
    {
        this.isInitialized = isInitialized;
    }

    public boolean isInitialized() {
        return isInitialized;
    }
}