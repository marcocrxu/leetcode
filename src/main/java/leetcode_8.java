
public class leetcode_8 {
	public static int myAtoi(String str) {
		long result=0;
		boolean findfirst=false;
		boolean big2zero=true;
		for(int i=0;i<str.length();i++) {
			/*��Ҫ�����Ĳ���*/
			boolean temp=!findfirst&&(str.charAt(i)<'0'||str.charAt(i)>'9')&&str.charAt(i)!='+'&&str.charAt(i)!='-';
			if(temp&&str.charAt(i)!=' ') {
				return 0;
			}
			if(temp) {
				continue;
			}
			
			/*�Ƿ�����*/
			if(!findfirst) {
				if(str.charAt(i)=='-') {
					big2zero=false;
					findfirst=true;
					continue;
				}
				if(str.charAt(i)=='+') {
					findfirst=true;
					continue;
				}
			}
			findfirst=true;
			/*��������*/
			if(str.charAt(i)<'0'||str.charAt(i)>'9') {
				/*�������һ������*/
				break;
			}
			else {
				result=result*10+str.charAt(i)-'0';
				if(result>2147483647)
					return big2zero?2147483647:-2147483648;
			}
		}
		return big2zero?(int)result:(int)(-result);
    }
	public static void main(String[] args) {
		System.out.println(myAtoi("   9223372036854775808"));
	}
}
