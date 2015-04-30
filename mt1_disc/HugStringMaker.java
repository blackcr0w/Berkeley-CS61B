public class HugStringMaker {
	private static CNode makeHugStringHelper(String s){
		if (s == null){
			return null;
		}

		CNode list = new CNode(s.charAt(0), null);
		CNode ptr = list;
		for (int i = 1; i < s.length(); i++){
			ptr.next = new CNode(s.charAt(i), null);
			ptr = ptr.next;
		}

		return list;
	}

	public static CNode makeHugString(String s){
		return makeHugStringHelper(s);
	}

	public static CNode swapSpace(CNode list){
		CNode ptr = list;
		while (list != null){
			if (list.head == ' '){
				list.head = '6';
				list.next = new CNode('1', new CNode('B', list.next));				
			}
			list = list.next;
		}
		return ptr;
	}

	public static void main(String[] args){
		CNode start = makeHugString("brah  brah");


		CNode swaped = swapSpace(start);
		while (swaped != null){
			System.out.println(swaped.head);
			swaped = swaped.next;
		}

	}
}