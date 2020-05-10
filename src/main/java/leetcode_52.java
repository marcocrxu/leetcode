import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_52 {
    int count=0;
    static boolean[] used_vertical;
    static boolean[] used_leftUpToRightBottom;
    static boolean[] used_LeftBottomToRightUp;
    public int totalNQueens(int n) {
        //用来记录这一列有没有被用过
        used_vertical=new boolean[n];
        used_leftUpToRightBottom=new boolean[2*n-1];
        used_LeftBottomToRightUp=new boolean[2*n-1];
        Arrays.fill(used_vertical,false);
        Arrays.fill(used_leftUpToRightBottom,false);
        Arrays.fill(used_LeftBottomToRightUp,false);
        dfs(n,0);
        return count;

    }

    public void dfs(int n,int k){
        if(k>=n) {
            count++;
            return;
        }
        //boolean findRes=false;
        for(int i=0;i<n;i++){
            //如果这一列没有被用过
            if(!used_vertical[i]&&!used_LeftBottomToRightUp[i+k]&&!used_leftUpToRightBottom[k-i+n-1]) {
                used_vertical[i] = true;
                used_leftUpToRightBottom[k - i+n-1] = true;
                used_LeftBottomToRightUp[i + k] = true;
                dfs(n, k + 1);
                used_vertical[i] = false;
                used_leftUpToRightBottom[k - i+n-1] = false;
                used_LeftBottomToRightUp[i + k] = false;
                //findRes=true;
            }
        }
    }
}
