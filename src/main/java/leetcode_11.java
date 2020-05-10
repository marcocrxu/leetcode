
public class leetcode_11 {
	public static int maxArea(int[] height) {
		int len=height.length;
		int max=0;
		max=(Math.min(height[0], height[len - 1]))*(len-1);
		int i=0;int j=len-1;
		while(i<j) {
			if(height[i]<height[j]) {
				i++;
				int temp=(Math.min(height[i], height[j]))*(j-i);
				if(temp>max){
					max=temp;
				}
			}
			else {
				j--;
				int temp=(Math.min(height[i], height[j]))*(j-i);
				if(temp>max){
					max=temp;
				}
			}
		}
		return max;
    }
	
	public static void main(String[] args) {
		int[] height= {1,8,6,2,5,4,8,3,7};
		int result=maxArea(height);
		System.out.println(result);
	}
}
