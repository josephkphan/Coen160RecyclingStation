package guithings;

import machine.RecyclingMachine;
import machine.RecyclingMonitoringStation;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
//        createTitle();
        GeneralJStuff.createJTextLabelCentered(pane,"Home",WINDOW_WIDTH);
        createStation();
        createBackground();

        RecyclingMachine tester = new RecyclingMachine(40,40,50);
        addRecyclingMachine(tester);

        RecyclingMachine tester2 = new RecyclingMachine(1100,500,51);
        addRecyclingMachine(tester2);

        RecyclingMachine tester3 = new RecyclingMachine(800,200,52);
        addRecyclingMachine(tester3);


    }


    //////////////////////////////// Embedded Part ///////////////////////////////////

    public static RecyclingMonitoringStation getRecyclingMonitoringStation() {
        return recyclingMonitoringStation;
    }


    //////////////////////////////// Creating Gui ////////////////////////////////////


    public static void removeBackground(){
        background.setVisible(false);
    }

    public static void createBackground(){
        background = new JLabel("Hello");
        background.setBounds(paneInsets.left, paneInsets.top, WINDOW_WIDTH, WINDOW_HEIGHT);
        background.setIcon(new ImageIcon("src/assets/background.png"));
        background.setAlignmentY(SwingConstants.BOTTOM);
        pane.add(background);
    }
    private void createStation() {
        JLabel text = new JLabel("Hello");
        text.setBounds(WINDOW_WIDTH / 2 - IMAGE_WIDTH / 2, WINDOW_HEIGHT / 2 - IMAGE_HEIGHT / 2, IMAGE_WIDTH, IMAGE_HEIGHT);
        text.setIcon(new ImageIcon("src/assets/tower.png"));
        pane.add(text);


        Runnable r = () -> new LoginGUI();

        GeneralJStuff.createJTextButtonCentered(pane,"Admin Login",WINDOW_WIDTH,
                WINDOW_HEIGHT / 2 + IMAGE_HEIGHT / 2,IMAGE_WIDTH,IMAGE_HEIGHT/4,r);

//        JButton button = new JButton("Admin Login");
//        button.setBounds(WINDOW_WIDTH / 2 - IMAGE_WIDTH / 2, WINDOW_HEIGHT / 2 + IMAGE_HEIGHT / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 4);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new LoginGUI();
//            }
//        });
//        pane.add(button);
    }

    //todo Test THIS
    public static void addRecyclingMachine(RecyclingMachine rm) {
        JLabel text = new JLabel("Hello");
        text.setBounds(rm.getxCoord(), rm.getyCoord(), IMAGE_WIDTH, IMAGE_HEIGHT);
        text.setIcon(new ImageIcon("src/assets/machine.png"));
        recyclingMachineImage.add(text);
        pane.add(recyclingMachineImage.get(recyclingMachineImage.size() - 1));

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new RecyclingMachineGUI(rm);
            }
        };

        JButton button = new JButton("Recycle");
        recyclingMachineButton.add(button);
        recyclingMachineButton.get(recyclingMachineButton.size() - 1).setBounds(rm.getxCoord(),
                rm.getyCoord() + IMAGE_HEIGHT + 2, IMAGE_WIDTH, IMAGE_HEIGHT / 4);
        recyclingMachineButton.get(recyclingMachineButton.size() - 1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RecyclingMachineGUI(rm);
            }
        });
        pane.add(recyclingMachineButton.get(recyclingMachineButton.size() - 1));

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