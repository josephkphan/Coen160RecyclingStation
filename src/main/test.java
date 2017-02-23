/*
 * AbsoluteLayoutDemo.java requires no other files.
 */
package main;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.*;

public class test {
    public test() {



    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new test();
            }
        });
    }
}