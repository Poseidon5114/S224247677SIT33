package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

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
    public void testCancelDueToWindSpeed() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(71.0, 0.0));
    }

    @Test
    public void testCancelDueToPrecipitation() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.5));
    }

    @Test
    public void testCancelDueToBothModerate() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 4.5));
    }

    @Test
    public void testWarnDueToWind() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
    }

    @Test
    public void testWarnDueToRain() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 5.0));
    }

    @Test
    public void testAllClear() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 1.0));
    }

    @Test
    public void testTrueNumberIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(5));
    }

    @Test
    public void testPrime1() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
    }

    @Test
    public void testPrime3() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
    }

    @Test
    public void testNonPrime4() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testPrime7() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
    }

    @Test
    public void testNonPrime10() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(10));
    }
}
