public class leetcode_50 {
    public static double myPow(double x, int n) {
        if(n<0){
            if(n==Integer.MIN_VALUE){
                return myPow(1/(x*x),-(n/2));
            }
            else
                return myPow(1/x,-n);
        }
        if(n==0)
            return 1.0;
        long count=1;
        int nowMultipleAdd=1;
        double nowMultipleVal=x;
        double res=x;
        while(count<n){
            if(nowMultipleAdd+count<=n){
                count+=nowMultipleAdd;
                res*=nowMultipleVal;
                nowMultipleVal*=nowMultipleVal;
                nowMultipleAdd*=2;
            }
            else{
                nowMultipleAdd=1;
                nowMultipleVal=x;
                res*=nowMultipleVal;
                count+=nowMultipleAdd;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(myPow(1.0,-2147483648));
    }
}
