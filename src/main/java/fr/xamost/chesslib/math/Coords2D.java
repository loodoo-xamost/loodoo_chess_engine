package fr.xamost.chesslib.math;

import static fr.xamost.chesslib.object.board.utils.BoardGlobals.*;

public class Coords2D
{
    public static int integerToIndex(int x)
    {
        return ((x + (BOARD_OFFSET/2) )/ BOARD_SQUARE_SIZE)-1;
    }
}
