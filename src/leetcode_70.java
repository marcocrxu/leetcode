import java.util.Arrays;

public class leetcode_70 {
    int[] res;
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        res=new int[n];
        Arrays.fill(res,-1);
        res[0]=1;
        res[1]=2;
        return climb(n);
    }

    public int climb(int n){
        if(res[n-1]!=-1)
            return res[n-1];
        else{
            int temp=climb(n-1)+climb(n-2);
            res[n-1]=temp;
            return temp;
        }
    }
}
