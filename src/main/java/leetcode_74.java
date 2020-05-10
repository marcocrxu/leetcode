public class leetcode_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int end=matrix.length;
        if(end==0)
            return false;
        if(matrix[0].length==0)
            return false;
        if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1])
            return false;
        while(start<end){
            int mid=(start+end)/2;
            if(matrix[mid][0]>target){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        int line=start-1;
        start=0;
        end=matrix[0].length;
        while(start<end){
            int mid=(start+end)/2;
            if(matrix[line][mid]>target){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return matrix[line][end-1]==target;
    }

    public static void main(String[] args) {
        int[][] matrix=ListNode.stringToInt2dArray("[[1]]");
        System.out.println(searchMatrix(matrix,1));
    }
}
