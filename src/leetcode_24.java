
public class leetcode_24 {
    public static ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        if(head.next.next==null){
            head.next.next=head;
            head.next=null;
            return head;
        }
        ListNode addHead=new ListNode(0);
        addHead.next=head;
        ListNode l1=head.next;
        ListNode l2=head;
        ListNode pre=addHead;
        int count=0;
        while(l1!=null) {
            if(count%2==0){
                /*进行一次替换*/
                pre.next=l1;
                l2.next=l1.next;
                l1.next=l2;
                l1=l2;
                l2=pre.next;
            }
            count++;
            l1=l1.next;
            l2=l2.next;
            pre=pre.next;
        }

        return addHead.next;
    }

    public static void main(String[] args){
        ListNode head=ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode.prettyPrintLinkedList(swapPairs(head));
    }


}
