package fr.xamost.chesslib.app.gui.component.buttons.promotion;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.app.gui.component.buttons.promotionButton;
import fr.xamost.chesslib.events.game.piece.special.promotion.RookPromotedEvent;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;

public class RookPromotionButton extends promotionButton
{
    public RookPromotionButton(PieceSides pieceSides, Vector2D position, int size) {
        super(PieceTypes.ROOK, pieceSides, position, size);
    }

    @Override
    public void callback() {
        new RookPromotedEvent(App.game.manager);
    }
}
