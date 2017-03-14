package resources;

import currency.Cash;
import currency.USMoney;

public class Constants {
    public static int GLASS_PRICE = 300;
    public static int METAL_PRICE = 400;
    public static int PAPER_PRICE = 100;
    public static int PLASTIC_PRICE = 200;

    public static double MAX_GLASS_LOAD = 100;
    public static double MAX_METAL_LOAD = 100;
    public static double MAX_PAPER_LOAD = 100;
    public static double MAX_PLASTIC_LOAD = 100;

    public static String getPrice(int cents) {
        USMoney temp = new Cash(0, cents);
        return temp.toString();
    }
}
