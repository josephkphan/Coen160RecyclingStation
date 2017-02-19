package machine;

import recyclable.RecyclableItem;
import recyclable.Glass;
import recyclable.Paper;
import recyclable.Plastic;
//import recyclable.Metal; // TODO: Make Metal Recyclable Items


public class RecyclingMachine {
    // Capacity Related Data Members
    private double maxPaperLoad, currentPaperLoad;
    private double maxGlassLoad, currentGlassLoad;
    private double maxPlasticLoad, currentPlasticLoad;
    private double maxMetalLoad, currentMetalLoad;

    // Machine Information
    private int id;
    private int xCoord, yCoord;
    private double money, availableMoney;

    // Setters and Getters
    public double getMaxPaperLoad() { return maxPaperLoad; }

    public void setMaxPaperLoad(double maxPaperLoad) { this.maxPaperLoad = maxPaperLoad; }

    public double getCurrentPaperLoad() { return currentPaperLoad; }

    public void setCurrentPaperLoad(double currentPaperLoad) { this.currentPaperLoad = currentPaperLoad; }

    public double getMaxGlassLoad() { return maxGlassLoad; }

    public void setMaxGlassLoad(double maxGlassLoad) { this.maxGlassLoad = maxGlassLoad; }

    public double getCurrentGlassLoad() { return currentGlassLoad; }

    public void setCurrentGlassLoad(double currentGlassLoad) { this.currentGlassLoad = currentGlassLoad; }

    public double getMaxPlasticLoad() { return maxPlasticLoad; }

    public void setMaxPlasticLoad(double maxPlasticLoad) { this.maxPlasticLoad = maxPlasticLoad; }

    public double getCurrentPlasticLoad() { return currentPlasticLoad; }

    public void setCurrentPlasticLoad(double currentPlasticLoad) { this.currentPlasticLoad = currentPlasticLoad; }

    public double getMaxMetalLoad() { return maxMetalLoad; }

    public void setMaxMetalLoad(double maxMetalLoad) { this.maxMetalLoad = maxMetalLoad; }

    public double getCurrentMetalLoad() { return currentMetalLoad; }

    public void setCurrentMetalLoad(double currentMetalLoad) { this.currentMetalLoad = currentMetalLoad; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getxCoord() { return xCoord; }

    public void setxCoord(int xCoord) { this.xCoord = xCoord; }

    public int getyCoord() { return yCoord; }

    public void setyCoord(int yCoord) { this.yCoord = yCoord; }

    public double getMoney() { return money; }

    public void setMoney(double money) { this.money = money; }

    public double getAvailableMoney() { return availableMoney; }

    public void setAvailableMoney(double availableMoney) { this.availableMoney = availableMoney; }

    // Constructor
    public RecyclingMachine(int xCoord, int yCoord, int id) {
        this.maxPaperLoad= 100;
        this.maxGlassLoad = 100;
        this.maxPlasticLoad = 100;
        this.maxMetalLoad = 100;

        this.currentPaperLoad = 0;
        this.currentGlassLoad = 0;
        this.currentPlasticLoad = 0;
        this.currentMetalLoad = 0;

        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.id = id;
    }

    // Start
    // TODO: Create different states for the recycling machine

    // Insert Item
    public boolean addRecyclableItem(RecyclableItem r) {
        // Check whether the item will fit inside the load

        // Add item to the current load

        // Call Function to Log a Transaction

        // Call Return Money Function


        return true;
    }

//    /* Actions to do on Machine */
//    public boolean addRecyclableItem(RecyclableItem r) {
//        if (r instanceof Paper) {
//            if (r.getWeight() + getCurrentPaperLoad() > getMaxPaperLoad()) {
//                //todo implement me -- Case CANNOT ADD ANYMORE PAPER
//                return false;
//            }
//            tempNumPaperItems++;
//            tempPaperLoad += r.getWeight();
//        } else if (r instanceof Plastic) {
//            if (r.getWeight() + getCurrentPlasticLoad() > getMaxPlasticLoad()) {
//                //todo implement me -- Case CANNOT ADD ANYMORE Plastic
//                return false;
//            }
//            tempNumPlasticItems++;
//            tempPlasticLoad += r.getWeight();
//        } else if (r instanceof Glass) {
//            if (r.getWeight() + getCurrentGlassLoad() > getMaxPlasticLoad()) {
//                //todo implement me -- Case CANNOT ADD ANYMORE Plastic
//                return false;
//            }
//            tempNumGlassItems++;
//            tempGlassLoad += r.getWeight();
//        } else {
//            return false;
//            //todo !!!!! THEY PUT IN SHIT. SLAP THEIR ASS
//        }
//        return true;
//    }

    // Log Transaction

    // Return Money

    // Price Calculator

    // Cancel Transaction

    // Continuously Display Items

    // Show ID

    // Money Available (Private)


}
