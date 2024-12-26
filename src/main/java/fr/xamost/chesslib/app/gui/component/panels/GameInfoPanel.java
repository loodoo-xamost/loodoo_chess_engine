package fr.xamost.chesslib.app.gui.component.panels;

import fr.xamost.chesslib.app.gui.component.ClickableComponent;
import fr.xamost.chesslib.app.gui.component.buttons.promotion.BishopPromotionButton;
import fr.xamost.chesslib.app.gui.component.buttons.promotion.KnightPromotionButton;
import fr.xamost.chesslib.app.gui.component.buttons.promotion.QueenPromotionButton;
import fr.xamost.chesslib.app.gui.component.buttons.promotion.RookPromotionButton;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.game.GameState;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.render.utils.XColor;

import java.util.ArrayList;

import static com.raylib.Raylib.DrawText;
import static com.raylib.Colors.*;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public class GameInfoPanel extends Panel
{
    private GameManager instance;
    private QueenPromotionButton blackQueenPromotionButton, whiteQueenPromotionButton;
    private BishopPromotionButton blackBishopPromotionButton, whiteBishopPromotionButton;
    private KnightPromotionButton blackKnightPromotionButton, whiteKnightPromotionButton;
    private RookPromotionButton blackRookPromotionButton, whiteRookPromotionButton;
    public static ArrayList<ClickableComponent> clickableComponents;
    public GameInfoPanel(int x, int y, int width, int height, XColor color) {
        super(x, y, width, height, color);
    }

    public void init(GameManager instance)
    {
        this.instance = instance;
        clickableComponents = new ArrayList<>();

        this.blackQueenPromotionButton = new QueenPromotionButton(PieceSides.BLACK, new Vector2D(720, 100), BOARD_SQUARE_SIZE);
        clickableComponents.add(blackQueenPromotionButton);

        this.blackBishopPromotionButton = new BishopPromotionButton(PieceSides.BLACK, new Vector2D(720, 180), BOARD_SQUARE_SIZE);
        clickableComponents.add(blackBishopPromotionButton);

        this.blackKnightPromotionButton = new KnightPromotionButton(PieceSides.BLACK, new Vector2D(720, 260), BOARD_SQUARE_SIZE);
        clickableComponents.add(blackKnightPromotionButton);

        this.blackRookPromotionButton = new RookPromotionButton(PieceSides.BLACK, new Vector2D(720, 340), BOARD_SQUARE_SIZE);
        clickableComponents.add(blackRookPromotionButton);


        this.whiteQueenPromotionButton = new QueenPromotionButton(PieceSides.WHITE, new Vector2D(720, 100), BOARD_SQUARE_SIZE);
        clickableComponents.add(whiteQueenPromotionButton);

        this.whiteBishopPromotionButton = new BishopPromotionButton(PieceSides.WHITE, new Vector2D(720, 180), BOARD_SQUARE_SIZE);
        clickableComponents.add(whiteBishopPromotionButton);

        this.whiteKnightPromotionButton = new KnightPromotionButton(PieceSides.WHITE, new Vector2D(720, 260), BOARD_SQUARE_SIZE);
        clickableComponents.add(whiteKnightPromotionButton);

        this.whiteRookPromotionButton = new RookPromotionButton(PieceSides.WHITE, new Vector2D(720, 340), BOARD_SQUARE_SIZE);
        clickableComponents.add(whiteRookPromotionButton);
    }
    @Override
    public void draw()
    {

        super.draw();
        if(instance.getGameState() == GameState.PLAYING)
        {
            this.blackQueenPromotionButton.setEnabled(false);
            this.blackBishopPromotionButton.setEnabled(false);
            this.blackKnightPromotionButton.setEnabled(false);
            this.blackRookPromotionButton.setEnabled(false);

            this.whiteQueenPromotionButton.setEnabled(false);
            this.whiteBishopPromotionButton.setEnabled(false);
            this.whiteKnightPromotionButton.setEnabled(false);
            this.whiteRookPromotionButton.setEnabled(false);

            if(this.instance.currentSide == PieceSides.WHITE) {
                DrawText(this.instance.currentSide.name() + " turn !", 725, 100, 40, WHITE);
                if(this.instance.checkingPiece != null  && this.instance.checkingPiece.getPieceColor() == PieceSides.BLACK)
                {
                    DrawText( " king is in check !", 715, 135, 25, WHITE);
                }
            }
            if(this.instance.currentSide == PieceSides.BLACK) {
                DrawText(this.instance.currentSide.name() + " turn !", 725, 550, 40, WHITE);
                if(this.instance.checkingPiece != null  && this.instance.checkingPiece.getPieceColor() == PieceSides.WHITE)
                {
                    DrawText(" King is in check !", 715, 525, 25, WHITE);
                }
            }
        }
        if(instance.getGameState() == GameState.PROMOTION)
        {
            if(this.instance.currentSide == PieceSides.BLACK) {
                this.blackQueenPromotionButton.draw();
                this.blackQueenPromotionButton.setEnabled(true);

                this.blackBishopPromotionButton.draw();
                this.blackBishopPromotionButton.setEnabled(true);

                this.blackKnightPromotionButton.draw();
                this.blackKnightPromotionButton.setEnabled(true);

                this.blackRookPromotionButton.draw();
                this.blackRookPromotionButton.setEnabled(true);
            }
            if(this.instance.currentSide == PieceSides.WHITE)
            {
                this.whiteQueenPromotionButton.draw();
                this.whiteQueenPromotionButton.setEnabled(true);

                this.whiteBishopPromotionButton.draw();
                this.whiteBishopPromotionButton.setEnabled(true);

                this.whiteKnightPromotionButton.draw();
                this.whiteKnightPromotionButton.setEnabled(true);

                this.whiteRookPromotionButton.draw();
                this.whiteRookPromotionButton.setEnabled(true);
            }

        }
    }
}
