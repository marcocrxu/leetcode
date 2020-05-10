/**************************************************************
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *************************************************************/
public class leetcode_3{
	/*
	public static int lengthOfLongestSubstring(String s) {
		int result=0;
		//爆搜
		int len=s.length();
		int maxlen=0;
		for(int i=0;i<len;i++) {
			//用一个hash来判断
			int [] hashmap=new int[128];
			//初始化哈希表
			for(int j=0;j<128;j++) {
				hashmap[j]=0;
			}
			int count=1;
			hashmap[s.charAt(i)]=1;
			for(int j=i+1;j<len;j++) {
				//判断这个字符是不是已经出现过
				if(hashmap[s.charAt(j)]==1)
					break;
				else
					hashmap[s.charAt(j)]=1;
				count++;
			}
			if(count>maxlen)
				maxlen=count;
		}
			
		result=maxlen;
		
		return result;
    }
	 */
	public static int lengthOfLongestSubstring(String s) {
		int result=0;
		//前后的滑动指针
		int front=0;
		int last=0;
		int len=s.length();
		boolean [] hashmap=new boolean[128];
		int maxlen=0;
		//初始化hashmap
		for(int i=0;i<128;i++) {
			hashmap[i]=false;
		}
			
		while(last<len) {			
			if(hashmap[s.charAt(last)]==false) {
				//首先将下一个包括进来
				hashmap[s.charAt(last)]=true;
				last++;
				maxlen++;
			}
			else {
				//首先需要把这个maxlen记录下来
				if(maxlen>result)
					result=maxlen;
				//如果这个字符已经有了，那就给front++
				while(s.charAt(front++)!=s.charAt(last)) {
					//这里需要有一个将原来的字符删去的部分
					hashmap[s.charAt(front-1)]=false;
					//maxlen--;
					//front++;
				}
				hashmap[s.charAt(front-1)]=false;
				maxlen=last-front;
			}
		}
		if(maxlen>result)
			result=maxlen;
		return result;
	}
	
	public static void main(String arg[]) {
		String s=" ";
		int maxlen=lengthOfLongestSubstring(s);
		System.out.println(maxlen);
		
	}
}


