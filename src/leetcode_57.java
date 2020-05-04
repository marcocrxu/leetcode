public class leetcode_57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{newInterval};
        int start = 0;
        for (int i = 0; i < intervals.length; i++) {
            //找到第一个intervals[i][0]>=newInterval[0]
            if (intervals[i][0] >= newInterval[0]) {
                /*还需要判断前一个的右边际值与之大小*/
                if (i > 0) {
                    if (intervals[i - 1][1] < newInterval[0]) {
                        /*从当前开始合并:i*/
                        start = i;
                        break;
                    } else {
                        /*从前一个开始合并:i-1*/
                        start = i - 1;
                        break;
                    }
                } else
                    break;
            }
            start++;
        }
        int count = 0;
        if (start == intervals.length) {
            if(newInterval[1]<=intervals[intervals.length-1][1]){
                return intervals;
            }
            if(newInterval[0]<=intervals[intervals.length-1][1]) {
                intervals[intervals.length-1][1]=Math.max(intervals[intervals.length-1][1],newInterval[1]);
                return intervals;
            }
            int[][] res = new int[intervals.length + 1][2];
            for (int i = 0; i < intervals.length; i++) {
                res[i] = intervals[i];
            }
            res[intervals.length] = newInterval;
            return res;
        } else {
            if(newInterval[1]>=intervals[start][0])
                intervals[start][0] = Math.min(intervals[start][0], newInterval[0]);
            else{
                int[][] res = new int[intervals.length +1][2];
                int j = 0;
                for (int i = 0; i < start; i++) {
                    res[i] = intervals[j++];
                }
                res[start]=newInterval;
                for(int i=start+1;i<res.length;i++){
                    res[i]=intervals[j++];
                }
                return res;
            }
            if (newInterval[1] >= intervals[start][1]) {
                intervals[start][1]=newInterval[1];
                for (int j = start + 1; j < intervals.length; j++) {
                    /*如果没有他的开头大*/
                    if (newInterval[1] < intervals[j][0]) {
                        intervals[start][1] = newInterval[1];
                        break;
                    }
                    if (newInterval[1] >= intervals[j][1]) {
                        count++;
                        intervals[j] = null;
                    } else {
                        intervals[start][1] = intervals[j][1];
                        count++;
                        intervals[j] = null;
                        break;
                    }
                }
            }
            int[][] res = new int[intervals.length - count][2];
            int j = 0;
            for (int i = 0; i < res.length; i++) {
                while (intervals[j] == null) {
                    j++;
                }
                res[i] = intervals[j++];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] res=insert(new int[][]{new int[]{1,5}},new int[]{0,0});
        System.out.print(0);
    }
}
