import java.util.*;

public class leetcode_56 {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return new int[][]{};
        int[] firstNumber=new int[intervals.length];

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        List<Integer[]> listRes=merge(intervals,intervals.length,intervals.length-1);
        int[][] res=new int[listRes.size()][2];
        for(int i=0;i<listRes.size();i++){
            res[i][0]=listRes.get(i)[0];
            res[i][1]=listRes.get(i)[1];
        }
        return res;
    }

    public static List<Integer[]> merge(int[][] intervals,int n,int k){
        if(k==0)
            return new ArrayList<Integer[]>(Collections.singleton(new Integer[]{intervals[0][0], intervals[0][1]}));
        else {
            List<Integer[]> pre = merge(intervals, n, k - 1);
            if (pre.get(pre.size()-1)[1] >= intervals[k][0]) {
                pre.set(pre.size()-1,new Integer[]{pre.get(pre.size()-1)[0],Math.max(pre.get(pre.size()-1)[1], intervals[k][1])});
            } else {
                pre.add(new Integer[]{intervals[k][0], intervals[k][1]});
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        int[][] res=merge(new int[][]{});
        System.out.print(0);
    }
}
