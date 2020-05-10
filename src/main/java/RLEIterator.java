import java.util.*;

public class RLEIterator {
    List<Integer> num;
    public RLEIterator(int[] A) {
        num=new ArrayList<Integer>(A.length);
        for(int i=0;i<A.length;i+=2){
            if(A[i]==0)
                continue;
            num.add(A[i]);
            num.add(A[i+1]);
        }
    }

    public int next(int n) {
        int count=0;
        while(n>0){
            if(num.size()!=0) {
                if (n > num.get(0)) {
                    n-=num.get(0);
                    num.remove(0);
                    num.remove(0);
                }
                else {
                    num.set(0,num.get(0)-n);
                    count=num.get(1);
                    if(num.get(0)==0) {
                        num.remove(0);
                        num.remove(0);
                    }
                    return count;
                }
            }
            else{
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args){
        RLEIterator obj = new RLEIterator(ListNode.stringToIntegerArray("[3,8,0,9,2,5]"));
        System.out.println(obj.next(2));
        System.out.println(obj.next(1));
        System.out.println(obj.next(1));
        System.out.println(obj.next(2));
    }
}
