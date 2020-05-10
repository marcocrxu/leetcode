//easy
public class leetcode_14 {
	public static String longestCommonPrefix(String[] strs) {
		StringBuilder s=new StringBuilder();
		if(strs.length==0) {
			return s.toString();
		}
		if(strs.length == 1){
            return strs[0];
        }
		for(int i=0;i<strs[0].length();i++) {
			char temp=strs[0].charAt(i);
			for(int j=1;j<strs.length;j++) {
				if(i>=strs[j].length()) {
					return s.toString();
				}
				if(strs[j].charAt(i)!=temp) {
					return s.toString();
				}
			}
			s.append(temp);
		}
		return s.toString();
    }
	public static void main(String[] args) {
		String[] strs= {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
	}
}
