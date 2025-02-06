package fr.xamost.chesslib.frame.game.playing.gui.component.buttons;

import fr.xamost.chesslib.gui.component.interactive.button.SquareButton;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;
import fr.xamost.chesslib.render.sprites.Sprite2D;
import fr.xamost.chesslib.render.utils.XColor;

import static fr.xamost.chesslib.object.piece.Piece.generateSpriteRef;
import static fr.xamost.chesslib.render.utils.XStaticColor.WHITE;

public abstract class PromotionButton extends SquareButton
{
    private PieceTypes pieceType;
    private PieceSides pieceSides;

    private final Sprite2D sprite;
    public PromotionButton(PieceTypes type, PieceSides color, Vector2D graphicPosition, int size) {
        super(graphicPosition,WHITE, size);
        this.pieceType = type;
        this.pieceSides = color;
        this.sprite = new Sprite2D(generateSpriteRef(this.pieceSides, this.pieceType), this.getGraphicPosition().X(), this.getGraphicPosition().Y());
    }

    @Override
    public void draw() {
        this.getTexture().draw();
        this.sprite.drawP();
    }
}
