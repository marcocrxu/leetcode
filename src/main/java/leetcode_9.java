
public class leetcode_9 {
	public static int reverse(int x) {
		boolean Big2Zero=x>0;
		int result=0;
		x=Math.abs(x);
		while(x>0) {
			int num=x%10;
			result=num+result*10;
			x=x/10;
		}	
		result=Big2Zero?result:-result;
		return result;
    }
	public static boolean isPalindrome(int x) {
		return reverse(x)==Math.abs(x);
    }
}
