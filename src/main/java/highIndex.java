import java.util.*;

public class highIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max=0;
        for(int i=citations.length-1;i>=0;i--){
            if(i>0&&citations[i-1]==citations[i])
                continue;
            int temp=Math.min(citations.length-i,citations[i]);
            if(temp>max)
                max=temp;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(ListNode.stringToIntegerArray("[100]")));
    }
}
