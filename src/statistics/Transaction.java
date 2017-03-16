package statistics;

import org.json.JSONObject;
import recyclable.Glass;
import recyclable.Metal;
import recyclable.Paper;
import recyclable.Plastic;

/**
 * Create a Data Structure to contain the information needed for a transaction
 */
public class Transaction {
    private int transactionTotal;
    private int numPlasticItems, numPaperItems, numGlassItems, numMetalItems;
    private double plasticLoad, paperLoad, glassLoad, metalLoad;
    private boolean payoutInCash;

    public Transaction() {
        transactionTotal = 0;
        numMetalItems = numPlasticItems = numPaperItems = numGlassItems = 0;
        plasticLoad = paperLoad = glassLoad = metalLoad = 0.00001;
        payoutInCash = true;
    }

    public void addGlassItem(Glass item, int cents) {
        numGlassItems++;
        glassLoad += item.getWeight();
        transactionTotal += cents;
    }

    public void addMetalItem(Metal item, int cents) {
        numMetalItems++;
        metalLoad += item.getWeight();
        transactionTotal += cents;
    }

    public void addPaperItem(Paper item, int cents) {
        numPaperItems++;
        paperLoad += item.getWeight();
        transactionTotal += cents;
    }

    public void addPlasticItem(Plastic item, int cents) {
        numPlasticItems++;
        plasticLoad += item.getWeight();
        transactionTotal += cents;
    }

    public void setPayoutToCoupon() {
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

    public JSONObject toJSON() {
        JSONObject o = new JSONObject();
        try {
            o.put("transactionTotal", transactionTotal);
            o.put("numPlasticItems", numPlasticItems);
            o.put("numPaperItems", numPaperItems);
            o.put("numGlassItems", numGlassItems);
            o.put("numMetalItems", numMetalItems);
            o.put("plasticLoad", plasticLoad);
            o.put("paperLoad", paperLoad);
            o.put("glassLoad", glassLoad);
            o.put("metalLoad", metalLoad);
            o.put("payoutInCash", payoutInCash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public void fromJSON(JSONObject o) {
        try {
            transactionTotal = (int) o.get("transactionTotal");
            numPlasticItems = (int) o.get("numPlasticItems");
            numPaperItems = (int) o.get("numPaperItems");
            numGlassItems = (int) o.get("numGlassItems");
            numMetalItems = (int) o.get("numMetalItems");
            plasticLoad = (double) o.get("plasticLoad");
            paperLoad = (double) o.get("paperLoad");
            glassLoad = (double) o.get("glassLoad");
            metalLoad = (double) o.get("metalLoad");
            payoutInCash = (boolean) o.get("payoutInCash");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
