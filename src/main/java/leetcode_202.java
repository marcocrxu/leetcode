public class leetcode_202 {
    public static boolean isHappy(int n) {
        int temp=0;
        while(n!=0){
            temp+=(n%10)*(n%10);
            n=n/10;
        }
        if(temp==1)
            return true;
        if(temp<10&&temp!=7)
            return false;
        return isHappy(temp);
    }

    public static void main(String[] args) {
        System.out.println(isHappy(123));
    }
}
