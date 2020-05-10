
public class leetcode_19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0)
            return head.next;
        if(n==1){
            if(head.next==null)
                return null;
            ListNode temp=head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
            return head;
        }
        ListNode l1,l2,l2_pre;
        l1=head;l2=head;l2_pre=head;
        int count=1;
        while(l1.next!=null){
            if(count>n)
                l2_pre=l2_pre.next;
            if(count>=n)
                l2=l2.next;
            l1=l1.next;
            count++;
        }
        if(l2.equals(l2_pre))
            return head.next;
        l2_pre.next=l2.next;
        l2=null;
        return head;
    }

    public static void main(String[] args){
        ListNode l1,l2,l3,l4,l5;
        l1=new ListNode(1);
        l2=new ListNode(2);
        l3=new ListNode(3);
        l4=new ListNode(4);
        l5=new ListNode(5);
        l1.next=l2;
        l2.next=null;
        l3.next=null;
        //l4.next=l5;
        //l5.next=null;

        ListNode l0=removeNthFromEnd(l1,2);
        System.out.println(000);
    }

}
