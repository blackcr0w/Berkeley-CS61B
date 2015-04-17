/** file: SentinelSList.java
*   author: S. Kojoian
*   Singly Linked list with sentinel nodes
*/
public class SentinelSList{
	public SNode back;
	public SNode front;
	public SentinelSList(){
		this.back = new SNode(0, null);
		this.front = new SNode(0, back);
	}

	public void insert(double val, int position){
		SNode iter = front;
		for (int i = 0; i < position; i++){
			if (iter.next == back){
				iter.next = new SNode(val, back);
				return;
			}
			iter = iter.next;
		}
		iter.next = new SNode(val, iter.next);
	}
}