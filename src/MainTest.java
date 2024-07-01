import javax.swing.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    String Name = "Kyle";
    String Surname = "Cheddar";
    String Username = "kyl_1";
    String Password = "Ch&&sec@ke99!";

    String validPassword;
    String invalidPassword;
    String validUsername;
    String invalidUsername;

    @Test
    public void ValidOrInvalid_OnlyUsername(){
        SwingUtilities.invokeLater(() -> {
            validUsername = "kyl_1";
            invalidUsername = "kyle!!!!!!!";

            if (Username==validUsername) {
                assertEquals("kyl_1", Username);
                System.out.println("Welcome " + Name + " " + Surname + ", good to see.");
            }
            else if (Username==invalidUsername)
            {
                assertEquals("kyle!!!!!!!", Username);
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
            else {
                System.out.println("Formatted Incorrectly.");
            }

        });
    }

    @Test
    public void ValidOrInvalid_Password(){
        validPassword = "Ch&&sec@ke99!";
        invalidPassword = "password";

        if (Password == validPassword) {
            assertEquals("Ch&&sec@ke99!", Password);
            System.out.println("Password successfully captured.");
        }
        else if (Password == invalidPassword) {
            assertEquals("password", Password);
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        }
        else{
            System.out.println("Formatted Incorrectly.");
        }

    }
    @Test
    public void testLogin_SuccessOrFailure() {
        validUsername = Username;
        validPassword = Password;

        boolean login = "kyl_1".equals(validUsername) && "Ch&&sec@ke99!".equals(validPassword);
        boolean flogin = !"kyl_1".equals(validUsername) && !"Ch&&sec@ke99!".equals(validPassword);

        if (login) {
            assertTrue(login);
            System.out.println("Login Successful");
        } else {
            assertFalse(flogin);
            System.out.println("Login Unsucessful");
        }
    }
    //Checking username True/False
    @Test
    public void LoginSuccessOrFailure() {
        String username = Username;
        validUsername = "kyl_1";
        invalidUsername = "kyle!!!!!!!";
        boolean Success = (username == validUsername);

        assertTrue(Success);
    }
    @Test
    public void LoginPassword_SuccessOrFailure() {
        String password = Password;
        validPassword = "Ch&&sec@ke99!";
        invalidPassword= "password";
        boolean Success = (password ==validPassword );

        assertTrue(Success);

    }

}