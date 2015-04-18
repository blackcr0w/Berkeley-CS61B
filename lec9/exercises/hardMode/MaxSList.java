/** 
 *  @author Josh Hug
 */

public class MaxSList extends SList {
    /* your code here */
    private int max;

    public MaxSList(){
    	super();
    }
    public MaxSList(int x){
    	super(x);
    	max = x;
    }

    /** gets the maximum element of the list */
    public int max(){
    	return max;
    }

    @Override
    /** Inserts into the front and updates max */
    public void insertFront(int x){
    	super.insertFront(x);
    	if (x > max){
    		max = x;
    	}
    }

    @Override
    /** Inserts into the back and updates max */
    public void insertBack(int x){
    	super.insertBack(x);
    	if (x > max){
    		max = x;
    	}
    }
}