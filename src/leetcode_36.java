import java.lang.reflect.Array;
import java.util.*;
public class leetcode_36 {
    public static boolean isValidSudoku(char[][] board) {
        int[] test=new int[9];
        Arrays.fill(test,0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int temp=1<<(board[i][j]-'1');
                    if((temp&test[i])==0)
                        test[i]|=temp;
                    else
                        return false;
                }
            }
        }
        Arrays.fill(test,0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    int temp=1<<(board[j][i]-'1');
                    if((temp&test[i])==0)
                        test[i]|=temp;
                    else
                        return false;
                }
            }
        }
        Arrays.fill(test,0);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<9;k++){
                    if(board[3*i+k/3][3*j+k%3]!='.'){
                        int temp=1<<(board[i*3+k/3][j*3+k%3]-'1');
                        if((temp&test[i*3+j])==0)
                            test[i*3+j]|=temp;
                        else
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] board=new char[9][9];
        System.out.println(isValidSudoku(new char[][]{
                new char[]{'.','.','.','.','5','.','.','1','.'},
                new char[]{'.','4','.','3','.','.','.','.','.'},
                new char[]{'.','.','.','.','.','3','.','.','1'},
                new char[]{'8','.','.','.','.','.','.','2','.'},
                new char[]{'.','.','2','.','7','.','.','.','.'},
                new char[]{'.','1','5','.','.','.','.','.','.'},
                new char[]{'.','.','.','.','.','2','.','.','.'},
                new char[]{'.','2','.','9','.','.','.','.','.'},
                new char[]{'.','.','4','.','.','.','.','.','.'}
        }));
    }

}
/*
* [[".",".",".",".","5",".",".","1","."],
* [".","4",".","3",".",".",".",".","."],
* [".",".",".",".",".","3",".",".","1"],
* ["8",".",".",".",".",".",".","2","."],
* [".",".","2",".","7",".",".",".","."],
* [".","1","5",".",".",".",".",".","."],
* [".",".",".",".",".","2",".",".","."],
* [".","2",".","9",".",".",".",".","."],
* [".",".","4",".",".",".",".",".","."]]
* */