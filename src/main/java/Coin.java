public class Coin {
    public static int odd(int a,int k){
        if(a<0)
            return 0;
        long temp=k*(k+1);
        long temp2=(k+1);
        long temp3=((long)temp*(long)(2*k+1)*100);
        long res=((temp2*a*a+10*a*temp+temp3/6+4*temp2*a+20*temp+3*temp2)/4)%1000000007;
        return (int)res;
    }

    public static int even(int b,int l){
        if(b<0)
            return 0;
        long temp=l*(l+1);
        long temp2=(l+1);
        long temp3=((long)temp*(long)(2*l+1)*100);
        long res=((temp2*b*b+10*b*temp+temp3/6+4*temp2*b+20*temp+4*temp2)/4)%1000000007;
        return (int)res;
    }


    public static int waysToChange(int n) {
        int x=n/5;
        int y=x%10;
        int z=x/10;
        if(x%2!=0){
            int a=x%10;
            int k=x/10;
            int b=x-5;
            b=b%10;
            int l=(x-5)/10;
            return (odd(a,k)+even(b,l))%1000000007;
        }
        else{
            int b=x%10;
            int l=x/10;
            int a=(x-5)%10;
            int k=(x-5)/10;
            return (odd(a,k)+even(b,l))%1000000007;
        }
    }

    public static void main(String[] args) {
        System.out.println(waysToChange(20000));

    }
}
