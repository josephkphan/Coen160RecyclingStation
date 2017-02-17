package machine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class RecyclingMonitoringStation extends JFrame implements ActionListener  {
    private JTextField feetHeightField, inchHeightField, poundsField;
    protected JLabel feetHeightLabel, inchHeightLabel, poundsLabel, BMILabel;
    private JButton calculateButton;
    private JPanel topPanel, bottomPanel;

    public RecyclingMonitoringStation() {
        super("RecyclingMonitoringStation");
        setSize(500, 100);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        topPanel = new JPanel();
        bottomPanel = new JPanel();

        feetHeightLabel = new JLabel("ft: ", JLabel.CENTER);
        topPanel.add(feetHeightLabel);
        feetHeightField = new JTextField(10);
        topPanel.add(feetHeightField);

        inchHeightLabel = new JLabel("in: ", JLabel.CENTER);
        topPanel.add(inchHeightLabel);
        inchHeightField = new JTextField(10);
        topPanel.add(inchHeightField);

        poundsLabel = new JLabel("lbs: ", JLabel.CENTER);
        topPanel.add(poundsLabel);
        poundsField = new JTextField(10);
        topPanel.add(poundsField);

        calculateButton = new JButton("Calculate BMI");
        calculateButton.addActionListener(this);
        bottomPanel.add(calculateButton);

        BMILabel = new JLabel("");
        bottomPanel.add(BMILabel);

        container.add(topPanel, BorderLayout.NORTH);
        container.add(bottomPanel, BorderLayout.SOUTH);

        // show the frame in the center of the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Handles actions when calculate button is pressed. It will take input from the fields and calculate the BMI
     * it will a pop up if any of the inputs are invalid
     */
    public void actionPerformed(ActionEvent e) {
        String inch = inchHeightField.getText();
        String feet = feetHeightField.getText();
        String pounds = poundsField.getText();

        try {
            int heightInInches = Integer.parseInt(inch) + 12 * Integer.parseInt(feet);

            int weightInPounds = Integer.parseInt(pounds);
            float BMI = weightInPounds * 703 / heightInInches / heightInInches;
            BMILabel.setText("Your BMI: " + BMI);
            if(BMI < 18.5 || BMI > 24.9){
                BMILabel.setForeground(Color.RED);
            }else{
                BMILabel.setForeground(Color.BLACK);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please type in a valid integer");
        }
    }
}