package fr.xamost.chesslib.events.game.piece;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.math.Vector2D;

public class PieceDraggedEvent implements Event
{
    private GameManager instance;
    public PieceDraggedEvent(GameManager instance)
    {
        this.instance = instance;
        if(instance.selectedPiece != null)
            Callback();

    }

    @Override
    public void Callback()
    {
        instance.selectedPiece.position.updateGraphicPosFromCursor(App.mouse.getMousePos());
        //StatTrace();
    }

    @Override
    public void StatTrace() {
        System.out.println("Piece dragged Event");
    }
}
