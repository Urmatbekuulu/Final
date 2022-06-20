import java.util.ArrayList;
import java.util.List;

public class Model {
    public int figureID = -1;
    public Figure figures[];
    Model(){
        figures = new Figure[3];
    }
}
class Figure{
    public String name;
    public List<Coordinates> coordinates = new ArrayList<Coordinates>();
}
class Coordinates{
    public Coordinates(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int x;
    public int y;
}