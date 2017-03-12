package machine;

import org.json.JSONArray;
import org.json.JSONObject;

import resources.Constants;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RecyclingMonitoringStation {
    private ArrayList<RecyclingMachine> recyclingMachines;

    //TODO ADD IN DAILTY, MONTHlY DATA

    public RecyclingMonitoringStation() {
        recyclingMachines = new ArrayList<RecyclingMachine>();
    }

    public int getNumberOfRecyclingMachines() {
        return recyclingMachines.size();
    }

    public RecyclingMachine getRecyclingMachine(int i) {
//        if (i >= getNumberOfRecyclingMachines())
//            throw new Exception("Out of Index");
        return recyclingMachines.get(i);
    }

    public boolean checkLogin(String username, String password) {
        if (username.equals("username") && password.equals("password"))
            return true;
        return false;
    }

    public void changeGlassPraice(int cents) {
        Constants.GLASS_PRICE = cents;
    }

    public void changeMetalPrice(int cents) {
        Constants.METAL_PRICE = cents;
    }

    public void changePaperPrice(int cents) {
        Constants.PAPER_PRICE = cents;
    }

    public void changePlasticPrice(int cents) {
        Constants.PLASTIC_PRICE = cents;
    }

    public void addMachine(int x, int y) {
        recyclingMachines.add(new RecyclingMachine(x, y, generateMachineID()));
    }

    public void removeMachine(int index) {
        recyclingMachines.remove(index);
    }

    private int generateMachineID() {
        Random random = new Random();
        int id;
        boolean newID;
        while (true) {
            id = random.nextInt(10000) + 1;
            newID = true;
            for (RecyclingMachine rm : recyclingMachines) {
                if (id == rm.getId()) {
                    newID = false;
                    break;
                }
            }
            if (newID) {
                break;
            }
        }
        return id;
    }

    //todo enabling other recycable items

    //todo view by day/week/month

    public ArrayList<RecyclingMachine> getAllMachineStatistics() {
        return recyclingMachines;
    }

    public int getTotalNumberOfGlassItems() {
        int sum = 0;
        for (RecyclingMachine rm : recyclingMachines) {
            sum += rm.getMachineStatistics().getTotalNumberOfGlassItems();
        }
        return sum;
    }

    public int getTotalNumberOfMetalItems() {
        int sum = 0;
        for (RecyclingMachine rm : recyclingMachines) {
            sum += rm.getMachineStatistics().getTotalNumberOfMetalItems();
        }
        return sum;
    }

    public int getTotalNumberOfPaperItems() {
        int sum = 0;
        for (RecyclingMachine rm : recyclingMachines) {
            sum += rm.getMachineStatistics().getTotalNumberOfPaperItems();
        }
        return sum;
    }

    public int getTotalNumberOfPlasticItems() {
        int sum = 0;
        for (RecyclingMachine rm : recyclingMachines) {
            sum += rm.getMachineStatistics().getTotalNumberOfPlasticItems();
        }
        return sum;
    }

    public double getTotalWeightOfGlassItems() {
        double sum = 0;
        for (RecyclingMachine rm : recyclingMachines) {
            sum += rm.getMachineStatistics().getTotalWeightOfGlassItems();
        }
        return sum;
    }

    public double getTotalWeightOfMetalItems() {
        double sum = 0;
        for (RecyclingMachine rm : recyclingMachines) {
            sum += rm.getMachineStatistics().getTotalWeightOfMetalItems();
        }
        return sum;
    }

    public double getTotalWeightOfPaperItems() {
        double sum = 0;
        for (RecyclingMachine rm : recyclingMachines) {
            sum += rm.getMachineStatistics().getTotalWeightOfPaperItems();
        }
        return sum;
    }

    public double getTotalWeightOfPlasticItems() {
        double sum = 0;
        for (RecyclingMachine rm : recyclingMachines) {
            sum += rm.getMachineStatistics().getTotalWeightOfPlasticItems();
        }
        return sum;
    }

    public void saveData() {
        JSONArray a = new JSONArray();
        for (RecyclingMachine rm : recyclingMachines) {
            a.put(rm.toJSON());
        }
        System.out.println("a.toString() = " + a.toString());
        try {
            FileWriter file = new FileWriter("src/data.txt");
            file.write(a.toString());

            file.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void fromJSON(){

        try {
            String content = new Scanner(new File("src/data.txt")).useDelimiter("\\Z").next();
            JSONArray a = new JSONArray(content);
            System.out.println("a.toString() = " + a.toString());

            for(int i =0; i<a.length(); i++){
                RecyclingMachine rm = new RecyclingMachine();
                rm.fromJSON(a.getJSONObject(i));
                recyclingMachines.add(rm);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }


}


