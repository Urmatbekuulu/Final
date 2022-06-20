import java.awt.*;

public class DisplayGraphics extends Canvas{
    public Graphics g;
    public Figure figure;

    int scaleX, scaleY;
    int posX = 300, posY = 300;
    String buttonName;
    DisplayGraphics(){

    }
    public void paint(Graphics g) {
        this.g = g;
        drawScaleBack(g);
        if(figure!=null){
            drawFigure();
        }
    }
    private void drawFigure(){
        g.setColor(Color.BLACK);
        for(int i =0; i<figure.coordinates.size()-1;i++)
        {
            g.drawLine(figure.coordinates.get(i).x*30 + 300, 300 +figure.coordinates.get(i).y* 30,
                    figure.coordinates.get(i+1).x*30 + 300, 300 + figure.coordinates.get(i+1).y*30);
            //System.out.println("aaa");
        }
    }

    public void drawScaleBack(Graphics g) {

        g.setColor(Color.PINK);

        for (int j = 0; j <= posY; j += 30) {

            g.drawLine(0, j + posY, 600, j + posY);
            g.drawLine(0, posY - j, 600, posY - j);

        }
        for (int j = 0; j <= 600; j += 30) {

            g.drawLine(j , 0, j, 600);

        }

        g.setColor(Color.RED);
        g.drawLine(posX, 0, posX, 600);
        g.drawLine(0, posY, 600, posY);

    }


}
