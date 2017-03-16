package guithings;

import machine.RecyclingMachine;
import recyclable.*;
import resources.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Recycle Machine Options:
     This provides a nice visual options for users to indicate what type of item they are recycling.
     Notice how some are disabled. This is controlled in the “Edit RCM window” located in the RMOS
 */
public class InsertRecyclableGUI extends JFrame {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    private Container pane;
    private JFrame frame;
    private HomeGUI homeGUI;
    private RecyclingMachineGUI recyclingMachineGUI;
    private RecyclingMachine recyclingMachine;
    private JButton glassBottleButton, metalCanButton, metalFoilButton, paperPlateButton, paperSheetButton,
            plasticBottleButton, plasticUtensilButton;

    public InsertRecyclableGUI(HomeGUI homeGUI, RecyclingMachineGUI recyclingMachineGUI, RecyclingMachine recyclingMachine) {
        this.homeGUI = homeGUI;
        this.recyclingMachineGUI = recyclingMachineGUI;
        this.recyclingMachine = recyclingMachine;
        frame = new JFrame("Recycling Machine");
        pane = frame.getContentPane();

        // Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);

        createTitle();
        createGlassBottleButton(10, 100+10);
        createMetalCanButton(200,100+10);
        createMetalFoilButton(400,100+10);
        createPlasticBottleButton(10,200+20);
        createPaperPlateButton(200,200+20);
        createPaperSheetButton(400,200+20);
        createPlasticUtensilButton(10,300+30);
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane, "What would you like to recycle?", WINDOW_WIDTH);
    }

    private void createGlassBottleButton(int x, int y) {
        Runnable r = () -> {
            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = (int) (Math.random() * 1000);
            randomWeight /= 100;

            // Add a new Glass Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new GlassBottle(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
                recyclingMachineGUI.displayMachineFullError();
            } else {
                int priceInCents = (int) (randomWeight * Constants.GLASS_PRICE);
                recyclingMachineGUI.addTransactionItem("Glass Bottle", randomWeight, priceInCents);
            }

            recyclingMachineGUI.actionPerformed(new ActionEvent(pane, 0, ""));
            close();
        };
        GeneralJStuff.createJImage(pane, x + 42, y - 75, 64, 64, "src/assets/glassBottle.png");
        glassBottleButton = new JButton();
        if(!homeGUI.getRecyclingMonitoringStation().isGlassBottleEnabled()){
            glassBottleButton.setEnabled(false);
        }
        GeneralJStuff.createJTextButton(pane, glassBottleButton, "Glass Bottle", x, y, 150, 25, r);
    }

    private void createMetalCanButton(int x, int y) {
        Runnable r = () -> {
            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = (int) (Math.random() * 1000);
            randomWeight /= 100;

            // Add a new Metal Can to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new MetalCan(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
                recyclingMachineGUI.displayMachineFullError();
            } else {
                int priceInCents = (int) (randomWeight * Constants.METAL_PRICE);
                recyclingMachineGUI.addTransactionItem("Metal Can", randomWeight, priceInCents);
            }

            recyclingMachineGUI.actionPerformed(new ActionEvent(pane, 0, ""));
            close();
        };
        GeneralJStuff.createJImage(pane, x + 42, y - 75, 64, 64, "src/assets/metalCan.png");
        metalCanButton = new JButton();
        if(!homeGUI.getRecyclingMonitoringStation().isMetalCanEnabled()){
            metalCanButton.setEnabled(false);
        }
        GeneralJStuff.createJTextButton(pane,metalCanButton, "Metal Can", x, y, 150, 25, r);
    }

    private void createMetalFoilButton(int x, int y) {
        Runnable r = () -> {
            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = (int) (Math.random() * 1000);
            randomWeight /= 100;

            // Add a new Metal Foil to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new MetalFoil(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
                recyclingMachineGUI.displayMachineFullError();
            } else {
                int priceInCents = (int) (randomWeight * Constants.METAL_PRICE);
                recyclingMachineGUI.addTransactionItem("Metal Foil", randomWeight, priceInCents);
            }

            recyclingMachineGUI.actionPerformed(new ActionEvent(pane, 0, ""));
            close();
        };
        GeneralJStuff.createJImage(pane, x + 42, y - 75, 64, 64, "src/assets/metalFoil.png");
        metalFoilButton = new JButton();
        if(!homeGUI.getRecyclingMonitoringStation().isMetalFoilEnabled()){
            metalFoilButton.setEnabled(false);
        }
        GeneralJStuff.createJTextButton(pane,metalFoilButton, "Metal Foil", x, y, 150, 25, r);
    }

    private void createPaperPlateButton(int x, int y) {
        Runnable r = () -> {
            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = (int) (Math.random() * 1000);
            randomWeight /= 100;

            // Add a new Paper Plate to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new PaperPlate(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
                recyclingMachineGUI.displayMachineFullError();
            } else {
                int priceInCents = (int) (randomWeight * Constants.PAPER_PRICE);
                recyclingMachineGUI.addTransactionItem("Paper Plate", randomWeight, priceInCents);
            }

            recyclingMachineGUI.actionPerformed(new ActionEvent(pane, 0, ""));
            close();
        };
        GeneralJStuff.createJImage(pane, x + 42, y - 75, 64, 64, "src/assets/paperPlate.png");
        paperPlateButton = new JButton();
        if(!homeGUI.getRecyclingMonitoringStation().isPaperPlateEnabled()){
            paperPlateButton.setEnabled(false);
        }
        GeneralJStuff.createJTextButton(pane,paperPlateButton, "Paper Plate", x, y, 150, 25, r);
    }

    private void createPaperSheetButton(int x, int y) {
        Runnable r = () -> {
            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = (int) (Math.random() * 1000);
            randomWeight /= 100;

            // Add a new Paper Sheet to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new PaperSheet(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
                recyclingMachineGUI.displayMachineFullError();
            } else {
                int priceInCents = (int) (randomWeight * Constants.PAPER_PRICE);
                recyclingMachineGUI.addTransactionItem("Paper Sheet", randomWeight, priceInCents);
            }

            recyclingMachineGUI.actionPerformed(new ActionEvent(pane, 0, ""));
            close();
        };
        GeneralJStuff.createJImage(pane, x + 42, y - 75, 64, 64, "src/assets/paperSheet.png");
        paperSheetButton = new JButton();
        if(!homeGUI.getRecyclingMonitoringStation().isPaperSheetEnabled()){
            paperSheetButton.setEnabled(false);
        }
        GeneralJStuff.createJTextButton(pane,paperSheetButton, "Paper Sheet", x, y, 150, 25, r);
    }

    private void createPlasticBottleButton(int x, int y) {
        Runnable r = () -> {
            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = (int) (Math.random() * 1000);
            randomWeight /= 100;

            // Add a new Plastic Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new PlasticBottle(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
                recyclingMachineGUI.displayMachineFullError();
            } else {
                int priceInCents = (int) (randomWeight * Constants.PLASTIC_PRICE);
                recyclingMachineGUI.addTransactionItem("Plastic Bottle", randomWeight, priceInCents);
            }

            recyclingMachineGUI.actionPerformed(new ActionEvent(pane, 0, ""));
            close();
        };
        GeneralJStuff.createJImage(pane, x + 42, y - 75, 64, 64, "src/assets/plasticBottle.png");
        plasticBottleButton = new JButton();
        if(!homeGUI.getRecyclingMonitoringStation().isPlasticBottleEnabled()){
            plasticBottleButton.setEnabled(false);
        }
        GeneralJStuff.createJTextButton(pane, plasticBottleButton,"Plastic Bottle", x, y, 150, 25, r);
    }

    private void createPlasticUtensilButton(int x, int y) {
        Runnable r = () -> {
            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = (int) (Math.random() * 1000);
            randomWeight /= 100;

            // Add a new Plastic Utensil to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new PlasticUtensil(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
                recyclingMachineGUI.displayMachineFullError();
            } else {
                int priceInCents = (int) (randomWeight * Constants.PLASTIC_PRICE);
                recyclingMachineGUI.addTransactionItem("Plastic Utensil", randomWeight, priceInCents);
            }

            recyclingMachineGUI.actionPerformed(new ActionEvent(pane, 0, ""));
            close();
        };
        GeneralJStuff.createJImage(pane, x + 42, y - 75, 64, 64, "src/assets/plasticUtensils.png");
        plasticUtensilButton = new JButton();
        if(!homeGUI.getRecyclingMonitoringStation().isPlasticUtensilEnabled()){
            plasticUtensilButton.setEnabled(false);
        }
        GeneralJStuff.createJTextButton(pane, plasticUtensilButton, "Plastic Utensil", x, y, 150, 25, r);
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }
}
