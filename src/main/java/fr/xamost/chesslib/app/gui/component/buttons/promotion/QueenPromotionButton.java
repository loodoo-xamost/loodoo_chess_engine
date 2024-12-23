package fr.xamost.chesslib.app.gui.component.buttons.promotion;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.app.gui.component.buttons.promotionButton;
import fr.xamost.chesslib.events.game.piece.special.promotion.QueenPromotedEvent;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;

public class QueenPromotionButton extends promotionButton
{

    public QueenPromotionButton(PieceSides pieceSides, Vector2D position, int size) {
        super(PieceTypes.QUEEN, pieceSides, position, size);
    }

    @Override
    public void callback() {
        new QueenPromotedEvent(App.game.manager);
    }
}
