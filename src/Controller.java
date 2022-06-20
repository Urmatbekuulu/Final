import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Controller implements ActionListener {
    Model model;
    View view;
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        addListeners();
    }

    private void addListeners(){
        view.drawGraphic.addActionListener(this);

        view.readFromFile.addActionListener(this);
        view.writeToFile.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Read from file":
                readFromFile();
                break;
            case "Write to file":
                readFromFile();
                writeToFile();
                break;
            case "Draw graphic":
                readFromFile();
                MyPanel graphic = view.figure1.isSelected()?new Figure1():view.figure2.isSelected()?new Figure2():view.figure3.isSelected()?new Figure3(): new GraphicPanel();
                graphic.drawFigure(view.g,model.figures);

                break;
            default:

                break;
        }

    }

    private void writeToFile() {

        String charset = "UTF-8";

        File file = new File("output.txt");
        PrintWriter writer;


        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        int counter = 0;
        FileInputStream fin = null;
        try {

            fin = new FileInputStream("input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));

            String line = br.readLine();

            while (line != null && counter<12) {

                if(model.figureID>0){
                    if((model.figureID-1)*4<=counter && (model.figureID-1)*4+4>counter){
                        writer.write(line+"\n");
                    }
                }

                counter++;

                line = br.readLine();
            }
            fin.close();
            br.close();
            writer.close();
        }
        catch (FileNotFoundException exception) {
            //view.errorField.setText("File Not Found");
            System.out.println("File not found");
        }
        catch (IOException exception) {
            // view.errorField.setText("IOException");
            System.out.println(exception.getMessage());
        }


    }
    private void readFromFile(){


        model.figureID = view.figure1.isSelected()?1:view.figure2.isSelected()?2:view.figure3.isSelected()?3:0;


        int counter = 1;
        FileInputStream fin = null;
        try {

            fin = new FileInputStream("input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));

            String line = br.readLine();

            while (line != null && counter<=12) {

                if(counter == 1){
                    model.figures[0] = new Figure();
                    model.figures[0].name = line;
                }
                else if(counter==2 || counter == 3 || counter ==4){
                    String[] attributes = line.split("[, (;)]+");
                    int tmpX,tmpY;
                    for(int i =1; i<attributes.length;i+=2){
                        try {

                            tmpX = Integer.parseInt(attributes[i]);
                            tmpY = Integer.parseInt(attributes[i+1]);

                          }
                        catch (Exception e) {
                        //view.errorField.setText("Exception: " + e);
                             break;
//                          }
                        }
                        model.figures[0].coordinates.add(new Coordinates(tmpX,tmpY));
                    }

                }
                if(counter == 5){
                    model.figures[1] = new Figure();
                    model.figures[1].name = line;
                }
                else if(counter==6 || counter == 7 || counter ==8){
                    String[] attributes = line.split("[, (;)]+");
                    int tmpX,tmpY;
                    for(int i =1; i<attributes.length;i+=2){
                        try {

                            tmpX = Integer.parseInt(attributes[i]);
                            tmpY = Integer.parseInt(attributes[i+1]);

                        }
                        catch (Exception e) {
                            //view.errorField.setText("Exception: " + e);
                            break;
//                          }
                        }
                        model.figures[1].coordinates.add(new Coordinates(tmpX,tmpY));
                    }

                }
                else if(counter == 9){
                    model.figures[2] = new Figure();
                    model.figures[2].name = line;
                }
                else if(counter==10 || counter == 11 || counter ==12){
                    String[] attributes = line.split("[, (;)]+");
                    int tmpX,tmpY;
                    for(int i =1; i<attributes.length;i+=2){
                        try {

                            tmpX = Integer.parseInt(attributes[i]);
                            tmpY = Integer.parseInt(attributes[i+1]);

                        }
                        catch (Exception e) {
                            //view.errorField.setText("Exception: " + e);
                            break;
//                          }
                        }
                        model.figures[2].coordinates.add(new Coordinates(tmpX,tmpY));
                    }
                }

                counter++;

                line = br.readLine();
            }
            fin.close();
            br.close();
        }
        catch (FileNotFoundException exception) {
            //view.errorField.setText("File Not Found");
            System.out.println("File not found");
        }
        catch (IOException exception) {
            // view.errorField.setText("IOException");
            System.out.println(exception.getMessage());
        }

    }
}
