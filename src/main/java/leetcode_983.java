import java.util.*;
public class leetcode_983 {
    static public int min(int x,int y,int z) {
        if(x<y)
            return Math.min(x,z);
        else
            return Math.min(y,z);
    }
    static int[] minCost;
    public static int mincostTickets(int[] days, int[] costs) {
        minCost=new int[days.length];
        Arrays.fill(minCost,-1);
        return minCostTickets(days,costs,days.length);
    }

    public static int minCostTickets(int[] days,int[] costs,int k){
        if(k==0)
            return 0;
        if(minCost[k-1]!=-1)
            return minCost[k-1];
        int _7days=k-1;
        int _30days=k-1;
        int _1day=k-1;
        for(int i=k-1;i>=0;i--){
            if(days[i]>days[k-1]-7)
                _7days=i;
            if(days[i]>days[k-1]-30)
                _30days=i;
        }
        int min=min(minCostTickets(days,costs,_1day)+costs[0],minCostTickets(days,costs,_7days)+costs[1],minCostTickets(days,costs,_30days)+costs[2]);
        minCost[k-1]=min;
        return min;
    }

    public static void main(String[] args) {
        System.out.print(mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31},new int[]{2,7,15}));
    }
}
