import java.util.ArrayList;
import java.util.List;

public class leetcode_59 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        if (n == 0)
            return matrix;
        int horizonTurn = n - 1;
        int VerticalTurn = n - 1;
        int count = 0;
        int i = 0, j = 0;
        boolean vertical_horizon = false;
        int add_minus = 1;
        while (true) {
            if (horizonTurn == 0 && VerticalTurn == 0) {
                matrix[i][j]=++count;
                if (count >= n * n)
                    break;
            }
            if (count >= n * n)
                break;
            for (int k = 0; k < horizonTurn; k++) {
                matrix[i][j++]=++count;
                if (count >= n * n)
                    break;
            }
            if (count >= n * n)
                break;
            for (int k = 0; k < VerticalTurn; k++) {
                matrix[i++][j]=++count;
                if (count >= n * n)
                    break;
            }
            if (count >= n * n)
                break;
            for (int k = 0; k < horizonTurn; k++) {
                matrix[i][j--]=++count;
                if (count >= n * n)
                    break;
            }
            if (count >= n * n)
                break;
            for (int k = 0; k < VerticalTurn; k++) {
                matrix[i--][j]=++count;
                if (count >= n * n)
                    break;
            }
            if (count >= n * n)
                break;
            i++;
            j++;

            VerticalTurn -= 2;
            horizonTurn -= 2;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] res=generateMatrix(1);
        System.out.print(0);
    }
}
