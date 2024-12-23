package fr.xamost.chesslib.events.game.piece;

import com.raylib.Raylib;
import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.Event;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.math.BoardCoordsTuples;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;

import java.util.Objects;

import static fr.xamost.chesslib.object.piece.handler.MoveHandler.isSame;

public class SelectingPieceEvent implements Event
{
    private final GameManager instance;
    private final Vector2D mouseCoords;
    public SelectingPieceEvent(GameManager instance)
    {
        this.instance = instance;
        this.mouseCoords = App.mouse.getMouseCoords();
        if( instance.selectedPiece == null)
            Callback();
    }
    @Override
    public void Callback()
    {
        StatTrace();
        for(Piece piece : instance.piecesOnBoard)
        {
            if(isSame(piece.position.boardCoords, mouseCoords) && piece.getPieceColor() == instance.currentSide)
            {
                this.instance.selectedPiece = piece;
                System.out.println(piece);
            }
        }


    }

    @Override
    public void StatTrace()
    {
        System.out.println("Selecting piece Event");

    }
}
