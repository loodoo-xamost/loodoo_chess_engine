package fr.xamost.chesslib.frame.game.finished.gui.panel;

import fr.xamost.chesslib.gui.panel.RectPanel;
import fr.xamost.chesslib.math.Vector2D;
import fr.xamost.chesslib.render.utils.XColor;

public class FinishedPanel extends RectPanel
{

    public FinishedPanel(Vector2D position) {
        super(position);
    }

    public FinishedPanel(Vector2D position, XColor backgroundColor) {
        super(position, backgroundColor);
    }

    public FinishedPanel(Vector2D position, XColor backgroundColor, Vector2D size) {
        super(position, backgroundColor, size);
    }

    public FinishedPanel(Vector2D position, Vector2D size) {
        super(position, size);
    }

    @Override
    public void init() {

    }

    @Override
    public void draw() {

    }

    @Override
    public void update() {

    }
}
