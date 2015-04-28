import org.junit.Test;
import static org.junit.Assert.*;

public class TestSortedComparableList {
	@Test
	public void testInsert(){
		SortedComparableList list = new SortedComparableList();
		list.insert(-3);
		list.insert(5);
		assertEquals(-3, list.head);
		assertEquals(0, list.tail.head);
		assertEquals(5, list.tail.tail.head);
	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(TestSortedComparableList.class);

	}
}