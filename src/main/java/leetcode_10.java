
public class leetcode_10 {
	public static boolean judge(char a,char b) {
		return a==b||a=='.';
	}
	
	public static boolean isMatch(String s, String p) {
		if(p.equals("")) {
			return s.equals("");
		}
		
		int x=p.length();
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='*')
				x--;
		}
		/*存储字母*/
		char[] a=new char[x];
		/*存储是否含* */
		boolean[] b=new boolean[x];
		int i=0;int j=0;
		for(i=0;i<x;i++) {
			a[i]=p.charAt(j++);
			if(p.length()>j) {
				if(p.charAt(j)=='*') { 
					b[i]=true;
					j++;
				}
				else {
					b[i]=false;
				}
			}
			else
				b[i]=false;
		}
		if(s.equals("")) {
			for(i=0;i<x;i++) {
				if(!b[i])
					return false;
			}
			return true;
		}
		int y=s.length();
		boolean[][] sheet=new boolean[x][y];
		/*初始化动态规化数组*/
		/*sheet[0][0]=0需要第一个相等*/
		sheet[0][0]=judge(a[0],s.charAt(0));
		boolean c=true;
		for(i=1;i<x;i++) {
			c=c&&b[i-1];
			if((sheet[i-1][0]&&b[i])||(c&&judge(a[i],s.charAt(0)))) {
				sheet[i][0]=true;
			}
			else {
				sheet[i][0]=false;
			}
		}
		for(i=1;i<y;i++) {
			//sheet的第一行为true的必要条件是sheet[0][i-1]为true且字符相等且有*
			sheet[0][i]=sheet[0][i-1]&&judge(a[0],s.charAt(i))&&b[0];
		}
		/*正式开始循环*/
		for(i=1;i<x;i++) {
			for(j=1;j<y;j++) {
				boolean temp=judge(a[i],s.charAt(j));
				if(temp&&sheet[i][j-1]&&b[i]) {
					sheet[i][j]=true;
					continue;
				}
				if(temp&&sheet[i-1][j-1]) {
					sheet[i][j]=true;
					continue;
				}
				if(b[i]&&sheet[i-1][j]) {
					sheet[i][j]=true;
					continue;
				}
				sheet[i][j]=false;
			}
		}
		return sheet[x-1][y-1];
    }
	public static void main(String[] args) {
		System.out.println(isMatch("","."));
	}
}
