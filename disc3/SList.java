/** file: SList.java
*   author: S. Kojoian
*   Singly Linked list of doubles
*/
public class SList{
	public SNode head;

	/** insert VAL into POSITION.
	*   If position is invalid, insert at the end.
	*  
	*   @param: VAL (double)
	*   @param: POSITION (int)
	*/
	public void insert(double val, int position){
		if (position == 0 || head == null){
			head = new SNode(val, head);
		} else {
			SNode iter = head;
			for (int i = 0; i < position-1; i++){
				if (iter.next == null){
					iter.next = new SNode(val, null);
					return;
				}
				iter = iter.next;
			}
			iter.next = new SNode(val, iter.next);
		}
	}
}