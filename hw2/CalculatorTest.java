import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /* Do not change this to be private. For silly testing reasons it is public. */
    public Calculator tester;

    /**
     * setUp() performs setup work for your Calculator.  In short, we 
     * initialize the appropriate Calculator for you to work with.
     * By default, we have set up the Staff Calculator for you to test your 
     * tests.  To use your unit tests for your own implementation, comment 
     * out the StaffCalculator() line and uncomment the Calculator() line.
     **/
    @Before
    public void setUp() {
        // tester = new StaffCalculator(); // Comment me out to test your Calculator
        tester = new Calculator();   // Un-comment me to test your Calculator
    }

    // TASK 1: WRITE JUNIT TESTS
    // YOUR CODE HERE
    @Test
    public void testAdd(){
    	int sum = tester.add(0, 0);
    	int expected = 0;
    	assertEquals(expected, sum);

    	/** buggy:
    	*   expected: 0
    	*   result: -2147483648
    	*/
    	sum = tester.add(-1, 1);
    	expected = 0;
    	assertEquals(expected, sum);

    	sum = tester.add(-3, -2);
    	expected = -5;
    	assertEquals(expected, sum);
    }

    @Test
    public void testMultiply(){
    	int multiple = tester.multiply(-3, 2);
    	int expected = -6;
    	assertEquals(expected, multiple);

    	multiple = tester.multiply(-1, -2);
    	expected = 2;
    	assertEquals(expected, multiple);

    	multiple = tester.multiply(0, -1);
    	expected = 0;
    	assertEquals(expected, multiple);

    	multiple = tester.multiply(3, 2);
    	expected = 6;
    	assertEquals(expected, multiple);
    }
    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(CalculatorTest.class);
    }       
}