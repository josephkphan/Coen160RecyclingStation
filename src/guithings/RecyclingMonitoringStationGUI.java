package guithings;

import java.awt.*;
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
