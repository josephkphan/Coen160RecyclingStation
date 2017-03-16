package guithings;

import resources.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Edit RCMs(in RMOS)
 * This controls the pricing of the RCMs and also the acceptable recyclables for all RCMs.
 */
public class EditMachineGUI extends JFrame implements ActionListener {
    private static final int WINDOW_WIDTH = 625;
    private static final int WINDOW_HEIGHT = 450;
    private Container pane;
    private JFrame frame;
    private HomeGUI homeGUI;

    private boolean[] buttonBool;
    private JToggleButton[] toggleButtons;
    private String[] buttonLabels = {"Glass Bottle", "Metal Can", "Metal Foil", "Paper Plate", "Paper Sheet",
            "Plastic Bottle", "Plastic Utensil"};
    private JLabel metalPricing, glassPricing, plasticPricing, paperPricing;
    private JTextField metalPriceField, glassPriceField, plasticPriceField, paperPriceField;

    public EditMachineGUI(HomeGUI homeGUI) {
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

        buttonBool[0] = homeGUI.getRecyclingMonitoringStation().isGlassBottleEnabled();
        buttonBool[1] = homeGUI.getRecyclingMonitoringStation().isMetalCanEnabled();
        buttonBool[2] = homeGUI.getRecyclingMonitoringStation().isMetalFoilEnabled();
        buttonBool[3] = homeGUI.getRecyclingMonitoringStation().isPaperPlateEnabled();
        buttonBool[4] = homeGUI.getRecyclingMonitoringStation().isPaperSheetEnabled();
        buttonBool[5] = homeGUI.getRecyclingMonitoringStation().isPlasticBottleEnabled();
        buttonBool[6] = homeGUI.getRecyclingMonitoringStation().isPlasticUtensilEnabled();

        toggleButtons = new JToggleButton[7];

        createButton(0, 10, 50);
        createButton(1, 10 + 150, 50);
        createButton(2, 10 + 300, 50);
        createButton(3, 10 + 450, 50);
        createButton(4, 10, 150);
        createButton(5, 10 + 150, 150);
        createButton(6, 10 + 300, 150);


        paperPriceField = new JTextField(10);
        plasticPriceField = new JTextField(10);
        glassPriceField = new JTextField(10);
        metalPriceField = new JTextField(10);

        createEditPricing();
        createCurrentPricing();

    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane, "Edit Recycling Machine", WINDOW_WIDTH);
    }

    private void createInstructions() {
        GeneralJStuff.createJTextLabel(pane, "Edit Acceptable Items: ", 10, 20);
        GeneralJStuff.createJTextLabel(pane, "Green: Enabled", 450, 10, Color.green);
        GeneralJStuff.createJTextLabel(pane, "Red: Disabled", 450, 30, Color.red);
        GeneralJStuff.createJTextLabel(pane, "Edit Pricings (in cents): ", 10, 250);
    }

    private void createButton(int index, int x, int y) {
        toggleButtons[index] = new JToggleButton(buttonLabels[index], buttonBool[index]);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                buttonBool[index] = !buttonBool[index];
                if (buttonBool[index]) {
                    // Item enabled
                    toggleButtons[index].setForeground(Color.GREEN);
                } else {
                    //Item enabled
                    toggleButtons[index].setForeground(Color.RED);
                }
                switch (index) {
                    case 0:
                        homeGUI.getRecyclingMonitoringStation().setGlassBottleEnabled(buttonBool[index]);
                        break;
                    case 1:
                        homeGUI.getRecyclingMonitoringStation().setMetalCanEnabled(buttonBool[index]);
                        break;
                    case 2:
                        homeGUI.getRecyclingMonitoringStation().setMetalFoilEnabled(buttonBool[index]);
                        break;
                    case 3:
                        homeGUI.getRecyclingMonitoringStation().setPaperPlateEnabled(buttonBool[index]);
                        break;
                    case 4:
                        homeGUI.getRecyclingMonitoringStation().setPaperSheetEnabled(buttonBool[index]);
                        break;
                    case 5:
                        homeGUI.getRecyclingMonitoringStation().setPlasticBottleEnabled(buttonBool[index]);
                        break;
                    case 6:
                        homeGUI.getRecyclingMonitoringStation().setPlasticUtensilEnabled(buttonBool[index]);
                        break;
                }
                homeGUI.getRecyclingMonitoringStation().saveData();

            }
        };
        GeneralJStuff.createJToggleButton(pane, toggleButtons[index], x, y, 150, 75, r, buttonBool[index]);

    }

    private void createEditPricing() {

        GeneralJStuff.createJTextLabel(pane, "Change Metal Price: ", 10, 275);
        GeneralJStuff.createJTextField(pane, metalPriceField, 175, 275);

        GeneralJStuff.createJTextLabel(pane, "Change Glass Price: ", 10, 300);
        GeneralJStuff.createJTextField(pane, glassPriceField, 175, 300);

        GeneralJStuff.createJTextLabel(pane, "Change Plastic Price: ", 10, 325);
        GeneralJStuff.createJTextField(pane, plasticPriceField, 175, 325);

        GeneralJStuff.createJTextLabel(pane, "Change Paper Price: ", 10, 350);
        GeneralJStuff.createJTextField(pane, paperPriceField, 175, 350);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String metalString = metalPriceField.getText();
                String glassString = glassPriceField.getText();
                String plasticString = plasticPriceField.getText();
                String paperString = paperPriceField.getText();
                if (metalString.equals("")) metalString = "0";
                if (glassString.equals("")) glassString = "0";
                if (plasticString.equals("")) plasticString = "0";
                if (paperString.equals("")) paperString = "0";

                try {
                    int metalInt = Integer.parseInt(metalString);
                    int glassInt = Integer.parseInt(glassString);
                    int plasticInt = Integer.parseInt(plasticString);
                    int paperInt = Integer.parseInt(paperString);

                    if (metalInt > 0) Constants.METAL_PRICE = metalInt;
                    if (glassInt > 0) Constants.GLASS_PRICE = glassInt;
                    if (plasticInt > 0) Constants.PLASTIC_PRICE = plasticInt;
                    if (paperInt > 0) Constants.PAPER_PRICE = paperInt;

                    homeGUI.getRecyclingMonitoringStation().saveData();

                    actionPerformed(new ActionEvent(pane, 0, ""));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        GeneralJStuff.createJTextButton(pane, "Update Pricings", 150, 390, 150, 32, r);

    }

    private void createCurrentPricing() {
        paperPricing = new JLabel();
        plasticPricing = new JLabel();
        glassPricing = new JLabel();
        metalPricing = new JLabel();

        GeneralJStuff.createJTextLabel(pane, metalPricing,
                "Current Metal Price: " + Constants.getPrice(Constants.METAL_PRICE) + " /lb", 375, 275);
        GeneralJStuff.createJTextLabel(pane, glassPricing,
                "Current Glass Price: " + Constants.getPrice(Constants.GLASS_PRICE) + " /lb", 375, 300);
        GeneralJStuff.createJTextLabel(pane, plasticPricing,
                "Current Plastic Price: " + Constants.getPrice(Constants.PLASTIC_PRICE) + " /lb", 375, 325);
        GeneralJStuff.createJTextLabel(pane, paperPricing,
                "Current Paper Price: " + Constants.getPrice(Constants.PAPER_PRICE) + " /lb", 375, 350);

    }

    private void refreshCurrentPricing() {
        paperPricing.setVisible(false);
        pane.remove(paperPricing);
        plasticPricing.setVisible(false);
        pane.remove(plasticPricing);
        glassPricing.setVisible(false);
        pane.remove(glassPricing);
        metalPricing.setVisible(false);
        pane.remove(metalPricing);
        createCurrentPricing();
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        refreshCurrentPricing();
    }
}
