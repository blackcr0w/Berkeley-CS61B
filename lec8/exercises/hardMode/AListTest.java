import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the AList class.
 *  @author Josh Hug
 */

public class AListTest {
    @Test
    public void testEmptySize() {
        AList L = new AList();
        assertEquals(0, L.size());
    }

    @Test
    public void testInsertAndSize() {
        AList L = new AList();
        L.insertBack(99);
        L.insertBack(99);
        assertEquals(2, L.size());
    }

    
    @Test
    public void testInsertAndGet() {
    	AList L = new AList();
    	L.insertBack(10);
    	L.insertBack(20);
    	assertEquals(20, L.getBack());
    	assertEquals(20, L.get(1));
    	L.insertBack(30);
    	assertEquals(30, L.getBack());
    	assertEquals(Integer.MIN_VALUE, L.get(3));
    }

    /*
    @Test
    public void testGet() {
    }*/

    @Test
    public void testDelete() {
    	AList L = new AList();
    	L.insertBack(20);
    	L.insertBack(10);
    	assertEquals(2, L.size());
    	L.deleteBack();
    	assertEquals(20, L.getBack());
   	L.deleteBack();
   	assertEquals(0, L.size());

    	L = new AList();
    	L.deleteBack();
    	assertArrayEquals(new int[100], L.items);
    }

    /** Tests insertion of a large number of items.*/
    /*@Test
    public void testMegaInsert() {
    }*/

    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(AListTest.class);
    }
} 