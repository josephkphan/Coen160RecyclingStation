package guithings;


import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame{
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 200;
    private Container pane;
    private JFrame frame;
    private static JTextField usernameField, passwordField;
    private JLabel checkLogin;
    private final boolean bypass = true; //todo FOR TESTING PURPOSES. TAKE OFF FOR DEMO
    private HomeGUI homeGUI;

    public LoginGUI(HomeGUI homeGUI) {
        this.homeGUI = homeGUI;
        frame = new JFrame("Login Window");

        pane = frame.getContentPane();
        // Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);

        createTitle();
        createUsername();
        createPassword();
        createButton();
        checkText();
    }

    private void createTitle() {
        GeneralJStuff.createJTextLabelCentered(pane,"Admin Login", WINDOW_WIDTH);
    }

    private void createUsername(){
        usernameField = new JTextField(10);
        GeneralJStuff.createJTextLabel(pane,"Username: ",50, 50);
        GeneralJStuff.createJTextField(pane,usernameField,150, 50);
    }

    private void createPassword(){
        GeneralJStuff.createJTextLabel(pane,"Password: ",50, 75);
        passwordField = new JTextField(10);
        GeneralJStuff.createJTextField(pane,passwordField,150, 75);

    }

    private void checkText(){
        checkLogin = new JLabel("");
        checkLogin.setBounds(150, 100,200, 25);
        pane.add(checkLogin);
    }

    private void createButton() {
        Runnable r = () -> {
            String user = usernameField.getText();
            String pass = passwordField.getText();
            if(bypass || (user.equals("user") && pass.equals("pass"))){
                new RecyclingMonitoringStationGUI(homeGUI);
                close();
            }else{
                checkLogin.setForeground(Color.red);
                checkLogin.setText("Wrong!");
            }
        };

        GeneralJStuff.createJTextButton(pane,"Submit",100, 125,
                100,32,r);
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }



}
