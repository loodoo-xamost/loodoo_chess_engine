package fr.xamost.chesslib.frame.game.playing.gui.component.buttons.variant;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.events.game.piece.special.promotion.QueenPromotedEvent;
import fr.xamost.chesslib.frame.game.playing.gui.component.buttons.PromotionButton;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.object.piece.PieceTypes;

public class QueenPromotionButton extends PromotionButton
{

    public QueenPromotionButton(PieceSides pieceSides, Vector2D position, int size) {
        super(PieceTypes.QUEEN, pieceSides, position, size);
    }

    @Override
    public void onClick() {
        new QueenPromotedEvent(App.game.manager);
    }


    @Override
    public void init() {

    }

    @Override
    public void update() {

    }
}
