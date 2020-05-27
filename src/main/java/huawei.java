public class huawei {
    public static String MaxStr(String str){
        int n=str.length();
        int[][] dp=new int[n][n];
        //单个字符都是回文子串
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        //判断两个自符长度的回文串
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=str.charAt(i)==str.charAt(i+1)?1:0;
        }
        //先初始化一个肯定已知的回文串
        int max=1;
        int best_start=0;
        int best_end=1;
        //如果dp[i][j]是回文子串，加上str[i-1]和str[j+1]相等，那dp[i-1][j+1]也是一个回文子串
        for(int i=2;i<n-1;i++){
            for(int j=0;j<n-i;j++){
                //dp[j][i]
                if(dp[j+1][j+i-1]==1&&str.charAt(j)==str.charAt(j+i)){
                    dp[j][i]=1;
                    //如果出现了一个比max还要长的子串
                    if(i>max){
                        max=i;
                        best_start=j;
                        best_end=j+i+1;
                    }
                }
            }
        }
        return str.substring(best_start,best_end);
    }


    public static void main(String[] args) {
        System.out.println(MaxStr("abac"));
    }
}
