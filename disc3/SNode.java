/** file: SNode.java
*   author: S. Kojoian
*   Implementation of double Node
*/
public class SNode{
	public SNode next;
	public double val;

	public SNode(double val, SNode next){
		this.val = val;
		this.next = next;
	}
}