import static org.junit.Assert.*;

import org.junit.Test;

/** Perform tests of the DoubleChain class
 */

public class TestDoubleChain {

    /** Tests the constructor of DoubleChain */
    @Test
    public void testConstructor() {
        DoubleChain d = new DoubleChain(5);
        assertEquals(5,d.getFront().val, 1e-6);
        assertEquals(null, d.getFront().prev);
        assertEquals(null, d.getFront().next);
    }

    @Test
    public void testToString(){
        DoubleChain d = new DoubleChain(5);
        d.insertFront(2);
        d.insertBack(3);
        String expected = "<[2, 5, 3]>";
        String result = d.toString();
        assertEquals(expected, result);
    }

    /** Tests some basic DoubleChain operations. */
    @Test
    public void testBasicOperations() {
        DoubleChain d = new DoubleChain(5);
        assertEquals(5, d.getFront().val, 1e-11);
        assertEquals(5, d.getBack().val, 1e-11);

        d.insertFront(2);
        d.insertFront(1);
        d.insertBack(7);
        d.insertBack(8);
        assertEquals(1, d.getFront().val, 1e-11);
        assertEquals(8, d.getBack().val, 1e-11);
    }

    @Test
    public void testDeleteByIndex(){
        DoubleChain d = new DoubleChain(5);
        d.insertFront(10);
        d.insertBack(-3);
        d.deleteByIndex(1);
        assertEquals(-3, d.getFront().next.val, 1e-11);
        d.deleteByIndex(1);
        assertEquals(10, d.getFront().val, 1e-11);

        d = new DoubleChain(3);
        d.deleteByIndex(0);
        assertEquals(3, d.getFront().val, 1e-11);
    }

    @Test
    public void deleteBack(){
        DoubleChain d = new DoubleChain(5);
        d.insertFront(10);
        d.insertFront(2);
        d.insertBack(-3);
        // assertEquals(4, d.size);

        DoubleChain.DNode result = d.deleteBack();
        assertEquals(-3, result.val, 1e-11);

        d = new DoubleChain(5);
        result = d.deleteBack();
        assertEquals(null, result);
    }

    @Test
    public void testIsClose(){
        double a = 3.421;
        double b = 3.423;
        assertEquals(false, DoubleChain.isClose(a, b));

        a = 3.421001;
        b = 3.421002;
        assertEquals(true, DoubleChain.isClose(a, b));
    }

    @Test
    public void testDeleteByValue(){
        DoubleChain d = new DoubleChain(5);
        d.insertBack(4);
        d.insertBack(3);
        d.insertBack(5);
        d.insertFront(4);
        d.deleteByValue(4);
        assertEquals(5, d.getFront().val, 1e-11);
        assertEquals(5, d.getBack().val, 1e-11);
        assertEquals(3, d.getFront().next.val, 1e-11);

        d = new DoubleChain(-3);
        d.insertFront(6);
        d.insertBack(2);
        d.insertBack(-3);
        d.insertBack(0);
        d.deleteByValue(-3);
        System.out.println(d);
    }

    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestDoubleChain.class);
    }
}
