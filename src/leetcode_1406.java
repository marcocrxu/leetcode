import java.util.Arrays;

public class leetcode_1406 {
    public static String getScore(int x){
        if(x>0)
            return "Alice";
        else if(x==0)
            return "Tie";
        else
            return "Bob";
    }

    public static String stoneGameIII(int[] stoneValue) {
        if(stoneValue.length==1) {
            return getScore(stoneValue[0]);
        }
        int []dp = new int[stoneValue.length];
        Arrays.fill(dp,-9999);
        /*初始化边界*/
        dp[stoneValue.length-1]=stoneValue[stoneValue.length-1];
        int last_sum=stoneValue[stoneValue.length-1];
        for(int i=stoneValue.length-2;i>stoneValue.length-4;i--){
            if(i<0)
                return getScore(dp[0]);
            last_sum+=stoneValue[i];
            /*计算dp值*/
            int sum=0;
            for(int j=i+1;j<i+4;j++){
                if(j>=stoneValue.length)
                    break;
                sum+=stoneValue[j-1];
                if(dp[i]<sum-dp[j]){
                    dp[i]=sum-dp[j];
                }
            }
            dp[i]= Math.max(dp[i], last_sum);
        }
        for(int i=stoneValue.length-4;i>=0;i--){
            int sum=0;
            for(int j=i+1;j<i+4;j++){
                sum+=stoneValue[j-1];
                if(dp[i]<sum-dp[j]){
                    dp[i]=sum-dp[j];
                }
            }
        }
        return getScore(dp[0]);
    }
    public static void main(String[] args){
        System.out.println(stoneGameIII(new int[]{1,2,3,7}));
    }
}