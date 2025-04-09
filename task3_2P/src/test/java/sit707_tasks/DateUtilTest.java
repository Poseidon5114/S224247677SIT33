package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
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
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31 Should Increment To February1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31 Should Decrement To January30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		 DateUtil date = new DateUtil(1, 1, 2024);
		 System.out.println("Min Jan 1 Increment > " + date);
		 date.increment();
		 System.out.println(date);
		 Assert.assertEquals(2, date.getDay());
		 Assert.assertEquals(1, date.getMonth());
	}
	
	
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		  DateUtil date = new DateUtil(1, 1, 2024);
		  System.out.println("Min Jan 1 Decrement > " + date);
		  date.decrement();
		  System.out.println(date);
		  Assert.assertEquals(31, date.getDay());
		  Assert.assertEquals(12, date.getMonth());
		  Assert.assertEquals(2023, date.getYear());
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	
	@Test
	public void testFebruaryMax29ShouldIncrementToMarch1() {
	    // February max boundary area: max+1
	    DateUtil date = new DateUtil(29, 2, 2024); 
	    System.out.println("February max should increment to March 1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(3, date.getMonth());
	    Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testFebruaryMax29ShouldDecrementToFebruary28() {
	    // February max boundary area: max-1
	    DateUtil date = new DateUtil(29, 2, 2024);
	    System.out.println("February max should decrement to February 28 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(28, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testFebruaryNominal() {
	    int rand_day_1_to_29 = 1 + new Random().nextInt(29);
	    DateUtil date = new DateUtil(rand_day_1_to_29, 2, 2024);
	    System.out.println("February nominal day > " + date);
	    date.increment();
	    System.out.println(date);
	}

	@Test
	public void testFebruaryMin1ShouldIncrementToFebruary2() {
	    DateUtil date = new DateUtil(1, 2, 2024);
	    System.out.println("February 1 should increment to February 2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testFebruaryMin1ShouldDecrementToJanuary31() {
	    DateUtil date = new DateUtil(1, 2, 2024);
	    System.out.println("February 1 should decrement to January 31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMarchMax31ShouldIncrementToApril1() {
	    DateUtil date = new DateUtil(31, 3, 2024);
	    System.out.println("March max should increment to April 1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(4, date.getMonth());
	    Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMarchMax31ShouldDecrementToMarch30() {
	    DateUtil date = new DateUtil(31, 3, 2024);
	    System.out.println("March max should decrement to March 30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMarchNominal() {
	    int rand_day_1_to_31 = 1 + new Random().nextInt(31);
	    DateUtil date = new DateUtil(rand_day_1_to_31, 3, 2024);
	    System.out.println("March nominal day > " + date);
	    date.increment();
	    System.out.println(date);
	}

	@Test
	public void testMarchMin1ShouldIncrementToMarch2() {
	    DateUtil date = new DateUtil(1, 3, 2024);
	    System.out.println("March 1 should increment to March 2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMarchMin1ShouldDecrementToFebruary29() {
	    DateUtil date = new DateUtil(1, 3, 2024);
	    System.out.println("March 1 should decrement to February 29 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testAprilMax30ShouldIncrementToMay1() {
	    DateUtil date = new DateUtil(30, 4, 2024);
	    System.out.println("April max should increment to May 1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(5, date.getMonth());
	    Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testAprilMax30ShouldDecrementToApril29() {
	    DateUtil date = new DateUtil(30, 4, 2024);
	    System.out.println("April max should decrement to April 29 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testAprilNominal() {
	    int rand_day_1_to_30 = 1 + new Random().nextInt(30);
	    DateUtil date = new DateUtil(rand_day_1_to_30, 4, 2024);
	    System.out.println("April nominal day > " + date);
	    date.increment();
	    System.out.println(date);
	}

	@Test
	public void testAprilMin1ShouldIncrementToApril2() {
	    DateUtil date = new DateUtil(1, 4, 2024);
	    System.out.println("April 1 should increment to April 2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testAprilMin1ShouldDecrementToMarch31() {
	    DateUtil date = new DateUtil(1, 4, 2024);
	    System.out.println("April 1 should decrement to March 31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMayMax31ShouldIncrementToJune1() {
	    DateUtil date = new DateUtil(31, 5, 2024);
	    System.out.println("May max should increment to June 1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMayMax31ShouldDecrementToMay30() {
	    DateUtil date = new DateUtil(31, 5, 2024);
	    System.out.println("May max should decrement to May 30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMayNominal() {
	    int rand_day_1_to_31 = 1 + new Random().nextInt(31);
	    DateUtil date = new DateUtil(rand_day_1_to_31, 5, 2024);
	    System.out.println("May nominal day > " + date);
	    date.increment();
	    System.out.println(date);
	}

	@Test
	public void testMayMin1ShouldIncrementToMay2() {
	    DateUtil date = new DateUtil(1, 5, 2024);
	    System.out.println("May 1 should increment to May 2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMayMin1ShouldDecrementToApril30() {
	    DateUtil date = new DateUtil(1, 5, 2024);
	    System.out.println("May 1 should decrement to April 30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(4, date.getMonth());
	}


}
