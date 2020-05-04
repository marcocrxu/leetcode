import java.awt.desktop.SystemSleepEvent;

public class leetcode_42 {
    public static int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        //寻找每一个极大值点和极小值点
        int pre,width;
        int count=0;
        boolean find=true;
        while(find) {
            find=false;
            pre=height[0];
            width=1;
            for (int i = 1; i < height.length - 1; i++) {
                if (height[i] < height[i + 1] && height[i] < pre) {
                    int addHeight = Math.min(height[i + 1] - height[i], pre - height[i]);
                    count += width * addHeight;
                    for(int j=i;j>i-width;j--){
                        height[j]+=addHeight;
                    }
                    find=true;
                    width=1;
                    pre=height[i];
                } else if (height[i] <= height[i - 1]&&height[i]==height[i+1]) {
                    width++;
                }
                else {
                    pre=height[i];
                    width=1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(trap(ListNode.stringToIntegerArray("[5,5,1,7,1,1,5,2,7,6]")));
    }

}
