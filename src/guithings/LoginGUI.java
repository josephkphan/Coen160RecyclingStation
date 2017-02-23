package guithings;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 200;
    private Container pane;
    private Insets paneInsets;
    private JFrame frame;
    private JTextField usernameField, passwordField;
    private JLabel checkLogin;
    private final boolean bypass = true; //todo FOR TESTING PURPOSES. TAKE OFF FOR DEMO

    public LoginGUI() {
        frame = new JFrame("Login Window");

        pane = frame.getContentPane();
        //Size and display the window.
        Insets frameInsets = frame.getInsets();
        frame.setSize(WINDOW_WIDTH + frameInsets.left + frameInsets.right,
                WINDOW_HEIGHT + frameInsets.top + frameInsets.bottom);
        frame.setVisible(true);
        pane.setLayout(null);
        paneInsets = pane.getInsets();
        createTitle();
        createUsername();
        createPassword();
        createButton();
        checkText();
    }

    private void createTitle() {
        JLabel homeLabel = new JLabel("Admin Login");
        homeLabel.setBounds(WINDOW_WIDTH / 2 - homeLabel.getPreferredSize().width / 2,
                paneInsets.top + 10, homeLabel.getPreferredSize().width, homeLabel.getPreferredSize().height);
        pane.add(homeLabel);
    }

    private void createUsername(){
        JLabel username = new JLabel("Username: ");
        username.setBounds(paneInsets.left+50, paneInsets.top + 50,
                username.getPreferredSize().width, username.getPreferredSize().height);
        pane.add(username);

        usernameField = new JTextField(10);
        usernameField.setBounds(paneInsets.left+150, paneInsets.top + 50,
                usernameField.getPreferredSize().width, usernameField.getPreferredSize().height);
        pane.add(usernameField);

    }

    private void createPassword(){
        JLabel password = new JLabel("Username: ");
        password.setBounds(paneInsets.left+50, paneInsets.top + 75,
                password.getPreferredSize().width, password.getPreferredSize().height);
        pane.add(password);

        passwordField = new JTextField(10);
        passwordField.setBounds(paneInsets.left+150, paneInsets.top + 75,
                passwordField.getPreferredSize().width, passwordField.getPreferredSize().height);
        pane.add(passwordField);
    }

    private void checkText(){
        checkLogin = new JLabel("");
        checkLogin.setBounds(paneInsets.left+150, paneInsets.top + 100,200, 25);
        pane.add(checkLogin);
    }


    private void createButton() {

        JButton button = new JButton("Submit");
        button.setBounds(paneInsets.left+100, paneInsets.top+125, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = passwordField.getText();
                if(bypass || (user.equals("user") && pass.equals("pass"))){
                    new RecyclingMonitoringStationGUI();
                    close();
                }else{
                    checkLogin.setForeground(Color.red);
                    checkLogin.setText("Wrong!");
                }
            }
        });
        pane.add(button);
    }

    private void close() {
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }



}
