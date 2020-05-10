import java.util.*;
public class CircleDetect {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        Map<ListNode,Integer> map=new HashMap<>();
        ListNode p=head;
        int count=0;
        while(p.next!=null){
            if(map.containsKey(p)){
                return p;
            }
            else{
                map.put(p,count);
                count++;
                p=p.next;
            }
        }
        return null;
    }
}
