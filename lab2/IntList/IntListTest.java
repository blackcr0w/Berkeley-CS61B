import static org.junit.Assert.*;
import org.junit.Test;

public class IntListTest {

    /** Example test that verifies correctness of the IntList.list static 
     *  method. The main point of this is to convince you that 
     *  assertEquals knows how to handle IntLists just fine.
     */

    @Test 
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.list(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
      IntList L = IntList.list(1, 2, 3);
      IntList.dSquareList(L);
      assertEquals(IntList.list(1, 4, 9), L);
    }

    /** Do not use the new keyword in your tests. You can create
     *  lists using the handy IntList.list method.  
     * 
     *  Make sure to include test cases involving lists of various sizes
     *  on both sides of the operation. That includes the empty list, which
     *  can be instantiated, for example, with 
     *  IntList empty = IntList.list(). 
     *
     *  Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     *  Anything can happen to A. 
     */

    //TODO:  Create testSquareListRecursive()
    @Test
    public void testSquareListRecursive(){
        IntList list = IntList.list(0, -3, 5, 11);
        IntList squaredList = IntList.squareListRecursive(list);
        assertEquals(IntList.list(0, 9, 25, 121), squaredList);
        assertEquals(IntList.list(0, -3, 5, 11), list);
    }
    //TODO:  Create testDcatenate and testCatenate
    @Test
    public void testDcatenate(){
        IntList list1 = IntList.list(1, 2, 3);
        IntList list2 = IntList.list(4, 5, 6);
        IntList result = IntList.dcatenate(list1, list2);
        IntList expected = IntList.list(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
        assertEquals(list1, result);

        list1 = null;
        result = IntList.dcatenate(list1, list2);
        expected = list2;
        assertEquals(list2, result);

        list1 = IntList.list(1, 2, 3);
        list2 = null;
        expected = list1;
        result = IntList.dcatenate(list1, list2);
        assertEquals(list1, result);
    }

    @Test
    public void testCatenate(){
        IntList list1 = IntList.list(-2, -1, 0);
        IntList list2 = IntList.list(1, 2, 3);
        IntList result = IntList.catenate(list1, list2);
        IntList expected = IntList.list(-2, -1, 0, 1, 2, 3);

        assertEquals(IntList.list(-2, -1, 0), list1);
        assertEquals(IntList.list(1, 2, 3), list2);
        assertEquals(expected, result);

        list1 = null;
        result = IntList.catenate(list1, list2);
        assertEquals(list2, result);

        list1 = IntList.list(-2, -1, 0);
        list2 = null;
        result = IntList.catenate(list1, list2);
        assertEquals(list1, result);

        list1 = null;
        list2 = null;
        result = IntList.catenate(list1, list2);
        assertEquals(null, result);
    }

    @Test
    public void testRecursiveCatenate(){
        IntList list1 = IntList.list(-2, -1, 0);
        IntList list2 = IntList.list(1, 2, 3);
        IntList result = IntList.recCatenate(list1, list2);
        IntList expected = IntList.list(-2, -1, 0, 1, 2, 3);

        assertEquals(IntList.list(-2, -1, 0), list1);
        assertEquals(IntList.list(1, 2, 3), list2);
        assertEquals(expected, result);

        list1 = null;
        result = IntList.recCatenate(list1, list2);
        assertEquals(list2, result);

        list1 = IntList.list(-2, -1, 0);
        list2 = null;
        result = IntList.recCatenate(list1, list2);
        assertEquals(list1, result);

        list1 = null;
        list2 = null;
        result = IntList.recCatenate(list1, list2);
        assertEquals(null, result);
    }

    @Test
    public void testDReverseList(){
    	IntList list = IntList.list(1, 2, 3, 4);
    	IntList reversed = IntList.reverseNonDestructive(list);
    	IntList expected = IntList.list(4, 3, 2, 1);
    	assertEquals(expected, reversed);

    	list = null;
    	reversed = IntList.reverseNonDestructive(list);
    	assertEquals(list, reversed);

    	list = IntList.list(3);
    	reversed = IntList.reverseNonDestructive(list);
    	assertEquals(list, reversed);
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(IntListTest.class);
    }       
}   
