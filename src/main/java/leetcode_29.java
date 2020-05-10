public class leetcode_29 {
    public static int getHigh(int x){
        for(int i=31;i>=0;i--){
            if(((1<<i)&x)!=0){
                return i+1;
            }
        }
        return 0;
    }

    public static int getHigh(long x){
        for(int i=31;i>=0;i--){
            if(((1<<i)&x)!=0){
                return i+1;
            }
        }
        return 0;
    }


    public static int divide(int _dividend, int _divisor) {
        if(_dividend==0)
            return 0;
        if(_divisor==-1){
            if(_dividend==Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -_dividend;
        }
        if(_divisor==1)
            return _dividend;

        boolean minus=(_dividend<0)^(_divisor<0);
        long dividend=_dividend;long divisor=_divisor;
        dividend=Math.abs(dividend);
        divisor= Math.abs(divisor);
        if(dividend<divisor)
            return 0;
        int len_dividend=getHigh(dividend);int len_divisor=getHigh(divisor);

        //int logAns = (int)Math.log(dividend) - (int)Math.log(divisor);
        divisor=divisor<<(len_dividend-len_divisor);
        long res=0;
        for(int i=len_dividend-len_divisor;i>=0;i--){
            res=res<<1;
            if(!minus && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(dividend-divisor>=0){
                res+=1;
                dividend-=divisor;
            }
            divisor=divisor>>1;
        }
        return (int)(minus?-res:res);
    }

    public static void main(String[] args){
        System.out.println(divide(7,-3));
    }
}
