import javax.swing.*;
import java.awt.*;

public class Figure2 extends JPanel implements MyPanel {
    @Override
    public void drawFigure(DisplayGraphics g, Figure[] figures) {
        g.figure = figures[1];
        g.repaint();    }
}
