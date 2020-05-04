import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class leetcode_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m=matrix.length;
        if(m==0)
            return res;
        int n=matrix[0].length;
        int horizonTurn=n-1;
        int VerticalTurn=m-1;
        int count=0;
        int i=0,j=0;
        boolean vertical_horizon=false;
        int add_minus=1;
        while(true){
            if(horizonTurn==0&&VerticalTurn==0) {
                res.add(matrix[i][j]);
                count++;
                if(count>=m*n)
                    break;
            }
            if(count>=m*n)
                break;
            for(int k=0;k<horizonTurn;k++){
                res.add(matrix[i][j++]);
                count++;
                if(count>=m*n)
                    break;
            }
            if(count>=m*n)
                break;
            for(int k=0;k<VerticalTurn;k++){
                res.add(matrix[i++][j]);
                count++;
                if(count>=m*n)
                    break;
            }
            if(count>=m*n)
                break;
            for(int k=0;k<horizonTurn;k++){
                res.add(matrix[i][j--]);
                count++;
                if(count>=m*n)
                    break;
            }
            if(count>=m*n)
                break;
            for(int k=0;k<VerticalTurn;k++){
                res.add(matrix[i--][j]);
                count++;
                if(count>=m*n)
                    break;
            }
            if(count>=m*n)
                break;
            i++;
            j++;

            VerticalTurn-=2;
            horizonTurn-=2;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res=spiralOrder(new int[][]{new int[]{1},new int[]{2},new int[]{3}});
        System.out.print(0);
    }
}
