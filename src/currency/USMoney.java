package currency;

public abstract class USMoney {
    private int dollars;
    private int cents;

    public USMoney() {
        dollars = 0;
        cents = 0;
    }

    public USMoney(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
        if(this.dollars <0){this.dollars = 0;}
        if(this.cents<0){this.cents=0;}
        convertCentsToDollars();
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public void convertCentsToDollars(){
        while(getCents()>=100){
            setCents(cents-100);
            setDollars(dollars+1);
        }
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
        convertCentsToDollars();

    }

    /**
     *
     * @param dollars : takes in the number of dollars to add to current money
     * @param cents : takes in the the number of cents to add to current money
     * return type : void
     */
    public void add(int dollars, int cents) {
        this.dollars += dollars;
        this.cents += cents;
        convertCentsToDollars();
    }

    public void add(int cents){
        this.cents += cents;
        convertCentsToDollars();
    }

    public String toString(){
        String s ="$" + Integer.toString(getDollars()) + "." + Integer.toString(getCents());
        if(getCents()==0)
            s += "0";
        return s;
    }

}