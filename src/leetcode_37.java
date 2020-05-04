import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode_37 {
    public static void solveSudoku(char[][] board) {
        int[] row=new int[9];
        int[] col=new int[9];
        int[] group=new int[9];
        Arrays.fill(row,0);
        Arrays.fill(col,0);
        Arrays.fill(group,0);

        int [][]sheet=new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') {
                    sheet[i][j] =board[i][j] - '0';
                    row[i]|=(1<<(sheet[i][j]));
                    col[j]|=(1<<(sheet[i][j]));
                    group[(i/3)*3+j/3]|=(1<<(sheet[i][j]));
                }else{
                    sheet[i][j]=-1;
                }
            }
        }
        int firstPos=0;
        boolean find=false;
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++){
                if(sheet[i][j]==-1) {
                    firstPos = i * 9 + j;
                    find=true;
                    break;
                }
            }
            if(find)
                break;
        }

        dfs(sheet,firstPos,row,col,group);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=(char)(sheet[i][j]+48);
            }
        }
    }

    public static boolean dfs(int[][] sheet,int firstPos,int[] row,int[] col,int[] group){
        int rows=firstPos/9;
        int cols=firstPos%9;
        int groups=(rows/3)*3+cols/3;
        //找到一个可以填进去的数字
        int res=row[rows]|col[cols]|group[groups];
        for(int i=1;i<=9;i++){
            int temp=1<<i;
            if((temp&res)==0){
                row[rows]|=temp;
                col[cols]|=temp;
                group[groups]|=temp;
                sheet[rows][cols]=i;
                //找到下一个起始位置
                boolean find=false;
                int j;
                for(j=firstPos+1;j<81;j++){
                    if(sheet[j/9][j%9]==-1){
                        find=true;
                        break;
                    }
                }
                if(!find)
                    return true;
                //假设找到了
                if(dfs(sheet,j,row,col,group)){
                    return true;
                }
                //假的话说明这个数字填的不成功，下一个
                row[rows]^=temp;
                col[cols]^=temp;
                group[groups]^=temp;
                sheet[rows][cols]=-1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[][] board=new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.print('\n');
        }
    }
}
