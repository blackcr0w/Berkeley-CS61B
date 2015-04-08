/** Additional operations on an IntList.
 *  @author Josh Hug
 */

public class IntListOps {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* your code here */
	if (L == null){
		return null;
	}

	IntList newList = new IntList(L.head + x, null);
	IntList pointer = newList;
	while (L.tail != null){
		L = L.tail;
		pointer.tail = new IntList(L.head + x, null);
		pointer = pointer.tail;
	}

	return newList;	
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* your code here */
	if (L == null){
		return null;
	}
	IntList pointer = L;
	pointer.head += x;
	while (pointer.tail != null){
		pointer = pointer.tail;
		pointer.head += x;
	}

	return L;
    }


    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.tail = new IntList(7, null);    
        L.tail.tail = new IntList(9, null);
        System.out.println(L);
        System.out.println(incrList(L, 3));
	System.out.println("L after non-destro incr.: " + L);
        System.out.println(dincrList(L, 3));
	System.out.println("L after destro incr.: " + L);

    }
} 
