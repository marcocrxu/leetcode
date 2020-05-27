public class huawei {
    public static String MaxStr(String str){
        int n=str.length();
        int[][] dp=new int[n][n];
        //�����ַ����ǻ����Ӵ�
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        //�ж������Է����ȵĻ��Ĵ�
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=str.charAt(i)==str.charAt(i+1)?1:0;
        }
        //�ȳ�ʼ��һ���϶���֪�Ļ��Ĵ�
        int max=1;
        int best_start=0;
        int best_end=1;
        //���dp[i][j]�ǻ����Ӵ�������str[i-1]��str[j+1]��ȣ���dp[i-1][j+1]Ҳ��һ�������Ӵ�
        for(int i=2;i<n-1;i++){
            for(int j=0;j<n-i;j++){
                //dp[j][i]
                if(dp[j+1][j+i-1]==1&&str.charAt(j)==str.charAt(j+i)){
                    dp[j][i]=1;
                    //���������һ����max��Ҫ�����Ӵ�
                    if(i>max){
                        max=i;
                        best_start=j;
                        best_end=j+i+1;
                    }
                }
            }
        }
        return str.substring(best_start,best_end);
    }


    public static void main(String[] args) {
        System.out.println(MaxStr("abac"));
    }
}
