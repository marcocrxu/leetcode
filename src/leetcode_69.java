public class leetcode_69 {
    public int mySqrt(int x) {
        if(x<=1)
            return x;
        int end=x/2;
        int start=1;
        while(start<end){
            int mid=(start+end)/2;
            if((long)mid*mid>(long)x)
                end=mid-1;
            else if((long)mid*mid==(long)x)
                return mid;
            else
                start=mid+1;
        }
        return (long)end*end<=(long)x?end:end-1;
    }
}
