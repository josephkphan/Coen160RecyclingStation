package machine;

import recyclable.Glass;
import recyclable.Paper;
import recyclable.Plastic;
import recyclable.RecyclableItem;

public class RecyclingMachine {

    // Capacity Related Data Members
    private double maxPaperLoad, currentPaperLoad;
    private double maxGlassLoad, currentGlassLoad;
    private double maxPlasticLoad, currentPlasticLoad;

    // Machine Information
    private int id;
    private int xCoord, yCoord;
    private double money, maxMoney;

    // Storage Info
    private int numTransactions;
    private int numPlasticItems, numPaperItems, numGlassItems;

    // Temporary Variables for Transactions
    private double tempPlasticLoad, tempPaperLoad, tempGlassLoad;
    private double transactionTotal;
    private int tempNumPlasticItems, tempNumPaperItems, tempNumGlassItems;

    public RecyclingMachine(double maxPaperLoad, double maxGlassLoad, double maxPlasticLoad, double maxMoney, int id, int xCoord, int yCoord) {
        this.maxPaperLoad = maxPaperLoad;
        this.maxGlassLoad = maxGlassLoad;
        this.maxPlasticLoad = maxPlasticLoad;
        this.maxMoney = maxMoney;
        this.id = id;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public RecyclingMachine(int id, int xCoord, int yCoord) {
        this.maxGlassLoad = 100;
        this.maxPaperLoad = 100;
        this.maxPlasticLoad = 100;
        this.maxMoney = 100;
        this.id = id;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }


    //TODO IF RETURN FALSE, GUI HANDLER SHOULD CHANGE MACHINE ON MAP = RED
    //TODO Check for money condiiton- do oyu ahve enough to pay?

    /* Actions to do on Machine */
    public boolean addRecyclableItem(RecyclableItem r) {
        if (r instanceof Paper) {
            if (r.getWeight() + getCurrentPaperLoad() > getMaxPaperLoad()) {
                //todo implement me -- Case CANNOT ADD ANYMORE PAPER
                return false;
            }
            tempNumPaperItems++;
            tempPaperLoad += r.getWeight();
        } else if (r instanceof Plastic) {
            if (r.getWeight() + getCurrentPlasticLoad() > getMaxPlasticLoad()) {
                //todo implement me -- Case CANNOT ADD ANYMORE Plastic
                return false;
            }
            tempNumPlasticItems++;
            tempPlasticLoad += r.getWeight();
        } else if (r instanceof Glass) {
            if (r.getWeight() + getCurrentGlassLoad() > getMaxPlasticLoad()) {
                //todo implement me -- Case CANNOT ADD ANYMORE Plastic
                return false;
            }
            tempNumGlassItems++;
            tempGlassLoad += r.getWeight();
        } else {
            return false;
            //todo !!!!! THEY PUT IN SHIT. SLAP THEIR ASS
        }
        return true;
    }

    //todo Check for empty Transaction?
    public void finishTransaction(){
        currentGlassLoad += tempGlassLoad;
        currentPaperLoad += tempPaperLoad;
        currentPlasticLoad += tempPlasticLoad;
        numGlassItems += tempNumGlassItems;
        numPaperItems += tempNumPaperItems;
        numPlasticItems += tempNumPlasticItems;
        money -= transactionTotal;
        transactionTotal++;
        resetTempVariables();
    }

    public void cancelTransction(){
        resetTempVariables();
    }

    private void resetTempVariables(){
        tempGlassLoad = tempPaperLoad = tempPlasticLoad = 0;
        tempNumGlassItems = tempNumPaperItems = tempNumPlasticItems = 0;
        transactionTotal = 0;
    }

    public void emptyPlasticLoad() {
        setCurrentPlasticLoad(0);
    }

    public void emptyPaperLoad() {
        setCurrentPaperLoad(0);
    }

    public void emptyGlassLoad() {
        setCurrentGlassLoad(0);
    }

    public void restockMoney(){
        setMoney(getMaxMoney());
    }

    /* Setters Getters Pertaining to Paper Objects */
    public double getMaxPaperLoad() {
        return maxPaperLoad;
    }

    public void setMaxPaperLoad(double maxPaperLoad) {
        this.maxPaperLoad = maxPaperLoad;
    }

    public double getCurrentPaperLoad() {
        return currentPaperLoad;
    }

    private void setCurrentPaperLoad(double currentPaperLoad) {
        this.currentPaperLoad = currentPaperLoad;
    }

    /* Setters Getters Pertaining to Glass Objects */
    public double getMaxGlassLoad() {
        return maxGlassLoad;
    }

    public void setMaxGlassLoad(double maxGlassLoad) {
        this.maxGlassLoad = maxGlassLoad;
    }

    public double getCurrentGlassLoad() {
        return currentGlassLoad;
    }

    private void setCurrentGlassLoad(double currentGlassLoad) {
        currentGlassLoad = currentGlassLoad;
    }

    /* Setters Getters Pertaining to Plastic Objects */
    public double getMaxPlasticLoad() {
        return maxPlasticLoad;
    }

    public void setMaxPlasticLoad(double maxPlasticLoad) {
        this.maxPlasticLoad = maxPlasticLoad;
    }

    public double getCurrentPlasticLoad() {
        return currentPlasticLoad;
    }

    private void setCurrentPlasticLoad(double currentPlasticLoad) {
        currentPlasticLoad = currentPlasticLoad;
    }

    /* Other Getters */
    public int getId() {
        return id;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(double maxMoney) {
        this.maxMoney = maxMoney;
    }
}
