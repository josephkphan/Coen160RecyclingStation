package guithings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralJStuff {
    public static void createJTextLabel(Container pane, String string, int x, int y ){
        JLabel label = new JLabel(string);
        label.setBounds(x,y, label.getPreferredSize().width, label.getPreferredSize().height);
        pane.add(label);

    }
    public static void createJTextLabelCentered(Container pane, String string, int WINDOW_WIDTH){
        JLabel label = new JLabel(string);
        label.setBounds(WINDOW_WIDTH / 2 - label.getPreferredSize().width / 2,
                10, label.getPreferredSize().width, label.getPreferredSize().height);
        pane.add(label);

    }
    public static void createJTextButton(Container pane, String string, int x, int y,int width, int height, Runnable r){
        JButton button = new JButton(string);
        button.setBounds(x, y, width, height);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r.run();
            }
        });
        pane.add(button);
    }
    public static void createJTextButtonCentered(Container pane, String string, int WINDOW_WIDTH, int y, int width, int height,  Runnable r){
        JButton button = new JButton(string);
        button.setBounds(WINDOW_WIDTH / 2 - width / 2, y, width, height);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r.run();
            }
        });
        pane.add(button);
    }

}
