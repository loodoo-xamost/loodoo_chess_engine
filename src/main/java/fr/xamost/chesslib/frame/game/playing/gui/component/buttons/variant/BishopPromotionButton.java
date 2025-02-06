package fr.xamost.chesslib.frame.game.playing.gui.component.buttons.variant;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.game.piece.special.promotion.BishopPromotedEvent;
import fr.xamost.chesslib.frame.game.playing.gui.component.buttons.PromotionButton;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;

public class BishopPromotionButton extends PromotionButton {

    public BishopPromotionButton(PieceSides color, Vector2D graphicPosition, int size) {
        super(PieceTypes.BISHOP, color, graphicPosition, size);
    }

    @Override
    public void onClick()
    {
        new BishopPromotedEvent(App.game.manager);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }
}
