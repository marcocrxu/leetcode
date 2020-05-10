public class leetcode_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        /*获得长度*/
        int len=1;
        ListNode tempNode=head;
        while(tempNode.next!=null){
            len++;
            tempNode=tempNode.next;
        }
        k=k%len;
        if(k==0)
            return head;
        k=len-k;
        /*循环链表*/
        tempNode.next=head;
        for(int i=0;i<k;i++){
            head=head.next;
            tempNode=tempNode.next;
        }
        tempNode.next=null;
        return head;
    }
}
