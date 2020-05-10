public class leetcode_48 {
    public static void rotate(int[][] matrix) {
        int n=matrix[0].length;
        int m=n-1;
        for(int j=0;j<n/2;j++){
            for(int i=j;i<j+m;i++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
            m-=2;
        }
    }

    public static void main(String[] args) {
        int[][] matrix=new int[][]{new int[]{5,1,9,11},new int[]{2,4,8,10},new int[]{13,3,6,7},new int[]{15,14,12,16}};
        rotate(matrix);
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
