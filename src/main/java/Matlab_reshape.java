public class Matlab_reshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length==0)
            return nums;
        if(nums.length*nums[0].length!=r*c)
            return nums;
        int[][] res=new int[r][c];
        int count=0;int inside=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res[i][j]=nums[count][inside++];
                if(nums[count].length<=inside){
                    count++;
                    inside=0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[][] res=matrixReshape(new int[][]{new int[]{1,2},new int[]{3,4}},4,2);
        System.out.println(0);
    }
}
