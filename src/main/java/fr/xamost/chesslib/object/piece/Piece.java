package fr.xamost.chesslib.object.piece;


import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.math.BoardCoordsTuples;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.handler.CaptureHandler;
import fr.xamost.chesslib.object.piece.handler.MoveHandler;
import fr.xamost.chesslib.object.piece.handler.PositionHandler;
import fr.xamost.chesslib.render.sprites.Sprite2D;

import static fr.xamost.chesslib.math.Coords2D.integerToIndex;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_HALF_SIZE;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public class Piece
{
    protected PieceSides pieceColor;
    protected PieceTypes pieceType;
    public final MoveHandler moveHandler;
    public final CaptureHandler captureHandler;

    public Sprite2D pieceSprite;

    // piece pos
    public PositionHandler position;

    protected BoardCoordsTuples pieceCoords;

    public GameManager gameInstance;


    public Piece(GameManager instance,SquareObject square, PieceTypes type, PieceSides side, MoveHandler moveHandler, CaptureHandler captureHandler) {
        this.gameInstance = instance;
        this.pieceColor = side;
        this.pieceType = type;
        this.moveHandler = moveHandler;
        this.captureHandler = captureHandler;

        this.position = new PositionHandler(this, square.getPosition());
        this.pieceCoords = square.getCoords();

        init();
    }

    private void init()
    {
        this.captureHandler.init(this);
        this.moveHandler.init(this);
        this.pieceSprite = new Sprite2D(generateSpriteRef(this.pieceColor, this.pieceType), position.getGraphicPosition());
    }


    public PieceSides getPieceColor() {
        return pieceColor;
    }

    public PieceTypes getPieceType() {
        return pieceType;
    }

    public BoardCoordsTuples getPieceCoords() {
        return pieceCoords;
    }

    public void draw()
    {
        this.pieceSprite.drawP();
    }


    public static String generateSpriteRef(PieceSides side, PieceTypes type) {
        return "resources/sprites/pieces/" + side.getSideRef() + "/" + side.getSideRef() + "-" + type.getPieceName() + ".png";
    }

    public boolean isWhite()
    {
        return this.pieceColor == PieceSides.WHITE;
    }
    public boolean isBlack()
    {
        return this.pieceColor == PieceSides.BLACK;
    }

    @Override
    public String toString()
    {
        return "Piece : " + this.pieceType.getPieceName() + " " + this.pieceColor.getSideRef() + " at " + this.position.toString();
    }

}
