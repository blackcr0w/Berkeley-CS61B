
public class DoubleChain {
	
	private DNode head;
	private int size;
	
	public DoubleChain(double val) {
		/* your code here. */
		head = new DNode(null, val, null);
		size = 1;
	}

	public DNode getFront() {
		return head;
	}

	/** Returns the last item in the DoubleChain. */		
	public DNode getBack() {
		/* your code here */
		DNode p = head;
		while (p.next != null){
			p = p.next;
		}
		return p;		
	}
	
	/** Adds D to the front of the DoubleChain. */	
	public void insertFront(double d) {
		/* your code here */
		DNode newNode = new DNode(null, d, head);
		head.prev = newNode;
		head = newNode;
		size += 1;
	}
	
	/** Adds D to the back of the DoubleChain. */	
	public void insertBack(double d) {
		/* your code here */
		DNode p = head;
		while (p.next != null){
			p = p.next;
		}
		DNode newNode = new DNode(p, d, null);
		p.next = newNode;
		size += 1;		
	}
	
	/** Removes the last item in the DoubleChain and returns it. 
	  * This is an extra challenge problem. */
	public DNode deleteBack() {
		/* your code here */
		if (size == 1){
			// Can't delete the single item from the list
			return null;
		}

		DNode iter = head;
		while (iter.next != null){
			iter = iter.next;
		}
		iter.prev.next = null;
		// Don't let the resulting DNode have pointers
		// to the previous or the next node in the list
		// so that it is completely detached.
		iter.prev = null;
		size -= 1;
		return iter;
	}

	/** Removes the item at index i. */
	public void deleteByIndex(int index){
		if (size == 1){
			return;
		} else if (index == 0) {
			head = head.next;
			size -= 1;
			return;
		}
		DNode iter = head;
		for (int i = 0; i < index && i < size; i++){
			iter = iter.next;
		}
		iter.prev.next = iter.next;
		if (iter.next != null){
			iter.next.prev = iter.prev;
		}
		size -= 1;
	}
	
	/** Returns a string representation of the DoubleChain. 
	  * This is an extra challenge problem. */
	private String toStringHelper(DNode node){
		if (node.next == null){
			return (Math.floor(node.val) == node.val) ? String.valueOf((int) node.val) : String.valueOf(node.val);
		} else {
			String result = (Math.floor(node.val) == node.val) ? String.valueOf((int) node.val) : String.valueOf(node.val);
			return result + ", " + toStringHelper(node.next);
		}
	}

	public String toString() {
		/* your code here */		
		return "<[" + toStringHelper(head) + "]>";
	}

	public static class DNode {
		public DNode prev;
		public DNode next;
		public double val;
		
		private DNode(double val) {
			this(null, val, null);
		}
		
		private DNode(DNode prev, double val, DNode next) {
			this.prev = prev;
			this.val = val;
			this.next =next;
		}
	}
	
}
