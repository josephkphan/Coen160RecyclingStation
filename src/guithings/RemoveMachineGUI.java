package guithings;


import javax.swing.*;
import java.awt.*;

public class RemoveMachineGUI extends JFrame{
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 200;
    private Container pane;
    private Insets paneInsets;
    private JFrame frame;
    private static JTextField xField, yField;
    private JLabel checkLogin;

    public RemoveMachineGUI() {
        frame = new JFrame("Login Window");

        pane = frame.getContentPane();
        //Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);
        paneInsets = pane.getInsets();

        createTitle();
        createXLabel();
        createYLabel();
        createAddButton();
        createCancelButton();
        checkText();
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane,"Admin Login", WINDOW_WIDTH);
    }

    private void createXLabel(){
        xField = new JTextField(10);
        GeneralJStuff.createJTextLabel(pane,"X Coord: ",paneInsets.left+50, paneInsets.top + 50);
        GeneralJStuff.createJTextField(pane, xField,paneInsets.left+150, paneInsets.top + 50);
    }

    private void createYLabel(){
        GeneralJStuff.createJTextLabel(pane,"Y Coord: ",paneInsets.left+50, paneInsets.top + 75);
        yField = new JTextField(10);
        GeneralJStuff.createJTextField(pane, yField,paneInsets.left+150, paneInsets.top + 75);

    }

    private void checkText(){
        checkLogin = new JLabel("");
        checkLogin.setBounds(paneInsets.left+150, paneInsets.top + 100,200, 25);
        pane.add(checkLogin);
    }

    private void createAddButton() {
        Runnable r = () -> {
            String xString = xField.getText();
            String yString = yField.getText();
            try{
                int x = Integer.parseInt(xString);
                int y = Integer.parseInt(yString);
                if(x < 0 || x > 1500 || y < 0 || y > 1){
                    throw new Exception();
                }
                HomeGUI.getRecyclingMonitoringStation().addMachine(x,1500-y);
                HomeGUI.addRecyclingMachine(HomeGUI.getLastRecyclingMachine());
                close();
            }catch(Exception e){
                checkLogin.setForeground(Color.red);
                checkLogin.setText("Invalid Input, Try Again");
            }

        };

        GeneralJStuff.createJTextButton(pane,"Add",paneInsets.left+150, paneInsets.top+125,
                100,50,r);
    }
    private void createCancelButton() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                close();
            }
        };
        GeneralJStuff.createJTextButton(pane,"Cancel",paneInsets.left+25, paneInsets.top+125,
                100,50,r);
    }


    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }



}
