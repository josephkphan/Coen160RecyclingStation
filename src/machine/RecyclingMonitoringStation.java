package machine;

import guithings.resources.Constants;
import recyclable.Glass;
import recyclable.Paper;
import recyclable.Plastic;
import recyclable.RecyclableItem;

import java.util.ArrayList;
import java.util.Random;

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

    public void changeGlassPraice(int cents){
        Constants.GLASS_PRICE = cents;
    }

    public void changeMetalPrice(int cents){
        Constants.METAL_PRICE = cents;
    }

    public void changePaperPrice(int cents){
        Constants.PAPER_PRICE = cents;
    }

    public void changePlasticPrice(int cents){
        Constants.PLASTIC_PRICE = cents;
    }

    public void addMachine(int x, int y){
        recyclingMachines.add(new RecyclingMachine(x,y,generateMachineID()));
    }

    public void removeMachine(int id){

    }

    private int generateMachineID(){
        Random random = new Random();
        int id;
        boolean newID;
        while (true) {
            id = random.nextInt(10000) + 1;
            newID = true;
            for(RecyclingMachine rm : recyclingMachines){
                if(id == rm.getId()) {
                    newID = false;
                    break;
                }
            }
            if(newID){
                break;
            }
        }
        return id;
    }

}