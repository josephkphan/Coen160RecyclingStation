package guithings;

import javafx.util.Pair;
import machine.RecyclingMachine;
import machine.RecyclingMonitoringStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeGUI extends JFrame implements ActionListener{

    private static final int WINDOW_WIDTH = 750;
    private static final int WINDOW_HEIGHT = 750;
    private static final int IMAGE_WIDTH = 128;
    private static final int IMAGE_HEIGHT = 128;
    private static Container pane;

    private  ArrayList<JButton> recyclingMachineButton;
    private  ArrayList<JLabel> recyclingMachineImage;
    private  RecyclingMonitoringStation recyclingMonitoringStation;
    private  JLabel background;
    private  ArrayList<Pair<Integer,Integer>> addMachine;
    private  ArrayList<Integer> removeMachine;

    public HomeGUI() {
        // Embedded Stuff
        recyclingMonitoringStation = new RecyclingMonitoringStation();
        recyclingMachineButton = new ArrayList<JButton>();
        recyclingMachineImage = new ArrayList<JLabel>();
        addMachine = new ArrayList<Pair<Integer,Integer>>();
        removeMachine = new ArrayList<Integer>();

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

        createTitle();
        createStation();
        createBackground();

        recyclingMonitoringStation.addMachine(40,40);
        addRecyclingMachine(recyclingMonitoringStation.getRecyclingMachine(0));


        recyclingMonitoringStation.addMachine(550,400);
        addRecyclingMachine(recyclingMonitoringStation.getRecyclingMachine(1));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        while(addMachine.size() > 0) {
            Pair temp = addMachine.get(0);
            recyclingMonitoringStation.addMachine((Integer) temp.getKey(), (Integer) temp.getValue());
            addRecyclingMachine(getLastRecyclingMachine());
            addMachine.remove(0);
        }
        while (removeMachine.size() > 0){
            System.out.println("HEREEEEEE");
            removeRecyclingMachine(removeMachine.get(0));
            removeMachine.remove(0);
        }
    }
    //////////////////////////////// Embedded Part ///////////////////////////////////

    public RecyclingMonitoringStation getRecyclingMonitoringStation() {
        return recyclingMonitoringStation;
    }
    public RecyclingMachine getLastRecyclingMachine(){
        return recyclingMonitoringStation.getRecyclingMachine(recyclingMonitoringStation.getNumberOfRecyclingMachines()-1);
    }
    public void addMachineToChange(int x, int y){
        addMachine.add(new Pair<>(x,y));
    }

    public void addMachineToRemove(int id){
        removeMachine.add(id);
    }


    //////////////////////////////// Creating Gui ////////////////////////////////////

    public void removeBackground() {
        background.setVisible(false);
    }

    public void createBackground() {
        background = new JLabel("");
        GeneralJStuff.createJImage(pane, background, 0,0,
                WINDOW_WIDTH, WINDOW_HEIGHT, "src/assets/background.png");
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane, "Home", WINDOW_WIDTH);
    }

    private void createStation() {
        GeneralJStuff.createJImageCenteredXY(pane, WINDOW_WIDTH,
                WINDOW_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT, "src/assets/tower.png");

        Runnable r = () -> new LoginGUI(this);
        GeneralJStuff.createJTextButtonCentered(pane, "Admin Login", WINDOW_WIDTH,
                WINDOW_HEIGHT / 2 + IMAGE_HEIGHT / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 4, r);

    }

    public void addRecyclingMachine(RecyclingMachine rm) {
        JLabel text = new JLabel("");
        recyclingMachineImage.add(text);
        GeneralJStuff.createJImage(pane, recyclingMachineImage.get(recyclingMachineImage.size() - 1),
                rm.getxCoord(), rm.getyCoord(), IMAGE_WIDTH, IMAGE_HEIGHT, "src/assets/machine.png");

        Runnable r = () -> new RecyclingMachineGUI(this, rm);

        JButton button = new JButton();
        recyclingMachineButton.add(button);
        GeneralJStuff.createJTextButton(pane, button, "Recycle", rm.getxCoord(),
                rm.getyCoord() + IMAGE_HEIGHT + 2, IMAGE_WIDTH, IMAGE_HEIGHT / 4, r);

        removeBackground();
        createBackground();
        pane.revalidate();
    }

    //todo TEST THIS
    public void removeRecyclingMachine(int ID) {
        System.out.println("11111111111111111");
        System.out.println("recyclingMonitoringStation.getNumberOfRecyclingMachines() = " + recyclingMonitoringStation.getNumberOfRecyclingMachines());
        for (int i = 0; i < recyclingMonitoringStation.getNumberOfRecyclingMachines(); i++) {
            if (recyclingMonitoringStation.getRecyclingMachine(i).getId() == ID) {
                System.out.println("Found");
                recyclingMachineButton.get(i).setVisible(false);
                pane.remove(recyclingMachineButton.get(i));
                recyclingMachineButton.remove(i);
                recyclingMachineImage.get(i).setVisible(false);
                pane.remove(recyclingMachineImage.get(i));
                recyclingMachineImage.remove(i);

                recyclingMonitoringStation.removeMachine(i);
            }
        }
        pane.revalidate();
    }

}