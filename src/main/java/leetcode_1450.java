public class leetcode_1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count=0;
        for(int i=0;i<startTime.length;i++){
            if(queryTime<=endTime[i]&&queryTime>=startTime[i])
                count++;
        }
        return count;
    }
}
