package fr.xamost.chesslib.object.board.setup;

import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.classics.bishop.Bishop;
import fr.xamost.chesslib.object.piece.classics.king.King;
import fr.xamost.chesslib.object.piece.classics.knight.Knight;
import fr.xamost.chesslib.object.piece.classics.pawn.Pawn;
import fr.xamost.chesslib.object.piece.classics.queen.Queen;
import fr.xamost.chesslib.object.piece.classics.rook.Rook;

import java.util.ArrayList;

public class initializePieces
{
    public static ArrayList<Piece> generatePieces(GameManager instance)
    {
        ArrayList<SquareObject> squaresList = instance.board.getBoardSquaresList();
        ArrayList<Piece> pieces = new ArrayList<>();
        int squareIndex = 0;
        for(String[] row : instance.boardSetups.getBoardSetups()) {
            for (String col : row) {
                Piece piece = null;
                switch (col) {
                    case "r":
                        piece = new Rook(instance, squaresList.get(squareIndex), PieceSides.BLACK);
                        break;
                    case "kn":
                        piece = new Knight(instance, squaresList.get(squareIndex), PieceSides.BLACK);
                        break;
                    case "b":
                        piece = new Bishop(instance, squaresList.get(squareIndex), PieceSides.BLACK);
                        break;
                    case "q":
                        piece = new Queen(instance, squaresList.get(squareIndex), PieceSides.BLACK);
                        break;
                    case "k":
                        piece = new King(instance, squaresList.get(squareIndex), PieceSides.BLACK);
                        break;
                    case "p":
                        piece = new Pawn(instance, squaresList.get(squareIndex), PieceSides.BLACK);
                        break;

                    case "x":
                        break;
                    case "R":
                        piece = new Rook(instance, squaresList.get(squareIndex), PieceSides.WHITE);
                        break;
                    case "KN":
                        piece = new Knight(instance, squaresList.get(squareIndex), PieceSides.WHITE);
                        break;
                    case "B":
                        piece = new Bishop(instance, squaresList.get(squareIndex), PieceSides.WHITE);
                        break;
                    case "Q":
                        piece = new Queen(instance, squaresList.get(squareIndex), PieceSides.WHITE);
                        break;
                    case "K":
                        piece = new King(instance, squaresList.get(squareIndex), PieceSides.WHITE);
                        break;
                    case "P":
                        piece = new Pawn(instance, squaresList.get(squareIndex), PieceSides.WHITE);
                        break;
                    default:
                        break;
                }
                if (piece != null)
                    pieces.add(piece);
                squareIndex++;
            }
        }
        return pieces;
    }

}
