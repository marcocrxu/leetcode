public class leetcode_680 {
    public static boolean validPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        return validPalindrome(s,start,end,false);
    }

    public static boolean validPalindrome(String s,int start,int end,boolean skip){
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else {
                if(!skip){
                    if(validPalindrome(s,start+1,end,true)||validPalindrome(s,start,end-1,true))
                        return true;
                    else
                        return false;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome(""));
    }
}
