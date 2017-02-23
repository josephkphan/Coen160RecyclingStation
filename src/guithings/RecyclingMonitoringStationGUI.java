package guithings;

import machine.RecyclingMachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class RecyclingMonitoringStationGUI extends JFrame {

    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 500;
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

        System.out.println(HomeGUI.getRecyclingMonitoringStation().getNumberOfRecyclingMachines());

    }

    private void createTitle() {
        JLabel homeLabel = new JLabel("Recycling Monitoring Station", JLabel.CENTER);
        homeLabel.setBounds(WINDOW_WIDTH / 2 - homeLabel.getPreferredSize().width / 2,
                paneInsets.top + 10, homeLabel.getPreferredSize().width, homeLabel.getPreferredSize().height);
        pane.add(homeLabel);
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }


}

class MachineInfoBar{
    private Container pane;
    private int x, y;
    private RecyclingMachine recyclingMachine;
    public MachineInfoBar(RecyclingMachine recyclingMachine, Container pane, int x, int y){
        this.pane = pane;
        this.x = x;
        this.y = y;
        this.recyclingMachine = recyclingMachine;
        createHeader();
    }

    private void createHeader(){
//        JLabel homeLabel = new JLabel("Recycling Monitoring Station", JLabel.CENTER);
//        homeLabel.setBounds(x,y, homeLabel.getPreferredSize().width, homeLabel.getPreferredSize().height);
//        pane.add(homeLabel);
        GeneralJStuff.createJTextLabel(pane,"Machines Info:", x,y);
    }

    private void createEmptyButton(){
        JButton button = new JButton("Empty");
        button.setBounds(x+50,y+50, 128,32);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recyclingMachine.empty();
            }
        });
        pane.add(button);
    }

}

class StationBar{
    public StationBar(int x, int y){

    }
    private void createHeader(){

    }
}
