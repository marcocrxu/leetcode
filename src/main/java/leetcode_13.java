
public class leetcode_13 {
	private static int find(char c) {
		if(c=='I') 
			return 1;
		if(c=='V')
			return 5;
		if(c=='X') 
			return 10;
		if(c=='L')
			return 50;
		if(c=='C') 
			return 100;
		if(c=='D')
			return 500;
		if(c=='M') 
			return 1000;
		return -1;
	}
	
	public static int romanToInt(String s) {
		int result=0;
		for(int i=0;i<s.length();i++) {
			if(i+1<s.length()) {
				if(find(s.charAt(i))<find(s.charAt(i+1))) {
					result-=find(s.charAt(i));
					continue;
				}
			}
			result+=find(s.charAt(i));
		}
		return result;
    }
	
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}
