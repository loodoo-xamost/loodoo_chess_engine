package fr.xamost.chesslib.object.piece.classics.king;

import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.classics.knight.CastlingType;
import fr.xamost.chesslib.object.piece.classics.rook.Rook;
import fr.xamost.chesslib.object.piece.handler.MoveHandler;
import fr.xamost.chesslib.object.piece.handler.PieceMoveHandler;

import java.util.ArrayList;

public class KingMoveHandler extends MoveHandler implements PieceMoveHandler
{
    @Override
    public boolean isValidMove() {
        return isPieceMove();
    }

    @Override
    public boolean isPieceMove() {
        return isHorizontalMove() || isVerticalMove() && isTargetOnBoard();
    }

    public boolean isHorizontalMove()
    {
        return Math.abs(this.instance.position.boardCoords.X() - this.instance.position.boardPreCoords.X()) == 1;
    }
    public boolean isVerticalMove()
    {
        return Math.abs(this.instance.position.boardCoords.Y() - this.instance.position.boardPreCoords.Y()) == 1;
    }

    @Override
    public boolean isCastlingMove() {
        return  this.instance.position.boardCoords.Y() == this.instance.position.boardPreCoords.Y() &&
                this.instance.moveHandler.getMoveCount() == 0 &&
                (isBlackCastlingMove() || isWhiteCastlingMove());
    }

    public boolean isWhiteCastlingMove()
    {
        return instance.isWhite() && (isWhiteKingSideCastlingMove() || isWhiteQueenSideCastlingMove()) && !isPieceOneTargetStraightLine();
    }

    public boolean isWhiteKingSideCastlingMove()
    {
        return this.instance.position.boardCoords.X() == this.instance.position.boardPreCoords.X() + 2;
    }

    public boolean isWhiteQueenSideCastlingMove()
    {
        return this.instance.position.boardCoords.X() == this.instance.position.boardPreCoords.X() - 2;
    }
    public boolean isBlackCastlingMove()
    {
        return this.instance.isBlack() && (isBlackKingSideCastlingMove() || isBlackQueenCastlingMove());
    }
    public boolean isBlackKingSideCastlingMove()
    {
        return this.instance.position.boardCoords.X() == this.instance.position.boardPreCoords.X() + 2;
    }
    public boolean isBlackQueenCastlingMove()
    {
        return this.instance.position.boardCoords.X() == this.instance.position.boardPreCoords.X() - 2;
    }


    public static Piece getCaslingPiece(ArrayList<Piece> pieces, CastlingType type)
    {
        for(Piece piece : pieces)
        {
            if(type == CastlingType.WHITE_KING_SIDE)
            {
                if(piece.isWhite() && piece instanceof Rook && piece.position.boardCoords.X() == 7 && piece.position.boardCoords.Y() == 7 && piece.moveHandler.getMoveCount() == 0)
                {
                    return piece;
                }
            }

            if(type == CastlingType.WHITE_QUEEN_SIDE)
            {
                if(piece.isWhite() && piece instanceof Rook && piece.position.boardCoords.X() == 0 && piece.position.boardCoords.Y() == 7 && piece.moveHandler.getMoveCount() == 0)
                {
                    return piece;
                }
            }

            if(type == CastlingType.BLACK_KING_SIDE)
            {
                if(piece.isBlack() && piece instanceof Rook && piece.position.boardCoords.X() == 7 && piece.position.boardCoords.Y() == 0 && piece.moveHandler.getMoveCount() == 0)
                {
                    return piece;
                }
            }

            if(type == CastlingType.BLACK_QUEEN_SIDE)
            {
                if(piece.isBlack() && piece instanceof Rook && piece.position.boardCoords.X() == 0 && piece.position.boardCoords.Y() == 0 && piece.moveHandler.getMoveCount() == 0)
                {
                    return piece;
                }
            }

        }
        return null;
    }
}
