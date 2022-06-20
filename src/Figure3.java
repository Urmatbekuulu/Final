import javax.swing.*;
import java.awt.*;

public class Figure3 extends JPanel implements MyPanel {
    @Override
    public void drawFigure(DisplayGraphics g, Figure[] figures) {
        g.figure = figures[2];
        g.repaint();
    }
}
