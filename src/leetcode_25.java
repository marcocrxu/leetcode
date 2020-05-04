import java.util.List;

public class leetcode_25 {
    public static int getLen(ListNode head){
        ListNode p=head;
        int count=0;
        while(p!=null){
            p=p.next;
            count++;
        }
        return count;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        if(k==1)
            return head;
        if(getLen(head)<k)
            return head;
        /*找到第k个节点*/
        ListNode now=head;
        int count=1;
        ListNode temp,p,q;
        ListNode addHead=new ListNode(0);
        addHead.next=head;
        ListNode pre=addHead;
        while(now!=null){
            if(count==k) {
                temp=pre.next;
                pre.next=now;
                q=now.next;
                pre=temp;
                p=pre;
                q=pre;
                while(pre!=now){
                    temp=q;
                    q=q.next;
                    temp.next=q.next;
                    q.next=pre;
                    pre=q;
                    q=temp;
                }
                pre=p;
                now=p.next;
                count=1;
            }
            count++;
            if(now==null)
                break;
            now=now.next;
        }
        return addHead.next;
    }
    public static void main(String[] args){
        ListNode head= ListNode.stringToListNode("[1,2,3,4,5,6]");
        ListNode.prettyPrintLinkedList(reverseKGroup(head,3));
    }
}
