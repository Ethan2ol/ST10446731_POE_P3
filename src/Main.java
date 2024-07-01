import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        //User Input
        String Name = JOptionPane.showInputDialog("Enter your Name");
        String Surname = JOptionPane.showInputDialog("Enter your Surname");
        String Username = "";
        String Password = "";

        boolean validCredentials = false;

        while (!validCredentials) {
            // Username and Password
            Username = JOptionPane.showInputDialog("Enter your Username");
            Password = JOptionPane.showInputDialog("Enter your Password");

            // Username Inspection and Password Inspection
            if (Username.length() <= 5 && Username.contains("_")) {

                if (Password.length() > 8 && (Password.matches(".*[A-Z].*") && Password.matches(".*\\d.*") && Password.matches(".*[!@#$%^&].*"))) {
                    JOptionPane.showMessageDialog(null, "Username and Password successfully captured.");
                    validCredentials = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }
        //Strings for the LoginSystem
        final String finalUsername = Username;
        final String finalPassword = Password;
        final String finalName = Name;
        final String finalSurname = Surname;

        SwingUtilities.invokeLater(() -> {
            LoginSystem loginSystem = new LoginSystem(finalUsername, finalPassword, finalName, finalSurname);
            loginSystem.setVisible(true);
        });
    }
}
