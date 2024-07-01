import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFeatureTest {

    public static int totalHours;

    public TaskFeatureTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testTaskFeature() {
        System.out.println("taskFeature");
        TaskFeatureTest.taskFeature();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private static void taskFeature() {

    }

    @Test
    public void testShowOptionDialog() {
        System.out.println("showOptionDialog");
        int expResult = 0;
        int result = TaskFeatureTest.showOptionDialog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private static int showOptionDialog() {
        return 0;
    }

    @Test
    public void testAddTasks() {
        System.out.println("addTasks");
        TaskFeatureTest.addTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private static void addTasks() {

    }

    @Test
    public void testShowInputDialog() {
        System.out.println("showInputDialog");
        String message = "";
        String expResult = "";
        String result = TaskFeatureTest.showInputDialog(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private static String showInputDialog(String message) {
        return null;
    }

    @Test
    public void testShowMessageDialog() {
        System.out.println("showMessageDialog");
        String message = "";
        TaskFeatureTest.showMessageDialog(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private static void showMessageDialog(String message) {

    }
}