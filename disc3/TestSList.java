/** file: TestSList.java
*   author: S. Kojoian
*   Tester for SList.java method(s)
*/
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSList{
	@Test
	public void testInsert(){
		SList list = new SList();
		list.insert(10, 0);
		list.insert(4, 5);
		assertEquals(4, list.head.next.val, 1e-11);
		list.insert(2, 1);
		assertEquals(10, list.head.val, 1e-11);
		assertEquals(2, list.head.next.val, 1e-11);
		assertEquals(4, list.head.next.next.val, 1e-11);

		list = new SList();
		list.insert(10, 2);
		assertEquals(10, list.head.val, 1e-11);
	}

	@Test
	public void testSentinelInsert(){
		SentinelSList list = new SentinelSList();
		list.insert(10, 0);
		assertEquals(10, list.front.next.val, 1e-11);
		list.insert(4, 5);
		assertEquals(4, list.front.next.next.val, 1e-11);
		list.insert(2, 1);
		assertEquals(2, list.front.next.next.val, 1e-11);
		assertEquals(4, list.front.next.next.next.val, 1e-11);		
	}
	public static void main(String[] args){
		jh61b.junit.textui.runClasses(TestSList.class);
	}
}