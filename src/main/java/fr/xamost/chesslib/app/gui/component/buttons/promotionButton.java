package fr.xamost.chesslib.app.gui.component.buttons;

import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.board.square.SquareObject;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;
import fr.xamost.chesslib.render.shapes.ShapeRect;
import fr.xamost.chesslib.render.shapes.ShapeSquare;
import fr.xamost.chesslib.render.sprites.Sprite2D;
import fr.xamost.chesslib.render.utils.XColor;

import static fr.xamost.chesslib.object.piece.Piece.generateSpriteRef;
import static fr.xamost.chesslib.render.utils.XStaticColor.WHITE;

public class promotionButton extends Button
{
    private PieceTypes pieceType;
    private PieceSides pieceSides;

    private final Sprite2D sprite;
    private final ShapeSquare shapeSquare;

    public promotionButton(PieceTypes pieceType, PieceSides pieceSides, Vector2D position, int size)
    {
        super(position, size);
        this.pieceType = pieceType;
        this.pieceSides = pieceSides;
        this.shapeSquare = new ShapeSquare(this.getPosition(), this.getSize(), WHITE);
        this.sprite = new Sprite2D(generateSpriteRef(this.pieceSides, this.pieceType), this.getPosition().X(), this.getPosition().Y());
    }

    public void draw()
    {
        this.shapeSquare.draw();
        this.sprite.drawP();
    }


}
