/** Tests the Sort class
 *  @author Josh Hug
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {

    /** Tests the Sort.sort method. */
    @Test
    public void testSort() {
	String[] strings = new String[]{"My", "Name", "Is", "Sergey", "Kojoian"};
	Sort.sort(strings);
	assertArrayEquals(new String[]{"Is", "Kojoian", "My", "Name", "Sergey"}, strings);

	strings = new String[]{"Hello"};
	Sort.sort(strings);
	assertArrayEquals(new String[]{"Hello"}, strings);
    }
    
    @Test
    public void testSwap() {
	String[] strings = {"My", "Name", "Is", "Sergey", "Kojoian"};
	Sort.swap(0, 2, strings);
	String[] expected = {"Is", "Name", "My", "Sergey", "Kojoian"};
	assertArrayEquals(expected, strings);
    }

    /** Tests the Sort.indexOfSmallest method */
    @Test
    public void testIndexOfSmallest() {
	String[] strings = {"My", "Name", "Is", "Sergey", "Kojoian"};
	int smallest_index = Sort.getSmallestIndex(0, strings);
	int expected = 2;
	assertEquals(expected, smallest_index);

	smallest_index = Sort.getSmallestIndex(3, strings);
	expected = 4;
	assertEquals(expected, smallest_index);
    }

    /** Runs tests.
     */
    public static void main(String[] args) {
	jh61b.junit.textui.runClasses(TestSort.class);
    }
} 
