package statistics;

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

    public int getNumberOfTransactions(){
        return transactionHistory.size();
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

    public ArrayList<Long> getEmptiedHistory() {
        return emptiedHistory;
    }

    public double getTotalWeightOfGlassItems(){
        double sum = 0;
        return sum;
    }
}
