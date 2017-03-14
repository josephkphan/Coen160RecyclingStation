package guithings;

import javax.swing.*;
import java.awt.*;

public class Payout extends JFrame {
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 150;
    private Container pane;
    private JFrame frame;

    public Payout(boolean isPayoutInCash, double transactionTotal) {
        if (isPayoutInCash) {
            frame = new JFrame("Cash Payout");
            pane = frame.getContentPane();

            // Size and display the window.
            Insets frameInsets = frame.getInsets();
            frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                    WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
            frame.setVisible(true);
            pane.setLayout(null);

            String payoutMessage = "Amount of cash you received: $" + Double.toString(transactionTotal);
            GeneralJStuff.createJTextLabelCentered(pane, payoutMessage, WINDOW_WIDTH);
        }
        else {
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
        }
    }
}
