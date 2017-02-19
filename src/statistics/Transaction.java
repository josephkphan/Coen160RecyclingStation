package statistics;

import recyclable.Glass;
import recyclable.Metal;
import recyclable.Paper;
import recyclable.Plastic;

public class Transaction {
    private int transactionTotal;
    private int numPlasticItems, numPaperItems, numGlassItems, numMetalItems;
    private double plasticLoad, paperLoad, glassLoad, metalLoad;
    private boolean payoutInCash;

    public Transaction(){
        transactionTotal = 0;
        numMetalItems = numPlasticItems = numPaperItems = numGlassItems = 0;
        plasticLoad = paperLoad = glassLoad = metalLoad = 0;
        payoutInCash = true;
    }

    public void addPlasticItem(Plastic item, int cents){
        numPlasticItems++;
        plasticLoad += item.getWeight();
        transactionTotal += cents;
    }

    public void addPaperItem(Paper item, int cents){
        numPaperItems++;
        paperLoad += item.getWeight();
        transactionTotal += cents;
    }

    public void addGlassItem(Glass item, int cents){
        numGlassItems++;
        glassLoad += item.getWeight();
        transactionTotal += cents;
    }

    public void addMetalItem(Metal item, int cents){
        numMetalItems++;
        metalLoad += item.getWeight();
        transactionTotal += cents;
    }

    public void setPayoutToCoupon(){
        payoutInCash = false;
    }

    public boolean isPayoutInCash() {
        return payoutInCash;
    }

    public int getTransactionTotal() {
        return transactionTotal;
    }

    public int getNumPlasticItems() {
        return numPlasticItems;
    }

    public int getNumPaperItems() {
        return numPaperItems;
    }

    public int getNumGlassItems() {
        return numGlassItems;
    }

    public int getNumMetalItems() {
        return numMetalItems;
    }

    public double getPlasticLoad() {
        return plasticLoad;
    }

    public double getPaperLoad() {
        return paperLoad;
    }

    public double getGlassLoad() {
        return glassLoad;
    }

    public double getMetalLoad() {
        return metalLoad;
    }
}
