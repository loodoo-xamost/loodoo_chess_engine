package fr.xamost.chesslib.object.board.setup;


import static fr.xamost.chesslib.object.board.setup.setup_matrix.SetupMatrix.*;

public enum BoardSetups
{
    EMPTY_BOARD(emptyChessBoard),
    CLASSIC_BOARD(classicChessBoard),
    TEST_EN_PASSANT(enPassantTest),
    TEST_CASTLE(castleTest),
    TEST_ROOK(rookTest),
    TEST_BISHOP(bishopTest),
    TEST_QUEEN(queenTest),
    TEST_PROMOTION(promotionTest),;

    private final String[][] boardSetups;

    private BoardSetups(String[][] boardSetups)
    {
        this.boardSetups = boardSetups;
    }

    public String[][] getBoardSetups() {
        return boardSetups;
    }
}
