package guithings;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddMachineGUI extends JFrame{
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 200;
    private Container pane;
    private JFrame frame;
    private static JTextField xField, yField;
    private JLabel checkLogin;
    private HomeGUI homeGUI;
    private RecyclingMonitoringStationGUI recyclingMonitoringStationGUI;
    public AddMachineGUI(HomeGUI homeGUI, RecyclingMonitoringStationGUI recyclingMonitoringStationGUI) {
        this.homeGUI = homeGUI;
        this.recyclingMonitoringStationGUI = recyclingMonitoringStationGUI;
        frame = new JFrame("Add Recycling Machine Window");

        pane = frame.getContentPane();
        //Size and display the window.
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT );
        frame.setVisible(true);
        pane.setLayout(null);

        createTitle();
        createXLabel();
        createYLabel();
        createAddButton();
        createCancelButton();
        checkText();
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane,"Add Recycling Machine", WINDOW_WIDTH);
    }

    private void createXLabel(){
        xField = new JTextField(10);
        GeneralJStuff.createJTextLabel(pane,"X Coord: ",50,  + 50);
        GeneralJStuff.createJTextField(pane, xField,150,  50);
    }

    private void createYLabel(){
        GeneralJStuff.createJTextLabel(pane,"Y Coord: ",+50, 75);
        yField = new JTextField(10);
        GeneralJStuff.createJTextField(pane, yField,150, 75);

    }

    private void checkText(){
        checkLogin = new JLabel("");
        checkLogin.setBounds(125, 100,200, 25);
        pane.add(checkLogin);
    }

    private void createAddButton() {
        Runnable r = () -> {
            String xString = xField.getText();
            String yString = yField.getText();
            try{
                int x = Integer.parseInt(xString);
                int y = Integer.parseInt(yString);
                if(x < 0 || x > 750 || y < 0 || y > 750){
                    throw new Exception();
                }
                homeGUI.addMachineToChange(x,800-y-210);
                homeGUI.actionPerformed(new ActionEvent(pane,0,""));
                recyclingMonitoringStationGUI.actionPerformed(new ActionEvent(pane,0,""));

                close();
            }catch(Exception e){
                checkLogin.setForeground(Color.red);
                checkLogin.setText("Invalid Input, Try Again");
            }

        };

        GeneralJStuff.createJTextButton(pane,"Add",150, 125,
                100,32,r);
    }
    private void createCancelButton() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                close();
            }
        };
        GeneralJStuff.createJTextButton(pane,"Cancel",25, 125,
                100,32,r);
    }


    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }



}
