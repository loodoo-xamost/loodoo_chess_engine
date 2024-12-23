package fr.xamost.chesslib.object.board;

import fr.xamost.chesslib.math.BoardCoordsTuples;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.board.square.SquareObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.*;

public class BoardObject
{
    private HashMap<String,SquareObject []> boardMap;
    public ArrayList<SquareObject> boardSquaresList;
    private final int xOffset;
    private final int yOffset;
    private final int boardSize;

    public BoardObject()
    {
        this.xOffset = 0;
        this.yOffset = 0;
        this.boardSize = BOARD_SIZE;
        this.boardSquaresList = new ArrayList<>();
        generateBoardMap();
    }

    public BoardObject(int squareOffset)
    {
        this.xOffset = squareOffset;
        this.yOffset = squareOffset;
        this.boardSize = BOARD_SIZE;
        this.boardSquaresList = new ArrayList<>();
        generateBoardMap();
    }

    public BoardObject(int xOffset, int yOffset)
    {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.boardSize = BOARD_SIZE;
        generateBoardMap();
    }

    private void generateBoardMap()
    {
        this.boardMap = new HashMap<>();
        for(int i = 0; i < this.boardSize; i++)
        {
            this.boardMap.put(BASE_ROW_INDEX[i], generateBoardRow(i));
        }

    }

    private SquareObject[] generateBoardRow(int RowIndex)
    {
        SquareObject[] boardRow = new SquareObject[this.boardSize];
        for(int i = 0; i < this.boardSize; i++)
        {
            boardRow[i] = new SquareObject(new Vector2D(this.xOffset+ (i * BOARD_SQUARE_SIZE), this.yOffset + (RowIndex * BOARD_SQUARE_SIZE)), SQUARE_COLORS[(i+RowIndex)%2], new BoardCoordsTuples(BoardCoordsTuples.genColStr(i), RowIndex));
            this.boardSquaresList.add(boardRow[i]);
        }
        return boardRow;
    }

    public void drawBoard()
    {
        for(Map.Entry<String,SquareObject []> entry : this.boardMap.entrySet())
        {
            for(SquareObject square : entry.getValue())
            {

                square.draw();
                //DrawText(entry.getKey(), square.getPosX(), square.getPosY(), 20, BLACK.getColor());
            }
        }
    }



    public HashMap<String,SquareObject []> getBoardMap()
    {
        return this.boardMap;
    }
    public ArrayList<SquareObject> getBoardSquaresList()
    {
        ArrayList<SquareObject> squaresList = new ArrayList<>();
        for(Map.Entry<String,SquareObject []> entry : this.boardMap.entrySet())
        {
            for(SquareObject square : entry.getValue())
            {
                squaresList.add(square);
            }
        }
        return squaresList;
    }

    public SquareObject getSquareByPosition(Vector2D position)
    {
        for(SquareObject square : this.boardSquaresList)
        {
            if(square.getPosition().X() == position.X() + BOARD_SQUARE_SIZE && square.getPosition().Y() == position.Y() + BOARD_SQUARE_SIZE)
            {
                return square;
            }
        }
        return null;
    }












    @Override
    public String toString()
    {
        return "Board : \nSettings : \nxOffset : " + this.xOffset + ", yOffset : " + this.yOffset + ", BoardSize : " + this.boardSize + "\n";
    }

    public void printBoardMapInfo()
    {
        for(Map.Entry<String, SquareObject[]> entry : this.boardMap.entrySet())
        {
            System.out.println(entry.getKey() + " : " + boardMapRowInfoToString(entry.getValue()));
        }
        System.out.println();
    }
    public void printBoardMapX()
    {
        for(Map.Entry<String, SquareObject[]> entry : this.boardMap.entrySet())
        {
            System.out.println(entry.getKey() + " : " + boardMapRowToStringX(entry.getValue()));
        }
        System.out.println();
    }

    public String boardMapRowToStringX(SquareObject[] boardRow)
    {
        return "[x]".repeat(boardRow.length);
    }

    public String boardMapRowInfoToString(SquareObject[] boardRow)
    {
        int i = 0;
        StringBuilder result = new StringBuilder();
        result.append("[\n");
        for(SquareObject square : boardRow)
        {
            result.append("Index : ").append(i).append(" | ");
            result.append(square.toString()).append(",\n");
            i++;
        }
        result.append(" ]");
        return result.toString();
    }
}
