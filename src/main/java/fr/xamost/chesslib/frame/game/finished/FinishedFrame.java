package fr.xamost.chesslib.frame.game.finished;

import fr.xamost.chesslib.events.game.piece.check.FinishType;
import fr.xamost.chesslib.frame.Frame;
import fr.xamost.chesslib.frame.game.finished.gui.FinishedGUI;
import fr.xamost.chesslib.gui.GUI;
import fr.xamost.chesslib.render.utils.XColor;

import static fr.xamost.chesslib.render.utils.XStaticColor.BLACK;

public class FinishedFrame extends Frame
{
    private final FinishType type;
    public FinishedFrame(FinishType finishType) {
        super(new FinishedGUI(), BLACK);
        this.type = finishType;
    }

    @Override
    public void init()
    {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}
