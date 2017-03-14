package guithings;
import statistics.MachineStatistics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    /**
     * ToDo: CommentMe CommentMe CommentMe CommentMe CommentMe CommentMe
     */
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

    /**
     * ToDo: CommentMe CommentMe CommentMe CommentMe CommentMe CommentMe
     * @return
     */
    public Map<Color, Sales> getData() {
        return sales;
    }
}

class BarChart extends JPanel {
    private Map<Color, Integer> bars = new LinkedHashMap<Color, Integer>();

    /**
     *
     * @param data
     */
    public BarChart(Map<Color, Sales> data) {
        for (Color keyColor : data.keySet()) {
            Sales sale = data.get(keyColor);
            bars.put(keyColor, new Integer(sale.salesInK));
        }
    }

    /**
     * ToDo: CommentMe CommentMe CommentMe CommentMe CommentMe CommentMe
     */
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

        int width = (getWidth() / bars.size()) - 2;
        int x = 1;
        for (Color color : bars.keySet()) {
            int value = bars.get(color);
            int height = (int) ((getHeight() - 5) * ((double) value / max));
            g.setColor(color);
            g.fillRect(x, getHeight() - height, width, height);
            g.setColor(Color.black);
            g.drawRect(x, getHeight() - height, width, height);
            x += (width + 2);
        }
    }

    /**
     * ToDo: CommentMe CommentMe CommentMe CommentMe CommentMe CommentMe
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bars.size() * 10 + 2, 50);
    }
}

public class MachineStatisticGUI {
    public MachineStatisticGUI() {
        JFrame frame = new JFrame("Bar Chart");
        DataManager datamanager = new DataManager();
        datamanager.readDataFromFile(".//src//guithings//sales.txt");

        BarChart chart = new BarChart(datamanager.getData());
        chart.setSize(500, 700);

        frame.setSize(600, 800);
        frame.getContentPane().add(chart);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


//// RCM Model
//1) Create an Map with the key as the RecycleItem and the value as the counter for how many times that item was recycled.
//2) In the recycle method of the RCM, iterate through the map and compare if the type of the item of the key is equal
//to the type of the item passed into the method, then you increment the counter for that item in the map.
