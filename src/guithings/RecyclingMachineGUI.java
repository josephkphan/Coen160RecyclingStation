package guithings;

import machine.RecyclingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RecyclingMachineGUI extends JFrame implements ActionListener {
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 500;
    private ArrayList<String> transactionItems;
    private ArrayList<Double> transactionItemsWeights;

    private Container pane;
    private JFrame frame;
    private JLabel glass, metal, paper, plastic;
    private JTextArea display;
    private JScrollPane scroll;

    private HomeGUI homeGUI;
    private RecyclingMachine recyclingMachine;

    public RecyclingMachineGUI(HomeGUI homeGUI, RecyclingMachine recyclingMachine) {
        this.homeGUI = homeGUI;
        this.recyclingMachine = recyclingMachine;
        transactionItems = new ArrayList<>();
        transactionItemsWeights = new ArrayList<>();

        frame = new JFrame("Recycling Machine Window");

        pane = frame.getContentPane();

        // Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);

        // Instantiate the Recycling Machine Transaction
        recyclingMachine.startTransaction();
        createTitle();
        createCurrentLoadDisplay();
        createItemsInsertedDisplay();
        createInsertButton();
        createCancelButton();
        createFinishButton();

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
            new InsertRecyclableGUI(homeGUI, this, recyclingMachine);
        };
        GeneralJStuff.createJTextButton(pane, "Insert Recyclable", 25, 50, 200, 25, r);
    }

    private void createCancelButton() {
        Runnable r = () -> {
            recyclingMachine.cancelTransaction();
            close();
        };
        GeneralJStuff.createJTextButton(pane, "Cancel Transaction", 250, 50, 200, 25, r);
    }

    private void createFinishButton() {
        Runnable r = () -> {
            // Display a Coupon for the User

            // Clear out the RCM
            recyclingMachine.endTransaction();

            close();
        };
        GeneralJStuff.createJTextButton(pane, "Finished!", 700, 50, 200, 25, r);
    }

    private void createItemsInsertedDisplay() {
        display = new JTextArea (5, 58);

        for (int i = 0; i < transactionItems.size(); i++) {
            display.append(transactionItems.get(i) + "     Weight: ");
            display.append(Double.toString(transactionItemsWeights.get(i)));
            display.append("\n");
        }

        display.setEditable (false);

        scroll = new JScrollPane (display);
        scroll.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(25,100,500,300);

        pane.add(scroll);
    }

    private void createCurrentLoadDisplay() {
        GeneralJStuff.createJTextLabel(pane, "Recycling Machine Load Information", 600,100);

        // Display information on the Machine's Glass Load
        String glassLoad = "Current Glass Load: " + recyclingMachine.getCurrentTransactionGlassLoad()
                + " Max Glass Load: " + recyclingMachine.getMaxGlassLoad();
        glass = new JLabel();
        GeneralJStuff.createJTextLabel(pane, glass, glassLoad, 600,125);

        // Display information on the Machine's Metal Load
        String metalLoad = "Current Metal Load: " + recyclingMachine.getCurrentTransactionMetalLoad()
                + " Max Metal Load: " + recyclingMachine.getMaxMetalLoad();
        metal = new JLabel();
        GeneralJStuff.createJTextLabel(pane, metal, metalLoad, 600,150);

        // Display information on the Machine's Paper Load
        String paperLoad = "Current Paper Load: " + recyclingMachine.getCurrentTransactionPaperLoad()
                + " Max Paper Load: " + recyclingMachine.getMaxPaperLoad();
        paper = new JLabel();
        GeneralJStuff.createJTextLabel(pane, paper, paperLoad, 600,175);

        // Display information on the Machine's Plastic Load
        String plasticLoad = "Current Plastic Load: " + recyclingMachine.getCurrentTransactionPlasticLoad()
                + " Max Plastic Load: " + recyclingMachine.getMaxPlasticLoad();
        plastic = new JLabel();
        GeneralJStuff.createJTextLabel(pane, plastic, plasticLoad, 600,200);
    }

    private void close() {
        frame.setVisible(false); // you can't see me!
        frame.dispose(); // Destroy the JFrame object
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        refresh();
    }

    private void refresh() {
        display.setVisible(false);
        scroll.setVisible(false);
        glass.setVisible(false);
        metal.setVisible(false);
        paper.setVisible(false);
        plastic.setVisible(false);
        createItemsInsertedDisplay();
        createCurrentLoadDisplay();
        revalidate();
    }

    // Setters
    public void addTransactionItem(String type, double weight) {
        transactionItems.add(type);
        transactionItemsWeights.add(weight);
    }


}
