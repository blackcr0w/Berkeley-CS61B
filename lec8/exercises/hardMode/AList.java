/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    /** Creates an empty list. */
    private int size;
    public int[] items;

    public AList() {
    	items = new int[100];
    	size = 0;
    }

    /** Inserts X into the back of the list. */
    public void insertBack(int x) {
    	if (size == items.length){
    		int[] newItems = new int[size*2];
    		System.arraycopy(items, 0, newItems, 0, size);
    		newItems[size] = x;
    		items = newItems;
    	} else {
     		items[size] = x;
    		 		
    	}
    	size += 1;  
    }

    /** Returns the item from the back of the list. */
    public int getBack() {
    	if (size == 0){
    		return Integer.MIN_VALUE;
    	}
        	return items[size-1];        
    	
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        if (i < 0 || i >= size){
        	return Integer.MIN_VALUE;
        } else {
        	return items[i];
        }        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int deleteBack() {
    	if (size == 0){
    		return Integer.MIN_VALUE;
    	} else {
    		int result = items[size-1];
         		size = size - 1;
         		return result;
    	}
    }

    /** Returns the number of items in the list. */
    public int size() {
        	return size;        
    }
} 