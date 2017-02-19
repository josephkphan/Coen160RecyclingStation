package machine;

import recyclable.RecyclableItem;
import recyclable.Glass;
import recyclable.Metal;
import recyclable.Paper;
import recyclable.Plastic;


public class RecyclingMachine {
    // Capacity Related Data Members
    private double maxGlassLoad, currentGlassLoad;
    private double maxMetalLoad, currentMetalLoad;
    private double maxPaperLoad, currentPaperLoad;
    private double maxPlasticLoad, currentPlasticLoad;

    // Machine Information
    private int id;
    private int xCoord, yCoord;
    private double money, availableMoney;

    // Setters and Getters
    public double getMaxPaperLoad() {
        return maxPaperLoad;
    }

    public double getCurrentPaperLoad() {
        return currentPaperLoad;
    }

    public void setCurrentPaperLoad(double currentPaperLoad) {
        this.currentPaperLoad = currentPaperLoad;
    }

    public double getMaxGlassLoad() {
        return maxGlassLoad;
    }

    public double getCurrentGlassLoad() {
        return currentGlassLoad;
    }

    public void setCurrentGlassLoad(double currentGlassLoad) {
        this.currentGlassLoad = currentGlassLoad;
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

    public double getMaxMetalLoad() {
        return maxMetalLoad;
    }

    public double getCurrentMetalLoad() {
        return currentMetalLoad;
    }

    public void setCurrentMetalLoad(double currentMetalLoad) {
        this.currentMetalLoad = currentMetalLoad;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(double availableMoney) {
        this.availableMoney = availableMoney;
    }

    // Constructor
    public RecyclingMachine(int xCoord, int yCoord, int id) {
        this.maxGlassLoad = 100;
        this.maxMetalLoad = 100;
        this.maxPaperLoad = 100;
        this.maxPlasticLoad = 100;

        this.currentGlassLoad = 0;
        this.currentMetalLoad = 0;
        this.currentPaperLoad = 0;
        this.currentPlasticLoad = 0;

        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.id = id;
    }

    public RecyclingMachine(int xCoord, int yCoord, int id, double maxGlassLoad, double maxMetalLoad, double maxPaperLoad, double maxPlasticLoad) {
        this.maxGlassLoad = maxGlassLoad;
        this.maxMetalLoad = maxMetalLoad;
        this.maxPaperLoad = maxPaperLoad;
        this.maxPlasticLoad = maxPlasticLoad;

        this.currentGlassLoad = 0;
        this.currentMetalLoad = 0;
        this.currentPaperLoad = 0;
        this.currentPlasticLoad = 0;

        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.id = id;
    }


    // Start
    // TODO: Create different states for the recycling machine

    // Insert Recyclable Item
    public boolean addRecyclableItem(RecyclableItem r) {
        // Check whether the item will fit inside the load
        if (r instanceof Glass) {
            if (r.getWeight() + getCurrentGlassLoad() > getMaxGlassLoad()) {
                return false;
            }
            setCurrentGlassLoad(getCurrentGlassLoad() + r.getWeight());

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

    // Log Transaction

    // Return Money

    // Price Calculator

    // Cancel Transaction

    // Continuously Display Items

    // Show ID

    // Money Available (Private)


}
