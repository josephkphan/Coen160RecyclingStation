package guithings;

import machine.RecyclingMachine;
import machine.RecyclingMonitoringStation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomeGUI extends JFrame {

    private static final int WINDOW_WIDTH = 1500;
    private static final int WINDOW_HEIGHT = 750;
    private static final int IMAGE_WIDTH = 128;
    private static final int IMAGE_HEIGHT = 128;
    private static Container pane;
    private static Insets paneInsets;

    private static ArrayList<JButton> recyclingMachineButton;
    private static ArrayList<JLabel> recyclingMachineImage;
    private static ArrayList<Integer> recyclingMachineID;

    private static RecyclingMonitoringStation recyclingMonitoringStation;
    private static JLabel background;

    public HomeGUI() {
        // Embedded Stuff
        recyclingMonitoringStation = new RecyclingMonitoringStation();
        recyclingMachineButton = new ArrayList<JButton>();
        recyclingMachineImage = new ArrayList<JLabel>();
        recyclingMachineID = new ArrayList<Integer>();


        //Gui Stuff
        JFrame frame = new JFrame("Home Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane = frame.getContentPane();

        //Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);
        paneInsets = pane.getInsets();

        createTitle();
        createStation();
        createBackground();

        recyclingMonitoringStation.addMachine(40,40);
        addRecyclingMachine(recyclingMonitoringStation.getRecyclingMachine(0));

        recyclingMonitoringStation.addMachine(1100,500);
        addRecyclingMachine(recyclingMonitoringStation.getRecyclingMachine(1));

        recyclingMonitoringStation.addMachine(800,40);
        addRecyclingMachine(recyclingMonitoringStation.getRecyclingMachine(2));

    }

    //////////////////////////////// Embedded Part ///////////////////////////////////

    public static RecyclingMonitoringStation getRecyclingMonitoringStation() {
        return recyclingMonitoringStation;
    }
    public static RecyclingMachine getLastRecyclingMachine(){
        return recyclingMonitoringStation.getRecyclingMachine(recyclingMonitoringStation.getNumberOfRecyclingMachines()-1);
    }

    public static void makeNewRecyclingMachine(){
        System.out.println("HEREEEEEEEEEEEEEEEEEEEE");
        addRecyclingMachine(recyclingMonitoringStation.getRecyclingMachine(recyclingMonitoringStation.getNumberOfRecyclingMachines()-1));
    }

    //////////////////////////////// Creating Gui ////////////////////////////////////
    
    public static void removeBackground() {
        background.setVisible(false);
    }

    public static void createBackground() {
        background = new JLabel("");
        GeneralJStuff.createJImage(pane, background, paneInsets.left, paneInsets.top,
                WINDOW_WIDTH, WINDOW_HEIGHT, "src/assets/background.png");
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane, "Home", WINDOW_WIDTH);
    }

    private void createStation() {
        GeneralJStuff.createJImageCenteredXY(pane, WINDOW_WIDTH,
                WINDOW_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT, "src/assets/tower.png");

        Runnable r = () -> new LoginGUI();
        GeneralJStuff.createJTextButtonCentered(pane, "Admin Login", WINDOW_WIDTH,
                WINDOW_HEIGHT / 2 + IMAGE_HEIGHT / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 4, r);

    }

    public static void addRecyclingMachine(RecyclingMachine rm) {
        JLabel text = new JLabel("");
        recyclingMachineImage.add(text);
        GeneralJStuff.createJImage(pane, recyclingMachineImage.get(recyclingMachineImage.size() - 1),
                rm.getxCoord(), rm.getyCoord(), IMAGE_WIDTH, IMAGE_HEIGHT, "src/assets/machine.png");

        Runnable r = () -> new RecyclingMachineGUI(rm);

        JButton button = new JButton();
        recyclingMachineButton.add(button);
        GeneralJStuff.createJTextButton(pane, button, "Recycle", rm.getxCoord(),
                rm.getyCoord() + IMAGE_HEIGHT + 2, IMAGE_WIDTH, IMAGE_HEIGHT / 4, r);

        removeBackground();
        createBackground();
    }

    //todo TEST THIS
    public static void removeRecyclingMachine(int ID) {
        for (int i = 0; i < recyclingMachineID.size(); i++) {
            if (recyclingMachineID.get(i) == ID) {
                recyclingMachineID.remove(i);
                recyclingMachineButton.get(i).setVisible(false);
                recyclingMachineButton.remove(i);
                recyclingMachineImage.get(i).setVisible(false);
                recyclingMachineImage.remove(i);
            }
        }
    }

}