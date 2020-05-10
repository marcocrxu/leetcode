public class leetcode_72 {
    public static int minDistance(String word1, String word2) {
        if(word1.length()==0)
            return word2.length();
        if(word2.length()==0)
            return word1.length();
        //dp
        int[][] dp=new int[word1.length()][word2.length()];
        dp[0][0]=word1.charAt(0)==word2.charAt(0)?0:1;
        for(int i=1;i<word2.length();i++){
            if(word2.charAt(i)==word1.charAt(0)){
                dp[0][i]=dp[0][i-1];
                if(dp[0][i]<i){
                    dp[0][i]++;
                }
            }
            else
                dp[0][i]=dp[0][i-1]+1;
        }
        for(int i=1;i<word1.length();i++){
            if(word1.charAt(i)==word2.charAt(0)){
                dp[i][0]=dp[i-1][0];
                if(dp[i][0]<i){
                    dp[i][0]++;
                }
            }
            else
                dp[i][0]=dp[i-1][0]+1;
        }
        for(int i=1;i<word1.length();i++){
            for(int j=1;j<word2.length();j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    int min = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    min = Math.min(min, dp[i - 1][j - 1] + 1);
                    dp[i][j] = min;
                }
            }
        }
        for(int i=0;i<word1.length();i++){
            System.out.print(dp[i][0]);
            System.out.print(" ");
        }
        System.out.println();
        return dp[word1.length()-1][word2.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically"));
    }
}
