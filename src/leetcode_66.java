public class leetcode_66 {
    public static int[] plusOne(int[] digits) {
        int c=1;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9&&c==1){
               c=1;
               digits[i]=0;
            }else{
                digits[i]=digits[i]+1;
                c=0;
                break;
            }
        }
        if(c==1){
            int[] res=new int[digits.length+1];
            res[0]=1;
            for(int i=1;i<digits.length+1;i++)
                res[i]=0;
            return res;
        }
        else{
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] res=plusOne(new int[]{9});
        System.out.println(0);
    }
}
