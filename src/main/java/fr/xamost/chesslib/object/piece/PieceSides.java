package fr.xamost.chesslib.object.piece;

public enum PieceSides
{

    WHITE("white"),
    BLACK("black"),
    NONE(WHITE.sideRef);

    private final String sideRef;
    private PieceSides(String sideRef)
    {
        this.sideRef = sideRef;
    }

    public String getSideRef()
    {
        return sideRef;
    }
}
