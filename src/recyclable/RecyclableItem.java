package recyclable;

/**
 * Recyclable items will have its "type" or class to differentiate them along with this data member weight
 */
public abstract class RecyclableItem {
    private double weight;

    public RecyclableItem(double weight) {
        this.weight = weight;
    }

    public RecyclableItem(){
        //todo Implement me?? Should this me random?
    }

    public double getWeight() {
        return weight;
    }
}
