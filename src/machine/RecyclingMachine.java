package machine;

import recyclable.RecyclableItem;
import recyclable.Glass;
import recyclable.Metal;
import recyclable.Paper;
import recyclable.Plastic;
import statistics.Transaction;
import statistics.MachineStatistics;


public class RecyclingMachine {
    // Containment of the MachineStatistics Class
    MachineStatistics ms = new MachineStatistics();

    // Machine Information
    private int id;
    private int xCoord, yCoord;

    // Transaction Related Data Members
    Transaction t;
    private boolean inTransaction;
    private int transactionTotal;
    private int numPlasticItems, numPaperItems, numGlassItems, numMetalItems;
    private double availableMoney;

    // Capacity Related Data Members
    private double maxGlassLoad, currentGlassLoad;
    private double maxMetalLoad, currentMetalLoad;
    private double maxPaperLoad, currentPaperLoad;
    private double maxPlasticLoad, currentPlasticLoad;

    // Setters and Getters
    public double getMaxGlassLoad() {
        return maxGlassLoad;
    }

    public double getCurrentGlassLoad() {
        return currentGlassLoad;
    }

    public void setCurrentGlassLoad(double currentGlassLoad) {
        this.currentGlassLoad = currentGlassLoad;
    }

    public double getMaxMetalLoad() {
        return maxMetalLoad;
    }

    public double getCurrentMetalLoad() {
        return currentMetalLoad;
    }

    public void setCurrentMetalLoad(double currentMetalLoad) {
        this.currentMetalLoad = currentMetalLoad;
    }

    public double getMaxPaperLoad() {
        return maxPaperLoad;
    }

    public double getCurrentPaperLoad() {
        return currentPaperLoad;
    }

    public void setCurrentPaperLoad(double currentPaperLoad) {
        this.currentPaperLoad = currentPaperLoad;
    }

    public double getMaxPlasticLoad() {
        return maxPlasticLoad;
    }

    public double getCurrentPlasticLoad() {
        return currentPlasticLoad;
    }

    public void setCurrentPlasticLoad(double currentPlasticLoad) {
        this.currentPlasticLoad = currentPlasticLoad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public double getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(double availableMoney) {
        this.availableMoney = availableMoney;
    }

    // Constructor
    public RecyclingMachine(int xCoord, int yCoord, int id) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.id = id;

        this.inTransaction = false;
        this.transactionTotal = 0;
        this.numGlassItems = 0;
        this.numMetalItems = 0;
        this.numPaperItems = 0;
        this.numPlasticItems = 0;

        this.availableMoney = 100; // TODO: Set these values to the constant file

        this.maxGlassLoad = 100; // TODO: Set these values to the constant file
        this.maxMetalLoad = 100;
        this.maxPaperLoad = 100;
        this.maxPlasticLoad = 100;

        this.currentGlassLoad = 0;
        this.currentMetalLoad = 0;
        this.currentPaperLoad = 0;
        this.currentPlasticLoad = 0;
    }

    // Start Transaction
    public void startTransaction() {
       t = new Transaction();
       inTransaction = true;
    }

    // End Transaction
    public void endTransaction() {
        setCurrentGlassLoad(t.getGlassLoad());
        setCurrentMetalLoad(t.getMetalLoad());
        setCurrentPaperLoad(t.getPaperLoad());
        setCurrentPlasticLoad(t.getPlasticLoad());


        // TODO: Pay the Customer
        inTransaction = false;
    }

    // Insert Recyclable Item
    public boolean addRecyclableItem(RecyclableItem r) {
        if (inTransaction == true) {
            System.out.println("The machine is currently in transaction. Please wait.");
            return false;
        }

        // Check whether the item will fit inside the load
        if (r instanceof Glass) {
            if (r.getWeight() + getCurrentGlassLoad() > getMaxGlassLoad()) {
                return false;
            }
//            setCurrentGlassLoad(getCurrentGlassLoad() + r.getWeight());
            t.addGlassItem((Glass) r, 100); // TODO: Figure out how many cents to include


        } else if (r instanceof Metal) {
            if (r.getWeight() + getCurrentMetalLoad() > getMaxMetalLoad()) {
                return false;
            }
            setCurrentMetalLoad(getCurrentMetalLoad() + r.getWeight());

        } else if (r instanceof Paper) {
            if (r.getWeight() + getCurrentPaperLoad() > getMaxPaperLoad()) {
                return false;
            }
            setCurrentPaperLoad(getCurrentPaperLoad() + r.getWeight());

        } else if (r instanceof Plastic) {
            if (r.getWeight() + getCurrentPlasticLoad() > getMaxPlasticLoad()) {
                return false;
            }
            setCurrentPlasticLoad(getCurrentPlasticLoad() + r.getWeight());

        } else {
            System.out.println("You didn't insert a recyclable item. You are a terrible person.");
            return false;
        }

        // TODO: For each case, you still need to log the transaction and return money

        // Log Transaction Function

        // Return Money Function

        return true;
    }


    // Return Money

    // Price Calculator

    // Cancel Transaction

    // Continuously Display Items

    // Money Available (Private)

    // Get Price


}
