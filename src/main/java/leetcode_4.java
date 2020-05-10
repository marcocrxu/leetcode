
public class leetcode_4 {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result=0;
		int len1=nums1.length;
		int len2=nums2.length;
		int[] nums3=new int[len1+len2];
		/*先合并数组*/
		int i=0,j=0,k=0;
		while(i<len1&&j<len2) {
			if(nums1[i]<nums2[j]) {
				nums3[k++]=nums1[i++];
			}
			else {
				nums3[k++]=nums2[j++];
			}
		}
		if(i<len1) {
			while(i<len1) {
				nums3[k++]=nums1[i++];
			}
		}
		else {
			while(j<len2) {
				nums3[k++]=nums2[j++];
			}
		}
		/*获取中位数*/
		if((len1+len2)%2==1) {
			result=nums3[(len1+len2-1)/2];
		}
		else {
			result=(nums3[(len1+len2)/2]+nums3[(len1+len2)/2-1])/2.0;
		}
		return result;
    }
	
	public static void main(String arg[]) {
		int[] nums1= {1,2};
		int[] nums2= {3,4};
		double result=findMedianSortedArrays(nums1,nums2);
		System.out.println(result);
	}
}
