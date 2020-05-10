public class leetcode_26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) {
                //ÐèÒªÉ¾³ý
                nums[j++]=nums[i];
            }
        }
        return j;
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    public static void main(String[] args){
        int[] test=stringToIntegerArray("[1,1,2]");
        System.out.println(removeDuplicates(test));
        System.out.println(integerArrayToString(test));
    }
}
