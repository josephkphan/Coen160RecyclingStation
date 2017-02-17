package machine;

import java.util.ArrayList;

public class RecyclingMonitoringStation {
    private ArrayList<RecyclingMachine> recyclingMachines;

    public RecyclingMonitoringStation() {
        recyclingMachines = new ArrayList<RecyclingMachine>();
    }

    public int getNumberOfRecyclingMachines(){
        return recyclingMachines.size();
    }
}