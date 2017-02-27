package guithings;

import machine.RecyclingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecyclingMachineGUI extends JFrame {

        private static final int WINDOW_WIDTH = 1000;
        private static final int WINDOW_HEIGHT = 500;
        private Container pane;
        private JFrame frame;
        private HomeGUI homeGUI;

        private RecyclingMachine recyclingMachine;

        public RecyclingMachineGUI(HomeGUI homeGUI, RecyclingMachine recyclingMachine) {
            this.homeGUI = homeGUI;
            this.recyclingMachine = recyclingMachine;

            frame = new JFrame("Recycling Machine Window");

            pane = frame.getContentPane();
            //Size and display the window.
            Insets frameInsets = frame.getInsets();
            frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                    WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
            frame.setVisible(true);
            pane.setLayout(null);

            createTitle();

            System.out.println(homeGUI.getRecyclingMonitoringStation().getNumberOfRecyclingMachines());

        }

        private void createTitle() {
            JLabel homeLabel = new JLabel("Recycle Here!", JLabel.CENTER);
            homeLabel.setBounds(WINDOW_WIDTH / 2 - homeLabel.getPreferredSize().width / 2,
                    10, homeLabel.getPreferredSize().width, homeLabel.getPreferredSize().height);
            pane.add(homeLabel);
        }

        private void close() {
            frame.setVisible(false); //you can't see me!
            frame.dispose(); //Destroy the JFrame object
        }


}
