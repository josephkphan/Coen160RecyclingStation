package currency;

/**
 * Used to differentiate between coupons and cash
 */
public class Cash extends USMoney {
    public Cash() {
    }

    public Cash(int dollars, int cents) {
        super(dollars, cents);
    }

    public Cash(USMoney money) {
        super(money.getDollars(), money.getCents());
    }
}
