package guithings;

import currency.Cash;

import javax.swing.*;
import java.awt.*;

/**
 * Payout:
 * This will display to their user their final output from usigng he RCM.
 * If the RCM is out of cash it will say “Coupon” instead of Cash
 */
public class Payout extends JFrame {
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 150;
    private Container pane;
    private JFrame frame;

    public Payout(boolean isPayoutInCash, int transactionTotal) {
        if (isPayoutInCash) {
            frame = new JFrame("Cash Payout");
            pane = frame.getContentPane();

            // Size and display the window.
            Insets frameInsets = frame.getInsets();
            frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                    WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
            frame.setVisible(true);
            pane.setLayout(null);

            Cash transactionTotalInDollars = new Cash(0, transactionTotal);

            String payoutMessage = ("Amount of cash you received: " + transactionTotalInDollars);
            GeneralJStuff.createJTextLabelCentered(pane, payoutMessage, WINDOW_WIDTH);
            GeneralJStuff.createJImageCentered(pane, WINDOW_WIDTH, 30, 128, 128, "src/assets/money.png");
        } else {
            // Coupon
            frame = new JFrame("Coupon Payout");
            pane = frame.getContentPane();

            // Size and display the window.
            Insets frameInsets = frame.getInsets();
            frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                    WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
            frame.setVisible(true);
            pane.setLayout(null);

            String payoutMessage = "Amount of money in your coupon: $" + Double.toString(transactionTotal);
            GeneralJStuff.createJTextLabelCentered(pane, payoutMessage, WINDOW_WIDTH);
            GeneralJStuff.createJImageCentered(pane, WINDOW_WIDTH, 125, 64, 64, "src/assets/money.png");
        }
    }
}
