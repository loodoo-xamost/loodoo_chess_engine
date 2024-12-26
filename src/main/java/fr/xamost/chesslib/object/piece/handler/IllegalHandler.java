package fr.xamost.chesslib.object.piece.handler;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceTypes;

import static fr.xamost.chesslib.object.piece.handler.CheckHandler.isKingInDanger;

public class IllegalHandler
{
    public static boolean isIllegal(Piece king)
    {
        return isKingInDanger(king);
    }
}
