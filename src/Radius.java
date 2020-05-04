import java.util.Arrays;
import java.util.List;

public class Radius {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min=0;
        int[] new_heaters=new int[heaters.length+2];
        new_heaters[0]=Integer.MIN_VALUE;new_heaters[new_heaters.length-1]=Integer.MAX_VALUE;
        for(int i=1;i<new_heaters.length-1;i++)
            new_heaters[i]=heaters[i-1];
        for(int temp:houses){
            int index=lowerBound(new_heaters,0,new_heaters.length,temp);
            int x=(int)Math.min((long)temp-(long)new_heaters[index-1],(long)new_heaters[index]-(long)temp);
            if(x>min){
                min=x;
            }
        }
        return min;
    }

    public static int findMinus(int[] heaters, int start, int end, int pos){
        if(start+1==end){
            if(pos<=heaters[start]&&pos>heaters[start-1])
                return (int)Math.min((long)(pos)-(long)(heaters[start-1]),(long)(heaters[start])-(long)(pos));
            else{
                return (int)Math.min((long)(pos)-(long)(heaters[start]),(long)(heaters[start+1])-(long)(pos));
            }
        }
        int mid=(start+end)/2;
        if(heaters[mid]>=pos){
            return findMinus(heaters,start,mid,pos);
        }
        else{
            return findMinus(heaters,mid,end,pos);
        }
    }

    public static int lowerBound(int []nums,int l,int r,int target){
        while(l<r){
            int m = (l+r)/2;
            if(nums[m]>=target) r= m;
            else    l = m +1;
        }
        return l;

    }


    public static void main(String[] args){
        System.out.println(findRadius(ListNode.stringToIntegerArray("[1,5]"), ListNode.stringToIntegerArray("[10]")));
    }
}
