import java.util.*;

public class leetcode_17 {
	private static List<List<String>> dict= Arrays.asList(
			Arrays.asList("a", "b", "c"),
			Arrays.asList("d", "e", "f"),
			Arrays.asList("g", "h", "i"),
			Arrays.asList("j", "k", "l"),
			Arrays.asList("m", "n", "o"),
			Arrays.asList("p", "q", "r","s"),
			Arrays.asList("t", "u", "v"),
			Arrays.asList("w", "x", "y","z")
			);
	public static List<String> merge(List<String> l1,List<String> l2){
		List<String> res= new ArrayList<String>(Collections.emptyList());
		for(String s1: l1){
			for(String s2:l2){
				res.add(s1+s2);
			}
		}
		return res;
	}

	public static List<String> letterCombinations(String digits) {
		if(digits.length()==1) {
			return dict.get(digits.charAt(0)-'2');
		}
		else if(digits.length()==0){
			return new ArrayList<String>(Collections.emptyList());
		}
		else{
			StringBuilder sb=new StringBuilder(digits);
			sb.delete(0,1);
			return merge(dict.get(digits.charAt(0)-'2'),letterCombinations(sb.toString()));
		}
    }

    public static void main(String[] args){
		System.out.println(letterCombinations(""));
	}
}
