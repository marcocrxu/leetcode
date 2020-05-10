import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_16 {
	public static int threeSumClosest(int[] nums, int target) {
		int result=0;
		int delta=Integer.MAX_VALUE/2-target-1;
		if(nums==null)
			return result;
		if(nums.length<3)
			return result;
		Arrays.parallelSort(nums);
		for(int i=0;i<nums.length-2;i++) {
			if(nums[i]>target+delta) {
				break;
			}
			if(i>0) {
				if(nums[i]==nums[i-1])
					continue;
			}
			/*在后面找出两个数和为-nums[i]的*/
			int l=i+1;int r=nums.length-1;
			while(l<r) {
				/*如果相等*/
				if(Math.abs(nums[i]+nums[l]+nums[r]-target)<delta) {
					result=nums[l]+nums[r]+nums[i];
					delta=Math.abs(target-result);
					if(nums[l]+nums[r]+nums[i]<target) {
						l++;
						while(nums[l]==nums[l-1]) {
							l++;
							if(l>nums.length-1)
								break;
						}
						continue;
					}
					else if(nums[l]+nums[r]+nums[i]==target) {
						return target;
					}
					else {
						r--;
						while(nums[r]==nums[r+1]) {
							r--;
							if(r<0)
								break;
						}
					}
				}
				else if(nums[l]+nums[r]<target-delta-nums[i]) {
					l++;
					while(nums[l]==nums[l-1]) {
						l++;
						if(l>nums.length-1)
							break;
					}
				}
				else if(nums[l]+nums[r]==target-delta-nums[i]) {
					if(l+1>nums.length)
						r--;
					else if(r-1<0)
						l++;
					else {
						if(Math.abs(nums[l+1]+nums[r]+nums[i]-target)<Math.abs(nums[l]+nums[r-1]+nums[i]-target))
							l++;
						else
							r--;
					}
				}
				else {
					r--;
					while(nums[r]==nums[r+1]) {
						r--;
						if(r<0)
							break;
					}
				}
			}
		}	
		return result;
    }
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33},0));
	}
}
