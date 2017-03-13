package guithings;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class editMachineGUI extends JFrame{
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 300;
    private Container pane;
    private JFrame frame;
    private HomeGUI homeGUI;
    private  boolean glassBottleBool;
    JToggleButton glassBottleButton;
    private boolean[] buttonBool;
    private JToggleButton[] toggleButtons;
    private String[] buttonLabels = {"Glass Bottle", "Metal Can", "Metal Foil", "Paper Plate", "Paper Sheet",
        "Plastic Bottle", "Plastic Utensil"};

    public editMachineGUI(HomeGUI homeGUI) {
        this.homeGUI = homeGUI;
        frame = new JFrame("Edit Recycling Machine Window");

        pane = frame.getContentPane();
        //Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);

        createTitle();
        createInstructions();
        buttonBool = new boolean[7];
        toggleButtons = new JToggleButton[7];

        createButton(0,10,50);
        createButton(1,10+150,50);
        createButton(2,10+300,50);
        createButton(3,10+450,50);
        createButton(4,10,150);
        createButton(5,10+150,150);
        createButton(6,10+300,150);

}

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane,"Edit Recycling Machine", WINDOW_WIDTH);
    }

    private void createInstructions(){
        GeneralJStuff.createJTextLabel(pane,"Green: Enabled", 450,10,Color.green);
         GeneralJStuff.createJTextLabel(pane,"Red: Disabled", 450,30,Color.red);
    }

    private void createButton(int index, int x, int y){
        toggleButtons[index] = new JToggleButton(buttonLabels[index], buttonBool[index]);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                buttonBool[index] = !buttonBool[index];
                if(buttonBool[index]){
                    // Item enabled
                    toggleButtons[index].setForeground(Color.GREEN);
                    //todo Add implementation here
                }else{
                    //Item enabled
                    toggleButtons[index].setForeground(Color.RED);
                    //todo add implementation here
                }

            }
        };
        GeneralJStuff.createJToggleButton(pane,toggleButtons[index],x,y,150,75,r,buttonBool[index]);

    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }


}
