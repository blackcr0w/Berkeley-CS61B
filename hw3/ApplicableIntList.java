import java.util.Formatter;
import java.util.Arrays;
/**
 * ApplicableIntList.java
 * A list that stores integers in ascending order.
 */
public class ApplicableIntList{
    /** First element of list. */
    public int head;
    public int size;
    /** Remaining elements of list. */
    public ApplicableIntList tail;

    /** A list with head HEAD0 and tail TAIL0. */
    public ApplicableIntList(int head0, ApplicableIntList tail0) {
        // REPLACE THIS LINE WITH YOUR SOLUTION
        head = head0;
        tail = tail0;
        size = 1;
    }

    /** A list with null tail, and head = 0. */
    public ApplicableIntList() {
        // REPLACE THIS LINE WITH YOUR SOLUTION
        head = 0;
        tail = null;
        size = 1;
    }

    /** Inserts int i into its correct location, doesn't handle cycles. */
    public void insert(int i) {
        // REPLACE THIS LINE WITH YOUR SOLUTION
        ApplicableIntList ptr = this;
        while (ptr.head < i && ptr.tail != null){
            ptr = ptr.tail;
        }

        if (ptr.head  < i){
            ptr.tail = new ApplicableIntList(i, null);
        } else {
            int tmp = ptr.head;
            ptr.head = i;
            ptr.tail = new ApplicableIntList(tmp, ptr.tail);          
        }

        size += 1;
    }

    /** Returns the i-th int in this list.
     *  The first element, which is in location 0, is the 0th element.
     *  Assume i takes on the values [0, length of list - 1]. */
    public int get(int i) {
        // REPLACE THIS LINE WITH YOUR SOLUTION
        ApplicableIntList ptr = this;
        for (int j = 0; j < i; j++){
            ptr = ptr.tail;
        }
        return ptr.head;
    }

    /** Applies the function f to every item in this list. */
    private void createArrayHelper(IntUnaryFunction f, ApplicableIntList lst, int[] tmpArray){
        int applied;
        int index = 0;

        while (lst != null){
            applied = f.apply(lst.head);
            lst = lst.tail;
            tmpArray[index] = applied;
            index += 1;
        }     
    }

    private void resetValuesHelper(ApplicableIntList lst, int[] tmpArray){
        int index = 0;

          while (lst != null){
            lst.head = tmpArray[index];
            index += 1;
            lst = lst.tail;
        }         
    }

    public void apply(IntUnaryFunction f) {
        // REPLACE THIS LINE WITH YOUR SOLUTION
        int[] tmpArray = new int[size];
        ApplicableIntList ptr = this;

        createArrayHelper(f, ptr, tmpArray);
        Arrays.sort(tmpArray);
        resetValuesHelper(ptr, tmpArray);
     
    }

    /** Returns NULL if no cycle exists, else returns cycle location. */
    private int detectCycles(ApplicableIntList A) {
        ApplicableIntList tortoise = A;
        ApplicableIntList hare = A;
        if (A == null) {
            return 0;
        }
        int cnt = 0;
        while (true) {
            cnt++;
            if (hare.tail != null) {
                hare = hare.tail.tail;
            }
            else{
                return 0;
            }
            tortoise = tortoise.tail;
            if (tortoise == null || hare == null) {
                return 0;
            }
            if (hare == tortoise) {
                return cnt;
            }
        }
    }

    /** Returns true iff X is a ApplicableIntList containing the
     *  same sequence of Comparables as THIS. Cannot handle cycles. */
    public boolean equals(Object x) {
        if (!(x instanceof ApplicableIntList)) {
            return false;
        }
        ApplicableIntList L = (ApplicableIntList) x;
        ApplicableIntList p;
        for (p = this; p != null && L != null; p = p.tail, L = L.tail) {
            if (p.head != L.head) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;
        for (ApplicableIntList p = this; p != null; p = p.tail) {
            out.format("%s%d", sep, p.head);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }
}