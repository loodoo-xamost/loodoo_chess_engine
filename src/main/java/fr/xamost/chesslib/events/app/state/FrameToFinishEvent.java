package fr.xamost.chesslib.events.app.state;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.events.game.piece.check.FinishType;
import fr.xamost.chesslib.frame.game.finished.FinishedFrame;

public class FrameToFinishEvent implements Event
{
    private final FinishType finishType;
    public FrameToFinishEvent(FinishType type)
    {
        this.finishType = type;
        Callback();
    }
    @Override
    public void Callback()
    {
        App.frame = new FinishedFrame(finishType);
    }

    @Override
    public void StatTrace()
    {
        System.out.println("FrameToFinishEvent");
    }
}
