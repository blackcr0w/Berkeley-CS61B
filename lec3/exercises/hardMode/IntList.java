/** Defines a recursive list of integers.
 *  @author Josh Hug
 */

public class IntList {
    public int head;
    public IntList tail;

    public IntList(int h, IntList t) {
        /* your code here */
	head = h;
	tail = t;
    }

    /** Retuns the size of this IntList */
    public int size() {
        /* your code here */
	if (tail == null){
		return 1;
	} else {
		return 1 + tail.size();
	}
    }

    /** Returns the size of this IntList. */
    public int iterativeSize() {
        /* your code here */
	int total = 1;
	IntList traverser = tail;
	while (traverser != null){
		total += 1;
		traverser = traverser.tail;
	}

	return total;
    }

    /** In class exercise 1: 
      * Returns ith item of this IntList. For 
      * simplicity, assume the item exists. */
    public int get(int i) {
        /** your code here */
	IntList p = this;
	while (i != 0){
		p = p.tail;
		i = i - 1;
	} 
	
	return p.head;
    }

    public String toString() {
        /* your code here */
	String result = "[" + head;
	IntList traverser = tail;

	while (traverser != null){
		result += ", " + traverser.head;	
		traverser = traverser.tail;
	}

	return result + "]";
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.tail = new IntList(7, null);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
	System.out.println("L: " + L);
    }
} 
