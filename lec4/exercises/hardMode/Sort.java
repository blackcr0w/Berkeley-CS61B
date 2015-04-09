/** Class for printing args in sorted order.
 *  @author Josh Hug
 */

public class Sort {
    /** Sorts the array. */
    public static void sort(String[] a) {
	sort(0, a);	
    }

    private static void sort(int index, String[] a){
	if (index >= a.length){
		return;
	}
	int minIndex = getSmallestIndex(index, a);
	swap(index, minIndex, a);
	sort(index+1, a);	
    }

    public static int getSmallestIndex(int index, String[] a){
	String smallest = a[index];
	int smallestIndex = index;
	for (int i = index; i < a.length; i++){
		if (smallest.compareTo(a[i]) > 0){
			smallestIndex = i;
			smallest = a[i];
		}
	}

	return smallestIndex;
    }

    public static void swap(int index, int minIndex, String[] a){
	String tmp = a[index];
	a[index] = a[minIndex];
	a[minIndex] = tmp;
    }

    /** Prints A. */
    public static void print(String[] a) {
	String result = "[";
	for (int i = 0; i < a.length-1; i++){
		result += a[i];
		result += ", ";
	}

	result += a[a.length-1];
	result += "]";

	System.out.println(result);
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
