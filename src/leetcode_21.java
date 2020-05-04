public class leetcode_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
