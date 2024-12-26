package fr.xamost.chesslib.object.board.setup.setup_matrix;

public class SetupMatrix
{
    public static final String[][] emptyChessBoard = {
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
    };

    public static final String[][] classicChessBoard = {
            {"r","kn","b","q","k","b","kn","r"},
            {"p","p","p","p","p","p","p","p"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"P","P","P","P","P","P","P","P"},
            {"R","KN","B","Q","K","B","KN","R"},
    };

    public static final String[][] enPassantTest = {
            {"x","x","x","x","x","x","x","x"},
            {"p","p","p","p","p","p","p","p"},
            {"x","x","x","x","x","x","x","x"},
            {"x","P","x","x","x","x","x","x"},
            {"x","x","x","x","p","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"P","P","P","P","P","P","P","P"},
            {"x","x","x","x","x","x","x","x"},
    };

    public static final String[][] castleTest = {
            {"r","x","x","x","k","x","x","r"},
            {"p","p","p","p","p","p","p","p"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"P","P","P","P","P","P","P","P"},
            {"R","x","x","x","K","x","x","R"},
    };

    public static final String[][] rookTest = {
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","R","x","x","x","x"},
            {"x","x","x","x","r","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"k","x","x","x","x","x","x","K"},
    };
    public static final String[][] bishopTest = {
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","B","x","x","x","x"},
            {"x","x","x","x","b","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"k","x","x","x","x","x","x","K"},
    };
    public static final String[][] queenTest = {
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","Q","x","x","x","x"},
            {"x","x","x","x","q","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"k","x","x","x","x","x","x","K"},
    };
    public static final String[][] promotionTest = {
            {"x","x","x","x","x","x","x","x"},
            {"P","P","P","P","P","P","P","P"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"x","x","x","x","x","x","x","x"},
            {"p","p","p","p","p","p","p","p"},
            {"x","x","x","x","x","x","x","x"},
    };
}
