import javax.swing.*;

public class GraphicPanel extends JPanel implements MyPanel {

    @Override
    public void drawFigure(DisplayGraphics g, Figure[] figures) {
        g.repaint();
    }
}
