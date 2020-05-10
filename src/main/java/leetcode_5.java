
public class leetcode_5 {
	//动态规划
	public static String longestPalindrome(String s) {
		String result="";
		int len=s.length();
		int start=0,end=len-1;
		int maxlen=-1;
		boolean[][] a=new boolean[len][len];
		//初始化	O(n^2)
		//长度为1的回文序列
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(i==j) {
					a[i][j]=true;
					if((j-i)>maxlen) {
						maxlen=j-i;
						start=i;
						end=j;
					}
				}
				else {
					a[i][j]=false;
				}
			}
		}
		//长度为2的回文序列
		for(int i=0;i<len-1;i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				a[i][i+1]=true;
				if(1>maxlen) {
					maxlen=1;
					start=i;
					end=i+1;
				}
			}
			else {
				a[i][i+1]=false;
			}
		}
		for(int j=2;j<len;j++) {
			for(int i=0;i<len-j;i++) {
				if(a[i+1][i+j-1]==true&&s.charAt(i)==s.charAt(i+j)) {
					a[i][i+j]=true;
					if((j)>maxlen) {
						maxlen=j;
						start=i;
						end=i+j;
					}
				}
				else {
					a[i][i+j]=false;
				}
			}
		}
		result=s.substring(start,end+1);
		return result;
    }
	
	public static void main(String[] arg) {
		String s="abcba";
		String result=longestPalindrome(s);
		System.out.println(result);
	}
}
