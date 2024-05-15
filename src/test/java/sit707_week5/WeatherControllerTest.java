package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] temperatureValues;
    private static int nHours;

    @BeforeClass
    public static void setUp() {
        // Initializing common objects and data
        wController = WeatherController.getInstance();
        nHours = wController.getTotalHours();
        temperatureValues = new double[nHours];
        for (int i = 0; i < nHours; i++) {
            temperatureValues[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDown() {
        // Shutting down controller after all tests
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "S220473748";
        Assert.assertNotNull("Student ID is S220473748", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Rohit Rajendra Kadam";
        Assert.assertNotNull("Student name is Rohit Rajendra Kadam", studentName);
    }

    @Test
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
        System.out.println("+++ testTemperaturePersist +++");

        // Mock the current time for testing
        SimpleDateFormat dateFormat = new SimpleDateFormat("H:m:s");
        Date mockNow = new Date();
        String mockNowString = dateFormat.format(mockNow);

        // Call the persistence method
        String persistTime = wController.persistTemperature(10, 19.5);

        // Verify the persistence time matches the mock time
        Assert.assertEquals(mockNowString, persistTime);
    }
}
