package fr.xamost.chesslib.object.piece.handler;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.game.piece.check.CheckEvent;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceTypes;
import fr.xamost.chesslib.object.piece.classics.king.King;

import static fr.xamost.chesslib.math.Vector2D.add;
import static fr.xamost.chesslib.math.Vector2D.diff;

public class CheckHandler
{
    public static boolean isKingInDanger(Piece king)
    {
        if(king.getPieceType() == PieceTypes.KING)
        {
            for(Piece piece : App.game.manager.piecesOnBoard)
            {
                if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(king.position.boardCoords))
                    return true;
            }
        }
        return false;
    }

    public static boolean isOpponentKingInCheck()
    {
        Piece king = App.game.manager.getOpositeColorKing();
        if(App.game.manager.selectedPiece.moveHandler.canMove(king.position.boardCoords))
        {
            new CheckEvent();
            return true;
        }
        else
        {
            App.game.manager.checkingPiece = null;
        }
        return false;
    }

    public static boolean isCheckmate()
    {
        King king = App.game.manager.getOpositeColorKing();
        Piece checkingPiece = App.game.manager.checkingPiece;
        if(kingCanMove(king))
        {
            return false;
        }
        else
        {
            Vector2D coordsDiff = diff(king.position.boardCoords, checkingPiece.position.boardCoords);
            if(coordsDiff.X() == 0)
            {
                if(checkingPiece.position.boardCoords.Y() < king.position.boardCoords.Y())
                {
                    for(int row = checkingPiece.position.boardCoords.Y() ; row < king.position.boardCoords.Y() ; row++)
                    {
                        for(Piece piece : App.game.manager.piecesOnBoard)
                        {
                            if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(new Vector2D(checkingPiece.position.boardCoords.X(), row)))
                            {
                                return false;
                            }
                        }
                    }
                }

                if(checkingPiece.position.boardCoords.Y() > king.position.boardCoords.Y())
                {
                    for(int row = checkingPiece.position.boardCoords.Y() ; row > king.position.boardCoords.Y() ; row--)
                    {
                        for(Piece piece : App.game.manager.piecesOnBoard)
                        {
                            if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(new Vector2D(checkingPiece.position.boardCoords.X(), row)))
                            {
                                return false;
                            }
                        }
                    }
                }

            } else if (coordsDiff.Y() == 0)
            {
                if(checkingPiece.position.boardCoords.X() < king.position.boardCoords.X())
                {
                    for(int col = checkingPiece.position.boardCoords.X() ; col < king.position.boardCoords.X() ; col++)
                    {
                        for(Piece piece : App.game.manager.piecesOnBoard)
                        {
                            if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(new Vector2D(col, checkingPiece.position.boardCoords.Y())))
                            {
                                return false;
                            }
                        }
                    }
                }
                if(checkingPiece.position.boardCoords.X() > king.position.boardCoords.X())
                {
                    for(int col = checkingPiece.position.boardCoords.X() ; col > king.position.boardCoords.X() ; col--)
                    {
                        for(Piece piece : App.game.manager.piecesOnBoard)
                        {
                            if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(new Vector2D(col, checkingPiece.position.boardCoords.Y())))
                            {
                                return false;
                            }
                        }
                    }
                }
                
            } else if (coordsDiff.X() == coordsDiff.Y())
            {
                if(checkingPiece.position.boardCoords.Y() < king.position.boardCoords.Y())
                {
                    if(checkingPiece.position.boardCoords.X() < king.position.boardCoords.X())
                    {
                        for(int col = checkingPiece.position.boardCoords.X(), row = checkingPiece.position.boardCoords.Y() ; col < king.position.boardCoords.X() ; col++, row++)
                        {
                            for(Piece piece : App.game.manager.piecesOnBoard)
                            {
                                if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(new Vector2D(col, row)))
                                {
                                    return false;
                                }
                            }
                        }
                    }
                    if(checkingPiece.position.boardCoords.X() > king.position.boardCoords.X())
                    {
                        for(int col = checkingPiece.position.boardCoords.X(), row = checkingPiece.position.boardCoords.Y() ; col > king.position.boardCoords.X() ; col--, row++)
                        {
                            for(Piece piece : App.game.manager.piecesOnBoard)
                            {
                                if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(new Vector2D(col, row)))
                                {
                                    return false;
                                }
                            }
                        }
                    }
                }
                if(checkingPiece.position.boardCoords.Y() > king.position.boardCoords.Y())
                {
                    if(checkingPiece.position.boardCoords.Y() < king.position.boardCoords.Y())
                    {
                        if(checkingPiece.position.boardCoords.X() < king.position.boardCoords.X())
                        {
                            for(int col = checkingPiece.position.boardCoords.X(), row = checkingPiece.position.boardCoords.Y() ; col < king.position.boardCoords.X() ; col++, row--)
                            {
                                for(Piece piece : App.game.manager.piecesOnBoard)
                                {
                                    if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(new Vector2D(col, row)))
                                    {
                                        return false;
                                    }
                                }
                            }
                        }
                        if(checkingPiece.position.boardCoords.X() > king.position.boardCoords.X())
                        {
                            for(int col = checkingPiece.position.boardCoords.X(), row = checkingPiece.position.boardCoords.Y() ; col > king.position.boardCoords.X() ; col--, row--)
                            {
                                for(Piece piece : App.game.manager.piecesOnBoard)
                                {
                                    if(piece != king && piece.getPieceColor() != king.getPieceColor() && piece.moveHandler.canMove(new Vector2D(col, row)))
                                    {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean kingCanMove(King king)
    {

        if(isValidMove(king, new Vector2D(-1, -1))){return true;}

        if(isValidMove(king, new Vector2D(0, -1))){return true;}
        if(isValidMove(king, new Vector2D(-1, 0))){return true;}

        if(isValidMove(king, new Vector2D(1, -1))){return true;}
        if(isValidMove(king, new Vector2D(-1, 1))){return true;}

        if(isValidMove(king, new Vector2D(1, 0))){return true;}
        if(isValidMove(king, new Vector2D(0, 1))){return true;}

        if(isValidMove(king, new Vector2D(1, 1))){return true;}
        return false;
    }

    private static boolean isValidMove(King king, Vector2D simulatedRelativePosition)
    {
        return king.moveHandler.canMove(add(king.position.boardCoords, simulatedRelativePosition));
    }
}
