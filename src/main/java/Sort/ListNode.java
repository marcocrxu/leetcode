package Sort;

import com.eclipsesource.json.JsonArray;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x){ val=x;}

	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for(int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for(int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static void prettyPrintLinkedList(ListNode node) {
		while (node != null && node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}

		if (node != null) {
			System.out.println(node.val);
		} else {
			System.out.println("Empty LinkedList");
		}
	}

	public int getLen(ListNode head){
		ListNode p=head;
		int count=0;
		while(p!=null){
			p=p.next;
			count++;
		}
		return count;
	}

	public static int[][] stringToInt2dArray(String input) {
		JsonArray jsonArray = JsonArray.readFrom(input);
		if (jsonArray.size() == 0) {
			return new int[0][0];
		}

		int[][] arr = new int[jsonArray.size()][];
		for (int i = 0; i < arr.length; i++) {
			JsonArray cols = jsonArray.get(i).asArray();
			arr[i] = stringToIntegerArray(cols.toString());
		}
		return arr;
	}
}