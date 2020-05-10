import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode_51 {
    static List<List<String>> res;
    static boolean[] used_vertical;
    static boolean[] used_leftUpToRightBottom;
    static boolean[] used_LeftBottomToRightUp;
    static StringBuilder sb;
    public static List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        List<String> temp_res=new ArrayList<>();
        sb=new StringBuilder();
        for(int j=0;j<n;j++){
            sb.append(".");
        }
        for(int i=0;i<n;i++){
            temp_res.add(sb.toString());
        }
        //用来记录这一列有没有被用过
        used_vertical=new boolean[n];
        used_leftUpToRightBottom=new boolean[2*n-1];
        used_LeftBottomToRightUp=new boolean[2*n-1];
        Arrays.fill(used_vertical,false);
        Arrays.fill(used_leftUpToRightBottom,false);
        Arrays.fill(used_LeftBottomToRightUp,false);
        dfs(temp_res,n,0);
        return res;
    }

    /*
    * n:总行数
    * k:当前第几行
    * */
    public static void dfs(List<String> tempResult,int n,int k){
        if(k>=n) {
            res.add(new ArrayList<>(tempResult));
            return;
        }
        //boolean findRes=false;
        for(int i=0;i<n;i++){
            //如果这一列没有被用过
            if(!used_vertical[i]&&!used_LeftBottomToRightUp[i+k]&&!used_leftUpToRightBottom[k-i+n-1]) {
                used_vertical[i] = true;
                used_leftUpToRightBottom[k - i+n-1] = true;
                used_LeftBottomToRightUp[i + k] = true;
                sb.setCharAt(i, 'Q');
                tempResult.set(k, sb.toString());
                sb.setCharAt(i, '.');
                dfs(tempResult, n, k + 1);
                tempResult.set(k, sb.toString());
                used_vertical[i] = false;
                used_leftUpToRightBottom[k - i+n-1] = false;
                used_LeftBottomToRightUp[i + k] = false;
                //findRes=true;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> res=solveNQueens(4);
        System.out.print(0);
    }
}
