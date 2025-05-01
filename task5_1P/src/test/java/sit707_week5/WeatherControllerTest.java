package sit707_week5;

import org.junit.*;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemperatures;
    private static int nHours;

    @BeforeClass
    public static void setUp() {
        // Initialize the WeatherController instance
        wController = WeatherController.getInstance();
        
        // Retrieve the number of hours of data (currently 3 hours per day)
        nHours = wController.getTotalHours();
        
        // Initialize the array to store hourly temperatures
        hourlyTemperatures = new double[nHours];
        
        // Store the temperature values for each hour
        for (int i = 0; i < nHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDown() {
        // Close the WeatherController instance after tests are complete
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "224247677"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Hitesh Bhatia";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Initialize the min temperature to the maximum possible value
        double minTemperature = Double.MAX_VALUE;
        
        // Loop through the hourly temperatures and find the minimum value
        for (double temp : hourlyTemperatures) {
            if (temp < minTemperature) minTemperature = temp;
        }

        // Assert that the minimum temperature matches the cached value from the controller
        Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0.001);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Initialize the max temperature to the minimum possible value
        double maxTemperature = Double.MIN_VALUE;
        
        // Loop through the hourly temperatures and find the maximum value
        for (double temp : hourlyTemperatures) {
            if (temp > maxTemperature) maxTemperature = temp;
        }

        // Assert that the maximum temperature matches the cached value from the controller
        Assert.assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0.001);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Calculate the sum of all temperatures
        double sum = 0;
        for (double temp : hourlyTemperatures) {
            sum += temp;
        }
        
        // Calculate the average temperature
        double avg = sum / hourlyTemperatures.length;

        // Assert that the average temperature matches the cached value from the controller
        Assert.assertEquals(avg, wController.getTemperatureAverageFromCache(), 0.001);
    }

    @Test
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
//        System.out.println("+++ testTemperaturePersist +++");
//
//        String persistTime = wController.persistTemperature(10, 19.5);
//        String now = new SimpleDateFormat("H:m:s").format(new Date());
//        System.out.println("Persist time: " + persistTime + ", now: " + now);
//
//        Assert.assertTrue(persistTime.equals(now));
    }
}
