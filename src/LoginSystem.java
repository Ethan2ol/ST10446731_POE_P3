import javax.swing.*;
import java.awt.event.*;

public class LoginSystem extends JFrame implements ActionListener {

    // Parts needed
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private String Username;
    private String Password;
    private String Name;
    private String Surname;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginSystem loginSystem = new LoginSystem(args[0], args[1], args[2], args[3]);
            loginSystem.setVisible(true);
        });
    }
    //the Strings from the Main class
    public LoginSystem(String username, String password, String name, String surname) {
        this.Username = username;
        this.Password = password;
        this.Name = name;
        this.Surname = surname;
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // For simplicity, we'll use absolute positioning

        // Username Label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 80, 25);
        add(usernameLabel);

        // Username Text Field
        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        add(usernameField);

        // Password Label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 50, 80, 25);
        add(passwordLabel);

        // Password Text Field
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        loginButton.addActionListener(this);
        add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputUsername = usernameField.getText();
        String inputPassword = new String(passwordField.getPassword());

        // Check if the input username and password match the stored ones
        if (inputUsername.equals(Username) && inputPassword.equals(Password)) {
            JOptionPane.showMessageDialog(this, "Welcome " +Name +" " + Surname + " it is great to see you.");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }
}
