package guithings;
import machine.RecyclingMachine;
import statistics.MachineStatistics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

interface DataGetter {
    public void readDataFromFile(String fileName);
}

class Sales {
    int year;
    int salesInK;

    public Sales(int year, int salesInK) {
        this.year = year;
        this.salesInK = salesInK;
    }

    public int getAmount() {
        return salesInK;
    }
}

class DataManager implements DataGetter {
    private Map<Color, Sales> sales = new LinkedHashMap<Color, Sales>();

    private Random randomGenerator = new Random();
    private Color[] salesColors;

    public void readDataFromFile(String fileName) {
        Sales saleByQ;

        BufferedReader reader = null;
        int lineCnt = 0;
        try {
            File inFile = new File(fileName);
            reader = new BufferedReader(new FileReader(inFile));

            // ... Loop as long as there are input lines.
            String line = null;

            try {
                while ((line = reader.readLine()) != null) {

                    // split each line into tokens
                    String[] fields = line.split(":");

                    // the String to int conversion happens here
                    int quarter = Integer.parseInt(fields[0].trim());
                    int salesAmount = Integer.parseInt(fields[1].trim());

                    saleByQ = new Sales(quarter, salesAmount);
                    int red = randomGenerator.nextInt(256);
                    int green = randomGenerator.nextInt(256);
                    int blue = randomGenerator.nextInt(256);

                    Color randomColor = new Color(red, green, blue);
                    sales.put(randomColor, saleByQ);
                    ++lineCnt;
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: ");
            System.exit(1);
        }
    }

    public Map<Color, Sales> getData() {
        return sales;
    }
}

class BarChart extends JPanel {
    private Map<Color, Integer> bars = new LinkedHashMap<Color, Integer>();

    public BarChart(Map<Color, Sales> data) {
        for (Color keyColor : data.keySet()) {
            Sales sale = data.get(keyColor);
            bars.put(keyColor, new Integer(sale.salesInK));
        }
    }

    @Override
    protected void paintComponent(Graphics gp) {
        super.paintComponent(gp);
        // Cast the graphics objects to Graphics2D
        Graphics2D g = (Graphics2D) gp;
        // determine longest bar
        int max = Integer.MIN_VALUE;
        for (Integer value : bars.values()) {
            max = Math.max(max, value);
        }
        // paint bars

        int width = (getWidth() / bars.size()) - 5;
        int x = 1;
        int counter = 0;
        for (Color color : bars.keySet()) {
            g.drawString(Integer.toString(2007 + (counter++)), x+25,790);
            int value = bars.get(color);
            int height = (int) ((getHeight() - 5) * ((double) value / max));
            g.setColor(color);
            g.fillRect(x+20, getHeight() - height-20, width, height);
            g.setColor(Color.black);
            g.drawRect(x+20, getHeight() - height-20, width, height);
            x += (width + 2);
        }
        g.drawLine(10,790,800,790);
        g.drawString("Year", 300,800);
        g.drawLine(10,790,10,0);
        g.drawString("# Transactions", 20,350);
        g.drawString("Time Vs. Transactions",300, 50);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bars.size() * 10 + 2, 50);
    }
}

public class MachineStatisticGUI {
    public MachineStatisticGUI(RecyclingMachine recyclingMachine) {
        // Write to the `sales.txt` file for dynamic data
        try {
            File myFoo = new File(".//src/guithings//sales.txt");
            FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
            fooWriter.write("10:7\n");
            fooWriter.write("9:18\n");
            fooWriter.write("8:12\n");
            fooWriter.write("7:20\n");
            fooWriter.write("6:16\n");
            fooWriter.write("5:5\n");
            fooWriter.write("4:9\n");
            fooWriter.write("3:14\n");
            fooWriter.write("2:9\n");
            fooWriter.write("1:6\n");
            fooWriter.write("0:" + Integer.toString(recyclingMachine.getMachineStatistics().getNumberOfTransactions()));
            fooWriter.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Set up the Bar Chart
        JFrame frame = new JFrame("Machine Statistics");
        DataManager datamanager = new DataManager();
        datamanager.readDataFromFile(".//src//guithings//sales.txt");

        BarChart chart = new BarChart(datamanager.getData());
        chart.setSize(500, 700);

        frame.setSize(600, 800);
        frame.getContentPane().add(chart);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}