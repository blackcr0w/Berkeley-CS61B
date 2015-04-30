/** 
 *  @author Josh Hug
 */
import java.util.Comparator;

public class NumOnes implements Comparator<Integer>{
    /** Implements the Comparator interface, allowing
    *   NumOnes to act as a comparator
    */
    public int compare(Integer a, Integer b){
        int numOnesInA = numOnes(a);
        int numOnesInB = numOnes(b);
        if (numOnesInA == numOnesInB){
            return 0;
        } else if (numOnesInA > numOnesInB){
            return 1;
        } else {
            return -1;
        }
    }

    /** Adds two numbers using binary operations */
    private static int add(int x, int y) {
        // YOUR CODE HERE
        int part = x ^ y;
        int carry = x & y;
        if (carry == 0){
            return part;
        } else {
            carry <<= 1;
            return add(part, carry);
        }        
    }

    /** Returns the number of ones in the binary representation of x. */
    private static int helper(int countOnes, int x){
    	if (x == 0){
    		return countOnes;
    	} else {
    		if ((x & 0x1) == 1){
    			countOnes = add(countOnes, 1);
    		}

    		return helper(countOnes, x >>> 1);
    	}
    }

    public static int numOnes(int x) {
        /* Your code here. */
        return helper(0, x);
    }
} 