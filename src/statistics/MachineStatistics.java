package statistics;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MachineStatistics {
    ArrayList<Transaction> transactionHistory;
    ArrayList<Long> emptiedHistory;

    public MachineStatistics(){
        transactionHistory = new ArrayList<Transaction>();
        emptiedHistory = new ArrayList<Long>();
    }

    public void addTransaction(Transaction transaction){
        this.transactionHistory.add(transaction);
    }

    public void justEmptied(){
        this.emptiedHistory.add(System.currentTimeMillis()*1000);  // adds current time in seconds
    }

    public ArrayList<Long> getEmptiedHistory() {
        return emptiedHistory;
    }

    public int getNumberOfTransactions(){
        return transactionHistory.size();
    }

    public double getTotalMoneyObtained(){
        double sum = 0;
        for ( Transaction t : transactionHistory){
            sum += t.getTransactionTotal();
        }
        return sum;
    }

    public int getTotalNumberOfGlassItems(){
        int sum = 0;
        for(Transaction t : transactionHistory){
            sum += t.getNumGlassItems();
        }
        return sum;
    }

    public int getTotalNumberOfPlasticItems(){
        int sum = 0;
        for(Transaction t : transactionHistory){
            sum += t.getNumPlasticItems();
        }
        return sum;
    }

    public int getTotalNumberOfPaperItems(){
        int sum = 0;
        for(Transaction t : transactionHistory){
            sum += t.getNumPaperItems();
        }
        return sum;
    }

    public int getTotalNumberOfMetalItems(){
        int sum = 0;
        for(Transaction t : transactionHistory){
            sum += t.getNumMetalItems();
        }
        return sum;
    }

    public double getTotalWeightOfGlassItems(){
        double sum = 0;
        for(Transaction t : transactionHistory){
            sum += t.getGlassLoad();
        }
        return sum;
    }

    public double getTotalWeightOfMetalItems(){
        double sum = 0;
        for(Transaction t : transactionHistory){
            sum += t.getMetalLoad();
        }
        return sum;
    }

    public double getTotalWeightOfPaperItems(){
        double sum = 0;
        for(Transaction t : transactionHistory){
            sum += t.getPaperLoad();
        }
        return sum;
    }

    public double getTotalWeightOfPlasticItems(){
        double sum = 0;
        for(Transaction t : transactionHistory){
            sum += t.getPlasticLoad();
        }
        return sum;
    }

    public JSONObject tojSON(){
        JSONObject o = new JSONObject();
        JSONArray a = new JSONArray();
        JSONArray a2 = new JSONArray();
        try{
            for(Transaction t: transactionHistory)
                a.put(t.toJSON());
            for(Long l : emptiedHistory) {
                JSONObject temp = new JSONObject();
                temp.put("time",l);
                a2.put(temp);
            }
            o.put("transactionHistory", a);
            o.put("emptiedHistory",a2);
        }catch(Exception e){
            e.printStackTrace();
        }
        return o;
    }

    public void fromJSON(JSONObject o){
        try {
            JSONArray a = o.getJSONArray("transactionHistory");
            JSONArray a2 = o.getJSONArray("emptiedHistory");
            for(int i = 0; i < a.length(); i++){
                Transaction t = new Transaction();
                t.fromJSON(a.getJSONObject(i));
                transactionHistory.add(t);
            }

            for(int i = 0; i < a2.length(); i++){
                JSONObject obj = a2.getJSONObject(i);
                emptiedHistory.add( (Long) obj.get("time"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
