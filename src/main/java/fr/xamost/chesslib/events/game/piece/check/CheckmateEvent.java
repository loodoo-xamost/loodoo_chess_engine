package fr.xamost.chesslib.events.game.piece.check;

import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.events.app.state.FrameToFinishEvent;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.game.GameState;

import static fr.xamost.chesslib.events.game.piece.check.FinishType.BLACK_WIN;
import static fr.xamost.chesslib.events.game.piece.check.FinishType.WHITE_WIN;

public class CheckmateEvent implements Event
{
    private final GameManager instance;
    public CheckmateEvent(GameManager instance)
    {
        this.instance = instance;
        Callback();
    }
    @Override
    public void Callback()
    {
        this.instance.setGameState(GameState.FINISHED);
        if(this.instance.getCurrentColorKing().isBlack())
            new FrameToFinishEvent(BLACK_WIN);
        if(this.instance.getCurrentColorKing().isWhite())
            new FrameToFinishEvent(WHITE_WIN);

        StatTrace();

    }

    @Override
    public void StatTrace() {
        System.out.println("Checkmate event");
    }
}
