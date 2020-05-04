import com.sun.jdi.connect.Connector;
import java.util.*;
public class leetcode_1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        return findMountain(target,0,mountainArr.length(),mountainArr);
    }

    public int findMountain(int target,int start,int end,MountainArray mountainArr){
        int mid=(start+end)/2;
        int midVal = mountainArr.get(mid);
        //当start==end-1
        if(mid==start){
            if(target==midVal)
                return mid;
            else if(target==mountainArr.get(end))
                return end;
            else
                return -1;
        }
        //此时mid>start
        //判断mid-1对应的大小
        int midMinusOne= mountainArr.get(mid - 1);
        if(midMinusOne<midVal){
            //山峰在mid右边
            int left;
            if(target<=midVal)
                left=findBinaryUp(target,start,mid,mountainArr);
            else
                left=-1;
            if(left==-1){
                return findMountain(target,mid,end,mountainArr);
            }
            return left;
        }
        else{
            //山峰在mid左边
            int left=findMountain(target,start,mid,mountainArr);
            if(left==-1){
                if(midVal<target)
                    return -1;
                return findBinaryDown(target,mid,end,mountainArr);
            }
            return left;
        }
    }

    public int findBinaryUp(int target,int start,int end,MountainArray mountainArr) {
        while(start<end){
            int mid=(start+end)/2;
            int temp=mountainArr.get(mid);
            if(temp>target){
                end=mid;
            }
            else if(temp==target){
                return mid;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }

    public int findBinaryDown(int target,int start,int end,MountainArray mountainArr){
        while(start<end){
            int mid=(start+end)/2;
            int temp=mountainArr.get(mid);
            if(temp<target){
                end=mid;
            }
            else if(temp==target){
                return mid;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }


}
