
public class leetcode_7 {
	public static int max=2147483647;
	public static int reverse(int x) {
		boolean Big2Zero=x>0;
		long result=0;
		x=Math.abs(x);
		while(x>0) {
			int num=x%10;
			result=num+result*10;
			x=x/10;
		}
		if(result>max)
			result=0;
			
		result=Big2Zero?result:-result;
		return (int)result;
    }
	
	public static void main(String[] args) {
		System.out.println(reverse(-1563847412));
	}
}
