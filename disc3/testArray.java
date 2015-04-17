/** file: testArray.java
*   author: S. Kojoian
*   Tester for Array.java utility functions
*/
import org.junit.Test;
import static org.junit.Assert.*;

public class testArray {
	@Test
	public void testInsert(){
		int[] array = new int[]{1, 4, 6, 3};
		int[] result = Array.insert(array, 25, 0);
		result = Array.insert(result, 10, 4);
		assertArrayEquals(new int[]{25, 1, 4, 6, 10, 3}, result);

		array = new int[0];
		result = Array.insert(array, 5, 4);
		assertArrayEquals(new int[]{0, 0, 0, 0, 5}, result);
	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(testArray.class);
	}
}