import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    Model model;
    JPanel panel = new JPanel();
    public JButton readFromFile = new JButton("Read from file");
    public JButton writeToFile = new JButton("Write to file");
    public JButton drawGraphic = new JButton("Draw graphic");

    public JRadioButton figure1 = new JRadioButton("Figure 1");
    public JRadioButton figure2 = new JRadioButton("Figure 2");
    public JRadioButton figure3 = new JRadioButton("Figure 3");

    public DisplayGraphics g = new DisplayGraphics();
    View(Model model){

        this.model = model;

        figure1.setBounds(10, 10, 130, 30);
        figure2.setBounds(10, 50, 130, 30);
        figure3.setBounds(10, 90, 130, 30);

        ButtonGroup var7 = new ButtonGroup();
        var7.add(this.figure1);
        var7.add(this.figure2);
        var7.add(this.figure3);

        this.add(this.figure1);
        this.add(this.figure2);
        this.add(this.figure3);

        readFromFile.setBounds(10,150,130,30);
        writeToFile.setBounds(10,190,130,30);
        drawGraphic.setBounds(10,230,130,30);

        panel.add(readFromFile);
        panel.add(writeToFile);
        panel.add(drawGraphic);

        panel.add(g);
        panel.setLayout(null);


        this.add(panel, BorderLayout.CENTER);
        setSize(720,720);

        g.setBounds(150,10,605,605);
        g.repaint();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
