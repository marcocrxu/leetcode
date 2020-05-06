public class leetcode_62 {
    public static long fraction(int n){
        if(n==1||n==0)
            return 1;
        return n*fraction(n-1);
    }

    public static int uniquePaths(int m, int n) {
        if(m==1||n==1)
            return 1;
        long res=1;
        if(m<n){
            int temp=m;
            m=n;
            n=temp;
        }
        for(int i=m;i<=m+n-2;i++){
            res*=i;
        }
        for(int i=2;i<n;i++){
            res/=i;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(100,100));
    }
}
