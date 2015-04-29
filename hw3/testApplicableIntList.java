import org.junit.Test;
import static org.junit.Assert.*;

public class testApplicableIntList {
	@Test
	public void testInsert(){
		ApplicableIntList list = new ApplicableIntList();
		list.insert(-3);
		list.insert(5);
		assertEquals(-3, list.head);
		assertEquals(0, list.tail.head);
		assertEquals(5, list.tail.tail.head);		
	}

	@Test
	public void testGet(){
		ApplicableIntList list = new ApplicableIntList();
		list.insert(-3);
		list.insert(5);
		assertEquals(0, list.get(1));
		assertEquals(-3, list.get(0));
		assertEquals(5, list.get(2));		
	}

	@Test
	public void testApply(){
		ApplicableIntList list = new ApplicableIntList();
		list.insert(-3);
		list.insert(5);
		squareEncapsulator square = new squareEncapsulator();
		list.apply(square);
		assertEquals("(0, 9, 25)", list.toString());		
	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(testApplicableIntList.class);		
	}
}