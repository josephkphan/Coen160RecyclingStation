package guithings;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
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
        // Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);

        // Each iteration of this while
        recyclingMachine.startTransaction();
        createTitle();
        createCurrentLoadDisplay();
        createInsertButton();
        createCancelButton();
        createFinishButton();
        createItemsInsertedDisplay();

        System.out.println(homeGUI.getRecyclingMonitoringStation().getNumberOfRecyclingMachines());
    }

    private void createTitle() {
        JLabel homeLabel = new JLabel("Recycle Here!", JLabel.CENTER);
        homeLabel.setBounds(WINDOW_WIDTH / 2 - homeLabel.getPreferredSize().width / 2,
                10, homeLabel.getPreferredSize().width, homeLabel.getPreferredSize().height);
        pane.add(homeLabel);
    }

    private void createInsertButton() {
        Runnable r = () -> {
            System.out.println("Clicked Insert");
        };
        GeneralJStuff.createJTextButton(pane, "Insert Recyclable", 25, 50, 200, 25, r);
    }

    private void createCancelButton() {
        Runnable r = () -> {
            System.out.println("Clicked Cancel");
        };
        GeneralJStuff.createJTextButton(pane, "Cancel Transaction", 250, 50, 200, 25, r);
    }

    private void createFinishButton() {
        Runnable r = () -> {
            System.out.println("Clicked Finish");
            // Display a Coupon for the User

            // Clear out the RCM
            close();
        };
        GeneralJStuff.createJTextButton(pane, "Finished!", 700, 50, 200, 25, r);
    }

    private void createItemsInsertedDisplay() {
//        JPanel middlePanel = new JPanel ();
//        middlePanel.setBounds(50,50,500,500);
//
//        // create the middle panel components
//        JTextArea display = new JTextArea (5, 58);
//        display.append("Hello\nHello\nHello\nWorld\nWorld\nWorld\nWorld\nWorld\nWorld\n");
//        display.setEditable (false);
//
//        JScrollPane scroll = new JScrollPane (display);
//        scroll.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//
//        //Add Textarea in to middle panel
//        middlePanel.add ( scroll );
//
//        // My code
//        JFrame frame = new JFrame ();
//        frame.add ( middlePanel );
//        frame.pack ();
//        frame.setLocationRelativeTo ( null );
//        frame.setVisible ( true );
    }

    private void createCurrentLoadDisplay() {
        GeneralJStuff.createJTextLabel(pane, "Recycling Machine Load Information", 600,100);

        // Display information on the Machine's Glass Load
        String glassLoad = "Current Glass Load: " + recyclingMachine.getCurrentGlassLoad() + " Max Glass Load: "
                + recyclingMachine.getMaxGlassLoad();
        GeneralJStuff.createJTextLabel(pane, glassLoad, 600,125);

        // Display information on the Machine's Metal Load
        String metalLoad = "Current Metal Load: " + recyclingMachine.getCurrentMetalLoad() + " Max Metal Load: "
                + recyclingMachine.getMaxMetalLoad();
        GeneralJStuff.createJTextLabel(pane, metalLoad, 600,150);

        // Display information on the Machine's Paper Load
        String paperLoad = "Current Paper Load: " + recyclingMachine.getCurrentPaperLoad() + " Max Paper Load: "
                + recyclingMachine.getMaxPaperLoad();
        GeneralJStuff.createJTextLabel(pane, paperLoad, 600,175);

        // Display information on the Machine's Plastic Load
        String plasticLoad = "Current Plastic Load: " + recyclingMachine.getCurrentPlasticLoad() + " Max Plastic Load: "
                + recyclingMachine.getMaxPlasticLoad();
        GeneralJStuff.createJTextLabel(pane, plasticLoad, 600,200);
    }

    private void close() {
        frame.setVisible(false); // you can't see me!
        frame.dispose(); // Destroy the JFrame object
    }

    // Display items accepted by the machine & price paid for each item & total weight of machine & capacity

    // Insert Glass, Metal, Paper, Plastic

}
