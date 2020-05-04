public class leetcode_1411 {
    static int MAX=1000000007;
    public static int numOfWays(int n) {
        long a=6;long b=6;
        for(int i=1;i<n;i++){
            long temp_a=(a*3+b*2)%MAX;
            long temp_b=(a*2+b*2)%MAX;
            a=temp_a;
            b=temp_b;
        }
        return (int)((a+b)%MAX);
    }

}
