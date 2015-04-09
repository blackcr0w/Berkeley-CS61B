/*
 * JUnit tests for the Triangle class
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author melaniecebula
 */
public class TriangleTest {
  /**  We've already created a testScalene method.  Please fill in testEquilateral, and additionally
   *   create tests for Isosceles, Negative Sides, and Invalid sides
   **/

    @Test
    public void testScalene() {
        Triangle t = new Triangle(30, 40, 50);
        String result = t.triangleType();
        assertEquals("Scalene", result);
    }

    @Test
    public void testEquilateral() {
      //TODO: FILL IN
	Triangle t = new Triangle(30, 30, 30);
	String result = t.triangleType();
	assertEquals("Equilateral", result);
    }

    //TODO: CREATE MORE TESTS

    @Test
    public void testIsosceles(){
	Triangle t = new Triangle(10, 10, 13);
	String result = t.triangleType();
	assertEquals("Isosceles", result);
    }
    
    @Test
    public void testNegativeSides(){
	Triangle t = new Triangle(-5, 0, 10);
	String result = t.triangleType();
	String expected = "At least one length is less than 0!";
	assertEquals(expected, result);
    }

    @Test
    public void testInvalidSides(){
	Triangle t = new Triangle(3, 4, 9);
	String result = t.triangleType();
        String expected = "The lengths of the triangles do not form a valid triangle!";
	assertEquals(expected, result);
    }

    public static void main(String[] args) {
      //TODO: RUN TESTS (Look in ArithmeticTest.java main method for help!)
	jh61b.junit.textui.runClasses(TriangleTest.class);
    }
}
