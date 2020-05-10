public class takeCoin {
    public int minCount(int[] coins) {
        int count=0;
        for(int i=0;i<coins.length;i++){
            count+=(coins[i]+1)/2;
        }
        return count;
    }
}
