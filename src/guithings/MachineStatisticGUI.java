package guithings;


import machine.RecyclingMachine;

import javax.swing.*;
import java.awt.*;

public class MachineStatisticGUI extends  JFrame {
    private static final int WINDOW_WIDTH = 750;
    private static final int WINDOW_HEIGHT = 400;
    private Container pane;
    private JFrame frame;

    public MachineStatisticGUI(RecyclingMachine rm) {
        frame = new JFrame("Machine Statistics");

        pane = frame.getContentPane();
        //Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);

        createTitle();
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane, "Machine Statistics", WINDOW_WIDTH);
    }

    private void createCloseButton(){

    }
}
