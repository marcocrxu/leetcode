public class leetcode_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0]=(obstacleGrid[0][0]==1)?0:1;
        for(int i=1;i<obstacleGrid.length;i++){
            dp[i][0]=(dp[i-1][0]==1&&obstacleGrid[i][0]!=1)?1:0;
        }
        for(int i=1;i<obstacleGrid[0].length;i++){
            dp[0][i]=(dp[0][i-1]==1&&obstacleGrid[0][i]!=1)?1:0;
        }
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++) {
                dp[i][j]=0;
                /*如果是没有障碍物的*/
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{new int[]{1}}));
    }
}
