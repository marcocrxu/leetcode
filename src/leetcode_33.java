public class leetcode_33 {
    public static int search(int[] nums, int target) {
        //O(log n)
        if(nums.length==0)
            return -1;
        return search(nums,0,nums.length,target);
    }

    public static int search(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (start == end - 1) {
            if (nums[start] == target)
                return start;
            else
                return -1;
        }
        if (start < end - 1) {
            if (nums[mid] == target)
                return mid;
            if (nums[mid - 1] >= nums[start]) {
                if (target >= nums[start] && nums[mid - 1] >= target) {
                    return binarySearch(nums, start, mid, target);
                } else {
                    return search(nums, mid + 1, end, target);
                }
            }else{
                if(target<=nums[end-1]&&target>=nums[mid]){
                    return binarySearch(nums,mid+1,end,target);
                }
                else
                    return search(nums,0,mid,target);
            }
        }

        else{
            return -1;
        }
    }

    public static int binarySearch(int[] nums, int start, int end, int target){
        if(start>end-1)
            return -1;
        if(start==end-1) {
            if (nums[start] == target)
                return start;
            else
                return -1;
        }
        else {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                return binarySearch(nums, start, mid, target);
            } else if (nums[mid] == target)
                return mid;
            else
                return binarySearch(nums, mid + 1, end, target);
        }
    }

    public static void main(String[] args){
        System.out.println(search(ListNode.stringToIntegerArray("[282,283,290,295,296,297,298,1,7,8,9,11,12,15,17,21,27,28,38,43,45,50,51,52,55,59,61,66,75,82,84,85,86,87,96,101,103,105,114,117,119,120,122,123,132,138,140,145,151,152,156,157,159,163,164,165,170,172,184,187,188,189,190,193,201,204,205,206,208,215,216,217,225,232,234,241,244,248,249,252,261,262,264,265,268,271,272,279,280]"),102));
    }
}
