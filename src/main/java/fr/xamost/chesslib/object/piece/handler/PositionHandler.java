package fr.xamost.chesslib.object.piece.handler;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;

import static fr.xamost.chesslib.math.Coords2D.integerToIndex;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.*;

public class PositionHandler
{
    private Piece instance;
    public Vector2D GraphicPosition;
    public Vector2D boardCoords, boardPreCoords;

    public PositionHandler(Piece instance, Vector2D squareGraphicPosition)
    {
        this.instance = instance;
        this.GraphicPosition = squareGraphicPosition;
        this.boardCoords = getCoordsFromGraphicPosition();
        syncBoardCoords();
    }

    public Vector2D getGraphicPosFromCoords()
    {
        return new Vector2D(getX(), getY());
    }

    public int getX()
    {
        return (boardCoords.X() * BOARD_SQUARE_SIZE)+BOARD_OFFSET;
    }

    public int getY()
    {
        return (boardCoords.Y() * BOARD_SQUARE_SIZE)+BOARD_OFFSET;
    }

    public Vector2D getCoordsFromGraphicPosition()
    {
        return new Vector2D(getCol(), getRow());
    }

    public int getCol()
    {
        return integerToIndex(this.GraphicPosition.X());
    }

    public int getRow()
    {
        return integerToIndex(this.GraphicPosition.Y());
    }

    public void syncBoardCoords()
    {
        this.boardPreCoords = this.boardCoords;
    }
    public void revertBoardCoords()
    {
        this.boardCoords = this.boardPreCoords;
        updateGraphicPosFromCurrentCoords();

    }

    public Vector2D getGraphicPosition()
    {
        return this.GraphicPosition;
    }

    public Vector2D getBoardCoords()
    {
        return this.boardCoords;
    }

    public void updateGraphicPos(Vector2D newPos)
    {
        this.GraphicPosition = newPos;
        this.instance.pieceSprite.updatePos(this.GraphicPosition);
    }
    public void updateGraphicPosFromCurrentCoords()
    {
        updateGraphicPos(getGraphicPosFromCoords());
    }

    public void updateGraphicPosFromCursor(Vector2D cursorPos)
    {
        updateGraphicPos(new Vector2D(cursorPos.X() - BOARD_SQUARE_HALF_SIZE, cursorPos.Y() - BOARD_SQUARE_HALF_SIZE));
    }

    public void updateBoardPos(Vector2D newCoords)
    {
        this.boardCoords = newCoords;
        this.GraphicPosition = getGraphicPosFromCoords();
        this.instance.pieceSprite.updatePos(this.GraphicPosition);
    }

    public boolean isOnLastRank()
    {
        if(this.instance.isBlack())
            return (this.boardCoords.Y() == 7);
        if (this.instance.isWhite())
            return (this.boardCoords.Y() == 0);
        return false;
    }
}
