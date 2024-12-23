package fr.xamost.chesslib.object.board.utils;


import fr.xamost.chesslib.render.utils.XColor;

public class BoardGlobals
{
    public static String[] BASE_ROW_INDEX = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static int BOARD_OFFSET = 50;
    public static int BOARD_SIZE = 8;

    public static int BOARD_SQUARE_SIZE = 75;
    public static int BOARD_SQUARE_HALF_SIZE = BOARD_SQUARE_SIZE / 2;

    public static XColor SQUARE_PRIMARY_COLOR = new XColor(237, 237, 209);
    public static XColor SQUARE_SECONDARY_COLOR = new XColor(117, 147, 84);
    public static XColor[] SQUARE_COLORS = {SQUARE_PRIMARY_COLOR, SQUARE_SECONDARY_COLOR};
}
