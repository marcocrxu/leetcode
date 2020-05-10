import java.util.*;

public class hundredGame {
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal)
            return true;
        if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal)
            return false;
        int[] dp=new int[1<<maxChoosableInteger];
        Arrays.fill(dp,0);
        return dfs((1<<maxChoosableInteger)-1,0,maxChoosableInteger,desiredTotal,dp);
    }

    public static boolean dfs(int bit,int count,int maxChoosableInteger,int desiredTotal,int[] dp){
        if(dp[bit]!=0){
            //0:未确定 1:OK 2:false
            return dp[bit]==1;
        }
        else{
            //如果还没有计算过
            dp[bit]=2;
            for(int i=maxChoosableInteger;i>0;i--){
                if(((1<<(i-1))&bit)!=0){
                    if((count+i>=desiredTotal)||(!dfs(bit^(1<<(i-1)),count+i,maxChoosableInteger,desiredTotal,dp))){
                        dp[bit]=1;
                        break;
                    }
                }
            }
            return dp[bit]==1;
        }
    }

    public static void main(String[] args){
        System.out.println(canIWin(6,16));
    }

}
