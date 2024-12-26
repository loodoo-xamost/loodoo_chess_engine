package fr.xamost.chesslib.events.game.piece.check;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.Game;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.piece.PieceSides;

public class CheckEvent implements Event
{
    private final GameManager instance;
    public CheckEvent()
    {
        this.instance = App.game.manager;
        Callback();
    }

    @Override
    public void Callback()
    {
        if(this.instance.currentSide == PieceSides.WHITE)
        {
            this.instance.setBlackKingInCheck(true);
        }
        if(this.instance.currentSide == PieceSides.BLACK)
        {
            this.instance.setWhiteKingInCheck(true);
        }
        this.instance.checkingPiece = this.instance.selectedPiece;
    }

    @Override
    public void StatTrace() {

    }
}
