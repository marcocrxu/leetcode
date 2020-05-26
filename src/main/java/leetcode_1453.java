import java.util.ArrayList;
import java.util.List;

public class leetcode_1453 {
    public static double cacu(double x1,double y1,int x2,int y2){
        return Math.pow(x1-x2,2)+Math.pow(y1-y2,2);
    }

    public static int numPoints(int[][] points, int r) {
        int minx=Integer.MAX_VALUE;
        int maxx=Integer.MIN_VALUE;
        int miny=Integer.MAX_VALUE;
        int maxy=Integer.MIN_VALUE;
        for(int[] temp:points){
            if(minx>temp[0])
                minx=temp[0];
            if(maxx<temp[0])
                maxx=temp[0];
            if(miny>temp[1])
                miny=temp[1];
            if(maxy<temp[1])
                maxy=temp[1];
        }
        int maxCount=0;
        int count=0;
        double r2=Math.pow(r,2);
        for(double i=minx;i<maxx;i+=0.2){

            for(double j=miny;j<maxy;j+=0.2){
                count=0;
                for(int[] temp:points){
                    if(cacu(i,j,temp[0],temp[1])-r2<=0.001)
                        count++;
                }
                if(count>maxCount)
                    maxCount=count;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(numPoints(ListNode.stringToInt2dArray("[[-23,0],[23,22],[15,1],[-15,2],[30,-25],[2,19],[18,12],[9,21],[17,11],[20,-22],[-21,26],[25,0],[-18,15],[16,-18],[-5,-6],[10,4],[18,-20],[-19,-8],[-14,-28],[-5,3],[-16,-10],[-7,1]]"),23));
    }
}
