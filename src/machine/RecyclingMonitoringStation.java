package machine;

import guithings.resources.Constants;
import recyclable.Glass;
import recyclable.Paper;
import recyclable.Plastic;
import recyclable.RecyclableItem;

import java.util.ArrayList;

public class RecyclingMonitoringStation {
    private ArrayList<RecyclingMachine> recyclingMachines;

    //TODO ADD IN DAILTY, MONTHlY DATA

    public RecyclingMonitoringStation() {
        recyclingMachines = new ArrayList<RecyclingMachine>();
    }

    public int getNumberOfRecyclingMachines(){
        return recyclingMachines.size();
    }

    public RecyclingMachine getRecyclingMachine(int i) throws Exception{
        if(i>=getNumberOfRecyclingMachines())
            throw new Exception("Out of Index");
        return recyclingMachines.get(i);
    }

    public boolean checkLogin(String username, String password){
        if (username.equals("username") && password.equals("password"))
            return true;
        return false;
    }

    public static double checkItemPrice(RecyclableItem r){
        if(r instanceof Plastic){
            return r.getWeight() * Constants.PLASTIC_PRICE;
        }else if (r instanceof Paper){
            return r.getWeight() * Constants.PAPER_PRICE;
        }else if (r instanceof Glass){
            return r.getWeight() * Constants.GLASS_PRICE;
        }else{
            //todo TRASH ??
            return -1;
        }
    }

    public void seeOverallStats(){
        // accumulate all the data from the different machines?
    }
}