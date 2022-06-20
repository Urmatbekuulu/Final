import javax.swing.*;
import java.awt.*;

public class Figure1 extends JPanel implements MyPanel {
    @Override
    public void drawFigure(DisplayGraphics g, Figure[] figures) {
        g.figure = figures[0];
        g.repaint();



    }
}
