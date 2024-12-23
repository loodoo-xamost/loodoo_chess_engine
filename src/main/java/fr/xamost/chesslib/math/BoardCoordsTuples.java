package fr.xamost.chesslib.math;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BASE_ROW_INDEX;

public class BoardCoordsTuples
{
    private String ColCoord;
    private int RowCoord;

    public BoardCoordsTuples(String colCoord, int rowCoord)
    {
        this.ColCoord = colCoord;
        this.RowCoord = rowCoord;
    }
    public BoardCoordsTuples(BoardCoordsTuples coords)
    {
        this.ColCoord = coords.Col();
        this.RowCoord = coords.Row();
    }
    public String Col() {
        return ColCoord;
    }

    public void Col(String colCoord) {
        ColCoord = colCoord;
    }

    public int Row() {
        return RowCoord;
    }

    public void Row(int rowCoord) {
        RowCoord = rowCoord;
    }

    public static String genColStr(int colIndex)
    {
        return BASE_ROW_INDEX[colIndex];
    }

    @Override
    public String toString()
    {
        return ColCoord + "," + RowCoord;
    }
}
