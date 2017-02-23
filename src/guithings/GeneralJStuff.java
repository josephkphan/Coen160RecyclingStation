package guithings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralJStuff {
    static void createJTextLabel(Container pane, String string, int x, int y) {
        JLabel label = new JLabel(string);
        label.setBounds(x, y, label.getPreferredSize().width, label.getPreferredSize().height);
        pane.add(label);

    }

    static void createJTextLabelCentered(Container pane, String string, int WINDOW_WIDTH) {
        JLabel label = new JLabel(string);
        label.setBounds(WINDOW_WIDTH / 2 - label.getPreferredSize().width / 2,
                10, label.getPreferredSize().width, label.getPreferredSize().height);
        pane.add(label);

    }

    static void createJTextField(Container pane, JTextField field, int x, int y) {
        field.setBounds(x, y, field.getPreferredSize().width, field.getPreferredSize().height);
        pane.add(field);
    }

    //static Button
    static void createJTextButton(Container pane, String string, int x, int y, int width, int height, Runnable r) {
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

    //dynamic button
    static void createJTextButton(Container pane, JButton button, String string, int x, int y, int width, int height, Runnable r) {
        button.setText(string);
        button.setBounds(x, y, width, height);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r.run();
            }
        });
        pane.add(button);
    }

    static void createJTextButtonCentered(Container pane, String string, int WINDOW_WIDTH, int y, int width, int height, Runnable r) {
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

    // Used for Dynamic images - that you want to manipulate later i.e. remove it off the screen
    static void createJImage(Container pane, JLabel image, int x, int y, int width, int height, String filePath) {
        image.setBounds(x, y, width, height);
        image.setIcon(new ImageIcon(filePath));
        pane.add(image);
    }

    // Used for generic static images (will never move or get changed)
    static void createJImage(Container pane, int x, int y, int width, int height, String filePath) {
        JLabel image = new JLabel("");
        image.setBounds(x, y, width, height);
        image.setIcon(new ImageIcon(filePath));
        pane.add(image);
    }

    static void createJImageCentered(Container pane, int WINDOW_WIDTH, int y, int width, int height, String filePath) {
        JLabel image = new JLabel("");
        image.setBounds(WINDOW_WIDTH / 2 - width / 2, y, width, height);
        image.setIcon(new ImageIcon(filePath));
        pane.add(image);
    }

    static void createJImageCenteredXY(Container pane, int WINDOW_WIDTH, int WINDOW_HEIGHT, int width, int height, String filePath) {
        JLabel image = new JLabel("");
        image.setBounds(WINDOW_WIDTH / 2 - width / 2, WINDOW_HEIGHT / 2 - height / 2, width, height);
        image.setIcon(new ImageIcon(filePath));
        pane.add(image);
    }

    //todo UNTESTED
    static void createJButtonImage(Container pane, int x, int y, int width, int height, String filePath, Runnable r){
        JButton button = new JButton("");
        button.setBounds(x, y, width, height);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r.run();
            }
        });
        pane.add(button);
    }


}
