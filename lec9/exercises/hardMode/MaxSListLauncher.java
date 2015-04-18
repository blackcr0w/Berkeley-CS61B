/** 
 *  @author Josh Hug
 */

/* MaxSList launcher that you can experiment with. */
public class MaxSListLauncher { 
    public static void main(String[] args) {
    	SList msl = new MaxSList(100);
    	msl.insertFront(50);
        /* Both cause compilation errors: */
        //System.out.println(sl.max());
        //MaxSList msl2 = sl;

        // causes compilation error
        //MaxSList msl4 = (SList) new MaxSList(5);
    }
} 