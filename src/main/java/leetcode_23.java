import java.util.*;

public class leetcode_23 {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        ListNode head=merge(lists,0,lists.length);
        return head;
    }
    public static ListNode merge(ListNode[] lists, int start, int end) {
        if (start + 1 == end)
            return lists[start];
        else if (start + 2 == end)
            return mergeTwoLists(lists[start], lists[start + 1]);
        else {
            int mid = (start + end) / 2;
            return mergeTwoLists(merge(lists, start, mid), merge(lists, mid, end));
        }
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode l3;
        ListNode temp_l1,temp_l2;
        if(l1.val<l2.val) {
            temp_l1=l1.next;
            temp_l2=l2;
            l3 = l1;
        }
        else {
            temp_l2=l2.next;
            temp_l1=l1;
            l3 = l2;
        }
        ListNode head=l3;
        while(temp_l1!=null&&temp_l2!=null){
            if(temp_l1.val<temp_l2.val) {
                l3.next = temp_l1;
                l3 = l3.next;
                temp_l1 = temp_l1.next;
            }
            else {
                l3.next = temp_l2;
                l3 = l3.next;
                temp_l2 = temp_l2.next;
            }
        }
        if(temp_l1!=null){
            l3.next=temp_l1;
        }
        else{
            l3.next=temp_l2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1=stringToListNode("[-10,-9,-9,-3,-1,-1,0]");
        ListNode l2=stringToListNode("[-5]");
        ListNode l3=stringToListNode("[4]");
        ListNode l4=stringToListNode("[8]");
        ListNode l5=stringToListNode("[]");
        ListNode l6=stringToListNode("[-9,-6,-5,-4,-2,2,3]");
        ListNode l7=stringToListNode("[-3,-3,-2,-1,0]");
        ListNode res=mergeKLists(new ListNode[]{l1,l2,l3,l4,l5,l6,l7});
        prettyPrintLinkedList(res);
    }

}
