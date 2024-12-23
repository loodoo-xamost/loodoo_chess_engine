package fr.xamost.chesslib.game;

import fr.xamost.chesslib.input.game.GameInputManager;
import fr.xamost.chesslib.object.board.BoardObject;
import fr.xamost.chesslib.object.board.setup.BoardSetups;
import fr.xamost.chesslib.object.piece.Piece;
import fr.xamost.chesslib.object.piece.PieceSides;

import java.util.ArrayList;

import static fr.xamost.chesslib.object.board.setup.initializePieces.generatePieces;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_OFFSET;

public class GameManager
{
    public final GameManager instance;
    private GameState gameState;


    // gameObjects
    public BoardSetups boardSetups;

    public BoardObject board;

    public ArrayList<Piece> piecesOnBoard;
    public ArrayList<Piece> piecesOnBoardBeforeUpdate;

    public Piece selectedPiece;
    public Piece hittingPiece;
    public Piece lastMovedPiece;
    public PieceSides currentSide;
    public GameInputManager inputManager;
    public GameManager()
    {
        this.instance = this;
        this.gameState = GameState.NONE;
        this.inputManager = new GameInputManager(this);
    }

    public void initGame()
    {
        nextGameState();
        this.inputManager.init();
        this.board = new BoardObject(BOARD_OFFSET);
        boardSetups = BoardSetups.CLASSIC_BOARD;

        piecesOnBoard = generatePieces(this);
        this.selectedPiece = null;
        this.hittingPiece = null;
        this.lastMovedPiece = null;

        this.currentSide = PieceSides.WHITE;
        syncPieces();
        nextGameState();
    }

    public void logicUpdate()
    {
        inputManager.updateListeners();
    }

    public void graphicUpdate()
    {
        board.drawBoard();
        if(selectedPiece != null) {

            for (Piece piece : piecesOnBoard) {
                if (piece != selectedPiece)
                    piece.draw();
            }
            selectedPiece.draw();
        }else
        {
            for (Piece piece : piecesOnBoard) {
                piece.draw();
            }
        }


    }

    public void gameLoop()
    {
        if(gameState == GameState.PLAYING)
        {
            logicUpdate();
            graphicUpdate();
        }
    }


    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void nextGameState()
    {
        switch (gameState)
        {
            case NONE:
                this.gameState = GameState.INITIALISING;
            break;
            case INITIALISING:
                this.gameState = GameState.PLAYING;
            break;
            case PLAYING:
                this.gameState = GameState.FINISHED;
            case PAUSED:
                this.gameState = GameState.PLAYING;
            break;
            case FINISHED:
                this.gameState = GameState.DONE;
            default:
                this.gameState = GameState.NONE;
            break;

        }
    }

    private void syncPieces()
    {
        piecesOnBoardBeforeUpdate = new ArrayList<>(piecesOnBoard);
    }

    private void cancelPiecesUpdate()
    {
        piecesOnBoard = new ArrayList<>(piecesOnBoardBeforeUpdate);
    }

    public void changeSide()
    {
        if(this.currentSide == PieceSides.WHITE)
            this.currentSide = PieceSides.BLACK;
        else
            this.currentSide = PieceSides.WHITE;
    }
}
