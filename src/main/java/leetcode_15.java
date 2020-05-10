import java.util.*;

public class leetcode_15 {
	public static int search(int[] nums,int x,int start,int end) {
		if(start<end) {
			int mid=(start+end)/2;
			if(nums[mid]==x)
				return mid;
			else if(nums[mid]>x) {
				return search(nums,x,start,mid-1);
			}
			else {
				return search(nums,x,mid+1,end);
			}
		}
		else {
			return -1;
		}
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		//Arrays.sort(nums);
		List<List<Integer>> result=new ArrayList();
		if(nums==null)
			return result;
		if(nums.length<3)
			return result;
		Arrays.parallelSort(nums);
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], i);
		}
		for(int i=0;i<nums.length-2;i++) {
			if(nums[i]>0) {
				break;
			}
			if(i>0) {
				if(nums[i]==nums[i-1])
					continue;
			}
			/*在后面找出两个数和为-nums[i]的*/
			/*
			for(int j=i+1;j<nums.length;j++) {
				//和前面一样跳过
				if(j-i>1) {
					if(nums[j]==nums[j-1]) {
						continue;
					}
				}
				//不和前面一样
				if(map.containsKey(-nums[i]-nums[j])&&map.get(-nums[i]-nums[j])>j) {
					result.add(Arrays.asList(new Integer[]{nums[i],nums[j],-nums[i]-nums[j]}));
				}
			}
			*/
			int l=i+1;int r=nums.length-1;
			while(l<r) {
				/*如果相等*/
				if(nums[l]+nums[r]==-nums[i]) {
					result.add(Arrays.asList(nums[i],nums[l],nums[r]));
					l++;
					while(nums[l]==nums[l-1]) {
						l++;
						if(l>nums.length-1)
							break;
					}
					r--;
					while(nums[r]==nums[r+1]) {
						r--;
						if(r<0)
							break;
					}
				}
				else if(nums[l]+nums[r]<-nums[i]) {
					l++;
					while(nums[l]==nums[l-1]) {
						l++;
						if(l>nums.length-1)
							break;
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
		System.out.println(threeSum(new int[] {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33}));
	}
	
}
