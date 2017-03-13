package guithings;

import machine.RecyclingMachine;
import recyclable.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InsertRecyclableGUI {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 300;
    private Container pane;
    private JFrame frame;
    private HomeGUI homeGUI;
    private RecyclingMachineGUI recyclingMachineGUI;
    private RecyclingMachine recyclingMachine;

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
        createGlassBottleButton();
        createMetalCanButton();
        createMetalFoilButton();
        createMetalFoilButton();
        createPaperPlateButton();
        createPaperSheetButton();
        createPlasticBottleButton();
        createPlasticUtensilButton();
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane,"What would you like to recycle?", WINDOW_WIDTH);
    }

    private void createGlassBottleButton() {
        Runnable r = () -> {
            System.out.println("Clicked Glass Bottle");

            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = Math.random() * 10;

            // Add a new Glass Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new GlassBottle(randomWeight));

            if (success == false) {
                // TODO: Display Error Message to User
                System.out.println("The Recycling Machine is Full!!!");
            } else {
                System.out.println(recyclingMachine.getCurrentTransactionTotal());
            }
        };
        GeneralJStuff.createJTextButton(pane, "Glass Bottle", 25, 50, 200, 25, r);
    }

    private void createMetalCanButton() {
        Runnable r = () -> {
            System.out.println("Clicked Metal Can");

            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = Math.random() * 10;

            // Add a new Glass Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new MetalCan(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
            } else {
                System.out.println(recyclingMachine.getCurrentTransactionTotal());
            }
        };
        GeneralJStuff.createJTextButton(pane, "Metal Can", 25, 100, 200, 25, r);
    }

    private void createMetalFoilButton() {
        Runnable r = () -> {
            System.out.println("Clicked Metal Foil");

            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = Math.random() * 10;

            // Add a new Glass Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new MetalFoil(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
            } else {
                System.out.println(recyclingMachine.getCurrentTransactionTotal());
            }
        };
        GeneralJStuff.createJTextButton(pane, "Metal Foil", 25, 150, 200, 25, r);
    }

    private void createPaperPlateButton() {
        Runnable r = () -> {
            System.out.println("Clicked Paper Plate");

            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = Math.random() * 10;

            // Add a new Glass Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new PaperPlate(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
            } else {
                System.out.println(recyclingMachine.getCurrentTransactionTotal());
            }
        };
        GeneralJStuff.createJTextButton(pane, "Paper Plate", 25, 200, 200, 25, r);
    }

    private void createPaperSheetButton() {
        Runnable r = () -> {
            System.out.println("Clicked Paper Sheet");

            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = Math.random() * 10;

            // Add a new Glass Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new PaperSheet(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
            } else {
                System.out.println(recyclingMachine.getCurrentTransactionTotal());
            }
        };
        GeneralJStuff.createJTextButton(pane, "Paper Plate", 25, 250, 200, 25, r);
    }

    private void createPlasticBottleButton() {
        Runnable r = () -> {
            System.out.println("Clicked Plastic Bottle");

            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = Math.random() * 10;

            // Add a new Glass Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new PlasticBottle(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
            } else {
                System.out.println(recyclingMachine.getCurrentTransactionTotal());
            }
        };
        GeneralJStuff.createJTextButton(pane, "Plastic Bottle", 25, 300, 200, 25, r);
    }

    private void createPlasticUtensilButton() {
        Runnable r = () -> {
            System.out.println("Clicked Plastic Utensil");

            // Randomly generate a weight for the item between 0 -> 10 lbs
            double randomWeight = Math.random() * 10;

            // Add a new Glass Bottle to the Recycling Machine
            boolean success = recyclingMachine.addRecyclableItem(new PlasticUtensil(randomWeight));

            if (success == false) {
                System.out.println("The Recycling Machine is Full!!!");
            } else {
                System.out.println(recyclingMachine.getCurrentTransactionTotal());
            }
        };
        GeneralJStuff.createJTextButton(pane, "Paper Plate", 25, 350, 200, 25, r);
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }
}
