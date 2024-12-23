package fr.xamost.chesslib.object.piece;

public enum PieceTypes
{
    // enumeration of piece type
    PAWN("pawn", 1, false),
    ROOK("rook", 5, true),
    KNIGHT("knight", 3,false),
    KING("king", 50,false),
    BISHOP("bishop", 3,false),
    QUEEN("queen", 9,false);


    // private field to the String ref
    private final String pieceName;
    private final int absolutValue;
    private final boolean isCastlingPiece;
    private PieceTypes(String pieceName, int absolutValue, boolean isCastlingPiece)
    {
        this.pieceName = pieceName;
        this.absolutValue = absolutValue;
        this.isCastlingPiece = isCastlingPiece;
    }

    public String getPieceName()
    {
        return pieceName;
    }
    public int getAbsolutValue()
    {
        return absolutValue;
    }
    public boolean isCastlingPiece() {
        return isCastlingPiece;
    }
}
