package guithings;

import currency.Cash;
import machine.RecyclingMachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;


@SuppressWarnings("serial")
public class RecyclingMonitoringStationGUI extends JFrame implements ActionListener {

    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 800;
    private Container pane;
    private JFrame frame;
    private HomeGUI homeGUI;
    private ArrayList<MachineInfoBar> machineInfoBars;

    public RecyclingMonitoringStationGUI(HomeGUI homeGUI) {
        this.homeGUI = homeGUI;
        frame = new JFrame("Recycling Monitoring Station Window");

        pane = frame.getContentPane();
        //Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);

        machineInfoBars = new ArrayList<MachineInfoBar>();

        createTitle();
        createMachines();
        createAddMachineButton();
        createRemoveMachineButton();
        createEditMachineButton();
        createRefreshButton();
//        System.out.println(HomeGUI.getRecyclingMonitoringStation().getNumberOfRecyclingMachines());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        refresh();
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane, "Recycling Monitoring Station", WINDOW_WIDTH);
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }

    private void createMachines() {
        System.out.println("# = " + homeGUI.getRecyclingMonitoringStation().getNumberOfRecyclingMachines());
        for (int i = 0; i < homeGUI.getRecyclingMonitoringStation().getNumberOfRecyclingMachines(); i++) {
            machineInfoBars.add(new MachineInfoBar(homeGUI, homeGUI.getRecyclingMonitoringStation().getRecyclingMachine(i),
                    pane, 50, 100 + 150 * i));
            machineInfoBars.get(i).actionPerformed(new ActionEvent(pane,0,""));

        }
        pane.revalidate();
    }

    private void refresh(){
        System.out.println("here!!");
        for (MachineInfoBar mib : machineInfoBars) {
            mib.remove();
        }
        machineInfoBars.clear();
        createMachines();
        pane.revalidate();
        frame.setVisible(true);
    }

    private void createAddMachineButton() {
        Runnable r = () -> new AddMachineGUI(homeGUI, this);
        GeneralJStuff.createJTextButton(pane, "Add", 50, 50, 128, 32, r);

    }

    private void createRemoveMachineButton() {
        Runnable r = () -> new RemoveMachineGUI(homeGUI, this);
        GeneralJStuff.createJTextButton(pane, "Remove", 200, 50, 128, 32, r);
    }

    private void createEditMachineButton() {
        Runnable r = () -> new EditMachineGUI(homeGUI);
        GeneralJStuff.createJTextButton(pane, "Edit", 350, 50, 128, 32, r);
    }

    private void createRefreshButton() {
        Runnable r = () -> refresh();
        GeneralJStuff.createJTextButton(pane, "Refresh", 1000-150, 50, 128, 32, r);
    }


}

class MachineInfoBar implements ActionListener {
    private Container pane;
    private int x, y;
    private RecyclingMachine recyclingMachine;
    private JLabel id, xCoord, yCoord, glassLoad, metalLoad, paperLoad, plasticLoad, maxGlassLoad, maxMetalLoad;
    private JLabel maxPaperLoad, maxPlasticLoad, numGlass, numMetal, numPaper, numPlastic;
    private JLabel numTransaction, moneyLeft, moneyObtained, image;
    private JButton empty, reload, stats;
    private JLabel label;
    private ArrayList<JLabel> labels;
    private HomeGUI homeGUI;

    public MachineInfoBar(HomeGUI homeGUI, RecyclingMachine recyclingMachine, Container pane, int x, int y) {
        this.pane = pane;
        this.x = x;
        this.y = y;
        this.recyclingMachine = recyclingMachine;
        this.homeGUI = homeGUI;

        labels = new ArrayList<JLabel>();
        createEmptyButton();
        createReloadMoneyButton();
        createViewStatsButton();
        createMachineLabels();
        pane.revalidate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pane.revalidate();
    }

    private void createEmptyButton() {
        empty = new JButton("");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                recyclingMachine.empty();
                homeGUI.getRecyclingMonitoringStation().saveData();
                remove();
                createEmptyButton();
                createReloadMoneyButton();
                createViewStatsButton();
                createMachineLabels();
                pane.revalidate();
            }
        };
        GeneralJStuff.createJTextButton(pane,empty, "Empty", x + 800, y + 20, 128, 32, r);
    }

    private void createReloadMoneyButton() {
        reload = new JButton("");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                recyclingMachine.reload();
                homeGUI.getRecyclingMonitoringStation().saveData();
                remove();
                createEmptyButton();
                createReloadMoneyButton();
                createViewStatsButton();
                createMachineLabels();
                pane.revalidate();
            }
        };
        GeneralJStuff.createJTextButton(pane,reload, "Reload $", x + 800, y + 60, 128, 32, r);
    }

    private void createViewStatsButton() {
        stats = new JButton("");
        Runnable r = () -> {
            new MachineStatisticGUI(recyclingMachine);
        };

        GeneralJStuff.createJTextButton(pane,stats, "View Stats", x + 800, y + 100, 128, 32, r);
    }

    private void createMachineLabels() {
        id = new JLabel();
        xCoord = new JLabel();
        yCoord = new JLabel();
        glassLoad = new JLabel();
        maxGlassLoad = new JLabel();
        metalLoad = new JLabel();
        maxMetalLoad = new JLabel();
        paperLoad = new JLabel();
        maxPaperLoad = new JLabel();
        plasticLoad = new JLabel();
        maxPlasticLoad = new JLabel();
        numGlass = new JLabel();
        numMetal = new JLabel();
        numPaper = new JLabel();
        numPlastic = new JLabel();
        numTransaction = new JLabel();
        moneyLeft = new JLabel();
        moneyObtained = new JLabel();
        image = new JLabel();
        label = new JLabel();

        labels.add(id);
        labels.add(xCoord);
        labels.add(yCoord);
        labels.add(glassLoad);
        labels.add(maxGlassLoad);
        labels.add(metalLoad);
        labels.add(maxMetalLoad);
        labels.add(paperLoad);
        labels.add(maxPaperLoad);
        labels.add(plasticLoad);
        labels.add(maxPlasticLoad);
        labels.add(numGlass);
        labels.add(numMetal);
        labels.add(numPaper);
        labels.add(numPlastic);
        labels.add(numTransaction);
        labels.add(moneyLeft);
        labels.add(moneyObtained);
        labels.add(image);
        labels.add(label);

        GeneralJStuff.createJTextLabel(pane, id, "Machines # " + Integer.toString(recyclingMachine.getId()), x, y);
        // Image
        GeneralJStuff.createJImage(pane,image, x + 5, y + 20, 128, 128, "src/assets/machine.png");

        // Coordinates
        GeneralJStuff.createJTextLabel(pane, xCoord, "X: " + Integer.toString(recyclingMachine.getxCoord()), x + 150, y + 20);
        GeneralJStuff.createJTextLabel(pane, yCoord, "Y: " + Integer.toString(800 - recyclingMachine.getyCoord() - 210), x + 250, y + 20);

        // Loads
        GeneralJStuff.createJTextLabel(pane, glassLoad, "Glass Load:    " + Double.toString(Double.parseDouble(new DecimalFormat("##.##").format(recyclingMachine.getCurrentGlassLoad()))), x + 150, y + 40);
        GeneralJStuff.createJTextLabel(pane, maxGlassLoad, "/ " + Integer.toString((int) recyclingMachine.getMaxGlassLoad()), x + 300, y + 40);


        GeneralJStuff.createJTextLabel(pane,metalLoad, "Metal Load:    " +
                Double.toString(Double.parseDouble(new DecimalFormat("##.##").format(recyclingMachine.getCurrentMetalLoad()))), x + 150, y + 60);
        GeneralJStuff.createJTextLabel(pane,maxMetalLoad, "/ " +
                Integer.toString((int) recyclingMachine.getMaxMetalLoad()), x + 300, y + 60);
        GeneralJStuff.createJTextLabel(pane, paperLoad,"Paper Load:   " +
                Double.toString(Double.parseDouble(new DecimalFormat("##.##").format(recyclingMachine.getCurrentPaperLoad()))), x + 150, y + 80);
        GeneralJStuff.createJTextLabel(pane,maxPaperLoad, "/ " +
                Integer.toString((int) recyclingMachine.getMaxPaperLoad()), x + 300, y + 80);
        GeneralJStuff.createJTextLabel(pane,plasticLoad, "Plastic Load:  " +
                Double.toString(Double.parseDouble(new DecimalFormat("##.##").format(recyclingMachine.getCurrentPlasticLoad()))), x + 150, y + 100);
        GeneralJStuff.createJTextLabel(pane,maxPlasticLoad, "/ " +
                Integer.toString((int) recyclingMachine.getMaxPlasticLoad()), x + 300, y + 100);

        // Num Items
        GeneralJStuff.createJTextLabel(pane,numGlass, "Total # Glass Items: " +
                Integer.toString(recyclingMachine.getNumGlassItems()), x + 350, y + 40);
        GeneralJStuff.createJTextLabel(pane,numMetal, "Total # Metal Items: " +
                Integer.toString(recyclingMachine.getNumMetalItems()), x + 350, y + 60);
        GeneralJStuff.createJTextLabel(pane,numPaper, "Total # Paper Items: " +
                Integer.toString(recyclingMachine.getNumPaperItems()), x + 350, y + 80);
        GeneralJStuff.createJTextLabel(pane,numPlastic, "Total # Plastic Items: " +
                Integer.toString(recyclingMachine.getNumPlasticItems()), x + 350, y + 100);

        //Other Stuff
        GeneralJStuff.createJTextLabel(pane,numTransaction, "Total # Transactions: " +
                Integer.toString(recyclingMachine.getMachineStatistics().getNumberOfTransactions()), x + 550, y + 40);
        Cash temp = new Cash(0,(int) recyclingMachine.getAvailableMoney());
        GeneralJStuff.createJTextLabel(pane,moneyLeft, "Money Left: " +
                temp.toString(), x + 550, y + 60);
//        temp = new Cash(0,(int) recyclingMachine.getMachineStatistics().getTotalMoneyObtained());
//        GeneralJStuff.createJTextLabel(pane,moneyObtained, "Total Money Obtained: " +
//                temp.toString(), x + 550, y + 80);
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        if(recyclingMachine.getMachineStatistics().getEmptiedHistory().size()>0) {
            GeneralJStuff.createJTextLabel(pane, moneyObtained, "Last Emptied: " +
                   recyclingMachine.getMachineStatistics().getEmptiedHistory().get(0), x + 550, y + 80);
        }else{
            GeneralJStuff.createJTextLabel(pane,moneyObtained, "Last Emptied: " +
                    "Never Emptied", x + 550, y + 80);
        }


        //todo CHANGE MONEY TO CENTS HERE???

        if (recyclingMachine.getCurrentGlassLoad() >= 75 ||
                recyclingMachine.getCurrentPlasticLoad() >= 75 ||
                recyclingMachine.getCurrentMetalLoad() >= 75 ||
                recyclingMachine.getCurrentPaperLoad() >= 75) {
            label.setText("Status: Go Empty");
            label.setForeground(Color.red);
        } else {
            label.setText("Status: Good");
            label.setForeground(Color.GREEN);
        }
        label.setBounds(x + 200, y + 120, label.getPreferredSize().width, label.getPreferredSize().height);
        pane.add(label);
        pane.revalidate();
    }

    public void remove(){
        stats.setVisible(false);
        pane.remove(stats);

        empty.setVisible(false);
        pane.remove(empty);

        reload.setVisible(false);
        pane.remove(reload);

        for(JLabel label : labels){
            label.setVisible(false);
            pane.remove(label);
        }

    }

}
