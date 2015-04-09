/** Class for printing args in sorted order.
 *  Exercise for slide 12:  http://goo.gl/9IhE0U
 *  Your goal is to figure out what the recursive call should look like.
 *  @author Josh Hug
 */

public class SortRecursionExercise {
    /** Sorts the array. */
    public static void sort(String[] a) {
        // find the smallest item
        // move it to the front (by swapping)
        // selection sort the rest
       // --> ?? recursive call ?? <--
	Sort.sort(a);
	
    }

    /** Prints A. */
    public static void print(String[] a) {
	Sort.print(a);
    }	

    /** Prints args in sorted order.
     */

    public static void main(String[] args) {
	if (args.length == 0){
		System.out.println("Requires at least one argument");
		return;
	}
	sort(args);   
	print(args);
    }    
} 
