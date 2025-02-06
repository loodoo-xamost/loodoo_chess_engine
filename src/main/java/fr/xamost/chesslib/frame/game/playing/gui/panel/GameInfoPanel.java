package fr.xamost.chesslib.frame.game.playing.gui.panel;

import fr.xamost.chesslib.app.App;
import fr.xamost.chesslib.frame.game.playing.gui.component.buttons.PromotionButton;
import fr.xamost.chesslib.frame.game.playing.gui.component.buttons.variant.*;
import fr.xamost.chesslib.game.GameManager;
import fr.xamost.chesslib.game.GameState;
import fr.xamost.chesslib.gui.component.interactive.ClickableComponent;
import fr.xamost.chesslib.gui.panel.RectPanel;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.object.piece.PieceSides;
import fr.xamost.chesslib.render.utils.XColor;

import java.util.ArrayList;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.DrawText;
import static fr.xamost.chesslib.object.board.utils.BoardGlobals.BOARD_SQUARE_SIZE;

public class GameInfoPanel extends RectPanel
{
    private static GameManager gameInstance;
    private QueenPromotionButton blackQueenPromotionButton, whiteQueenPromotionButton;
    private BishopPromotionButton blackBishopPromotionButton, whiteBishopPromotionButton;
    private KnightPromotionButton blackKnightPromotionButton, whiteKnightPromotionButton;
    private RookPromotionButton blackRookPromotionButton, whiteRookPromotionButton;
    public static ArrayList<PromotionButton> promotionButtons;
    public static ArrayList<ClickableComponent> clickableComponents;


    public GameInfoPanel(Vector2D position) {
        super(position);
        gameInstance = App.game.manager;
        clickableComponents = new ArrayList<>();
        promotionButtons = new ArrayList<>();
    }

    public GameInfoPanel(Vector2D position, XColor backgroundColor) {
        super(position, backgroundColor);
        gameInstance = App.game.manager;
        clickableComponents = new ArrayList<>();
        promotionButtons = new ArrayList<>();
    }

    public GameInfoPanel(Vector2D position, XColor backgroundColor, Vector2D size) {
        super(position, backgroundColor, size);
        gameInstance = App.game.manager;
        clickableComponents = new ArrayList<>();
        promotionButtons = new ArrayList<>();
    }

    public GameInfoPanel(Vector2D position, Vector2D size) {
        super(position, size);
        gameInstance = App.game.manager;
        clickableComponents = new ArrayList<>();

        promotionButtons = new ArrayList<>();
    }

    @Override
    public void init()
    {
        initPromotion();
    }

    @Override
    public void draw()
    {
        if(gameInstance.getGameState() == GameState.PLAYING)
        {
            DrawText(gameInstance.currentSide.name() + " turn !", 725, 100, 40, WHITE);
            if(gameInstance.checkingPiece != null  && gameInstance.checkingPiece.getPieceColor() != gameInstance.currentSide)
                DrawText( " king is in check !", 715, 135, 25, RED);
        }
        if(gameInstance.getGameState() == GameState.PROMOTION)
        {
            if(gameInstance.currentSide == PieceSides.BLACK)
            {
            this.blackQueenPromotionButton.draw();
            this.blackBishopPromotionButton.draw();
            this.blackKnightPromotionButton.draw();
            this.blackRookPromotionButton.draw();
            }
            if(gameInstance.currentSide == PieceSides.WHITE) {
                this.whiteQueenPromotionButton.draw();
                this.whiteBishopPromotionButton.draw();
                this.whiteKnightPromotionButton.draw();
                this.whiteRookPromotionButton.draw();
            }
        }
    }

    @Override
    public void update()
    {
        if(gameInstance.getGameState() == GameState.PLAYING) {
            this.blackQueenPromotionButton.setClickable(false);
            this.blackQueenPromotionButton.setVisible(false);
            this.blackBishopPromotionButton.setClickable(false);
            this.blackBishopPromotionButton.setVisible(false);
            this.blackKnightPromotionButton.setClickable(false);
            this.blackKnightPromotionButton.setVisible(false);
            this.blackRookPromotionButton.setClickable(false);
            this.blackRookPromotionButton.setVisible(false);

            this.whiteQueenPromotionButton.setClickable(false);
            this.whiteQueenPromotionButton.setVisible(false);
            this.whiteBishopPromotionButton.setClickable(false);
            this.whiteBishopPromotionButton.setVisible(false);
            this.whiteKnightPromotionButton.setClickable(false);
            this.whiteKnightPromotionButton.setVisible(false);
            this.whiteRookPromotionButton.setClickable(false);
            this.whiteRookPromotionButton.setVisible(false);
        }
        if(gameInstance.getGameState() == GameState.PROMOTION)
        {
            this.blackQueenPromotionButton.setClickable(true);
            this.blackQueenPromotionButton.setVisible(true);
            this.blackBishopPromotionButton.setClickable(true);
            this.blackBishopPromotionButton.setVisible(true);
            this.blackKnightPromotionButton.setClickable(true);
            this.blackKnightPromotionButton.setVisible(true);
            this.blackRookPromotionButton.setClickable(true);
            this.blackRookPromotionButton.setVisible(true);

            this.whiteQueenPromotionButton.setClickable(true);
            this.whiteQueenPromotionButton.setVisible(true);
            this.whiteBishopPromotionButton.setClickable(true);
            this.whiteBishopPromotionButton.setVisible(true);
            this.whiteKnightPromotionButton.setClickable(true);
            this.whiteKnightPromotionButton.setVisible(true);
            this.whiteRookPromotionButton.setClickable(true);
            this.whiteRookPromotionButton.setVisible(true);
        }
    }

    private void initPromotion()
    {
        this.blackQueenPromotionButton = new QueenPromotionButton(PieceSides.BLACK, new Vector2D(720, 100), BOARD_SQUARE_SIZE);
        clickableComponents.add(blackQueenPromotionButton);
        promotionButtons.add(blackQueenPromotionButton);

        this.blackBishopPromotionButton = new BishopPromotionButton(PieceSides.BLACK, new Vector2D(720, 180), BOARD_SQUARE_SIZE);
        clickableComponents.add(blackBishopPromotionButton);
        promotionButtons.add(blackBishopPromotionButton);

        this.blackKnightPromotionButton = new KnightPromotionButton(PieceSides.BLACK, new Vector2D(720, 260), BOARD_SQUARE_SIZE);
        clickableComponents.add(blackKnightPromotionButton);
        promotionButtons.add(blackKnightPromotionButton);

        this.blackRookPromotionButton = new RookPromotionButton(PieceSides.BLACK, new Vector2D(720, 340), BOARD_SQUARE_SIZE);
        clickableComponents.add(blackRookPromotionButton);
        promotionButtons.add(blackRookPromotionButton);


        this.whiteQueenPromotionButton = new QueenPromotionButton(PieceSides.WHITE, new Vector2D(720, 100), BOARD_SQUARE_SIZE);
        clickableComponents.add(whiteQueenPromotionButton);
        promotionButtons.add(whiteQueenPromotionButton);

        this.whiteBishopPromotionButton = new BishopPromotionButton(PieceSides.WHITE, new Vector2D(720, 180), BOARD_SQUARE_SIZE);
        clickableComponents.add(whiteBishopPromotionButton);
        promotionButtons.add(whiteBishopPromotionButton);

        this.whiteKnightPromotionButton = new KnightPromotionButton(PieceSides.WHITE, new Vector2D(720, 260), BOARD_SQUARE_SIZE);
        clickableComponents.add(whiteKnightPromotionButton);
        promotionButtons.add(whiteKnightPromotionButton);

        this.whiteRookPromotionButton = new RookPromotionButton(PieceSides.WHITE, new Vector2D(720, 340), BOARD_SQUARE_SIZE);
        clickableComponents.add(whiteRookPromotionButton);
        promotionButtons.add(whiteRookPromotionButton);
    }
}
