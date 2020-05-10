public class leetcode_5405 {
    static int[][] dp;
    public static int countTriplets(int[] arr) {
        if(arr.length<2)
            return 0;
        dp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            dp[i][i]=arr[i];
            for(int j=i+1;j<arr.length;j++){
                dp[i][j]=dp[i][j-1]^arr[j];
            }
        }
        int count=0;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++){
                count+=count(arr,i,j);
            }
        }
        return count;
    }

    public static int count(int[] arr,int start,int end){
        int cnt=0;
        for(int k=start+1;k<=end;k++){
            if(dp[start][k-1]==dp[k][end])
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2,3,1,6,7}));
    }
}
