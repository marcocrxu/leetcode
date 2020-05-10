public class leetcode_221 {
    public static int maximalSquare(char[][] matrix) {
        int max=0;
        int sum=0;
        int m=matrix.length;
        if(m==0)
            return 0;
        int n=matrix[0].length;
        for(int i=0;i<m-sum;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    sum=0;
                }
                else{
                    sum+=1;
                    if(sum>max){
                        /*检查下面的是不是*/
                        boolean find=false;
                        if(i+sum>m)
                            find=true;
                        else {
                            for (int k = i; k < i + sum; k++) {
                                for (int l = j; l > j - sum; l--) {
                                    if (matrix[k][l] == '0') {
                                        find = true;
                                        break;
                                    }
                                }
                                if (find)
                                    break;
                            }
                        }
                        if(!find)
                            max=sum;
                        else
                            sum--;
                    }
                }
            }
            sum=0;
        }
        return max*max;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{new char[]{'0','0','0','1'},new char[]{'1','1','0','1'},new char[]{'1','1','1','1'},new char[]{'0','1','1','1'},new char[]{'0','1','1','1'}}));
    }
}
