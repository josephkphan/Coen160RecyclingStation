package guithings;

import machine.RecyclingMachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class RecyclingMonitoringStationGUI extends JFrame {

    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 700;
    private static final int IMAGE_WIDTH = 128;
    private static final int IMAGE_HEIGHT = 128;
    private Container pane;
    private Insets paneInsets;
    private JFrame frame;

    public RecyclingMonitoringStationGUI() {
        frame = new JFrame("Recycling Monitoring Station Window");

        pane = frame.getContentPane();
        //Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);
        paneInsets = pane.getInsets();

        createTitle();
        createMachines();
        createAddMachineButton();
        createRemoveMachineButton();
//        System.out.println(HomeGUI.getRecyclingMonitoringStation().getNumberOfRecyclingMachines());

    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane, "Recycling Monitoring Station", WINDOW_WIDTH);
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }

    private void createMachines() {
        for(int i = 0; i < HomeGUI.getRecyclingMonitoringStation().getNumberOfRecyclingMachines(); i++){
            new MachineInfoBar(HomeGUI.getRecyclingMonitoringStation().getRecyclingMachine(i),
                    pane, 50 , 50 + 150 * i);

        }
    }

    private void createAddMachineButton(){
        Runnable r = () -> new AddMachineGUI();
        GeneralJStuff.createJTextButton(pane, "Add",  700, 10, 128, 32, r);

    }

    private void createRemoveMachineButton(){
        Runnable r = () -> new RemoveMachineGUI();
        GeneralJStuff.createJTextButton(pane, "Empty",900 , 10, 128, 32, r);

    }

}

class MachineInfoBar {
    private Container pane;
    private int x, y;
    private RecyclingMachine recyclingMachine;

    public MachineInfoBar(RecyclingMachine recyclingMachine, Container pane, int x, int y) {
        this.pane = pane;
        this.x = x;
        this.y = y;
        this.recyclingMachine = recyclingMachine;
        createHeader();
        createEmptyButton();
        createMachineLabels();
    }

    private void createHeader() {
        GeneralJStuff.createJTextLabel(pane, "Machines Info:", x, y);
    }

    private void createEmptyButton() {
        Runnable r = () -> recyclingMachine.empty();
        GeneralJStuff.createJTextButton(pane, "Empty", x + 500, y + 20, 128, 32, r);
    }

    private void createMachineLabels() {
        // Image
        GeneralJStuff.createJImage(pane, x + 5, y+ 20, 128, 128, "src/assets/machine.png");

        // ID
        GeneralJStuff.createJTextLabel(pane, "ID: " +
                Integer.toString(recyclingMachine.getId()), x + 150, y + 20);
        // Loads
        GeneralJStuff.createJTextLabel(pane, "Glass Load:    " +
                Integer.toString((int)recyclingMachine.getCurrentGlassLoad()), x+ 150, y + 40);
        GeneralJStuff.createJTextLabel(pane, "/ " +
                Integer.toString((int)recyclingMachine.getMaxGlassLoad()), x+ 300, y + 40);
        GeneralJStuff.createJTextLabel(pane, "Metal Load:    " +
                Integer.toString((int)recyclingMachine.getCurrentMetalLoad()), x+ 150, y + 60);
        GeneralJStuff.createJTextLabel(pane, "/ " +
                Integer.toString((int)recyclingMachine.getMaxMetalLoad()), x+ 300, y + 60);
        GeneralJStuff.createJTextLabel(pane, "Paper Load:   " +
                Integer.toString((int)recyclingMachine.getCurrentPaperLoad()), x+ 150, y + 80);
        GeneralJStuff.createJTextLabel(pane, "/ " +
                Integer.toString((int)recyclingMachine.getMaxPaperLoad()), x+300, y + 80);
        GeneralJStuff.createJTextLabel(pane, "Plastic Load:  " +
                Integer.toString((int)recyclingMachine.getCurrentPlasticLoad()), x+ 150, y + 100);
        GeneralJStuff.createJTextLabel(pane, "/ " +
                Integer.toString((int)recyclingMachine.getMaxPlasticLoad()), x+300, y + 100);

        JLabel label = new JLabel();
        if(recyclingMachine.getCurrentGlassLoad() >= 75 ||
                recyclingMachine.getCurrentPlasticLoad() >= 75 ||
                recyclingMachine.getCurrentMetalLoad() >= 75 ||
                recyclingMachine.getCurrentPaperLoad() >=75) {
            label.setText("Status: Go Empty");
            label.setForeground(Color.red);
        }else{
            label.setText("Status: Good");
            label.setForeground(Color.GREEN);
        }
        label.setBounds(x+ 200, y + 120, label.getPreferredSize().width, label.getPreferredSize().height);
        pane.add(label);
    }

}

class StationBar {
    public StationBar(int x, int y) {

    }

    private void createHeader() {

    }
}
