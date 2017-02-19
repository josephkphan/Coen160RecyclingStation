package guithings.currency;

public class Coupon extends USMoney {

    public Coupon() {
    }

    public Coupon(int dollars, int cents) {
        super(dollars, cents);
    }

    public Coupon(USMoney money){
        super(money.getDollars(),money.getCents());
    }
}
