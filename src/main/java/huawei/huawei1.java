package huawei;

import java.util.Scanner;

public class huawei1 {

    public static boolean runYear(int year){
        if(year%4==0&&year%400!=0)
            return true;
        return false;
    }

    public static int days(int year,int month,int day){
        int count=0;
        for(int i=startYear;i<year;i++){
            if(runYear(i))
                count+=1;
            count+=365;
        }
        boolean IsRun=runYear(year);
        for(int i=1;i<month;i++){
            count+=MONTHDAY[i-1];
            if(i==2&&IsRun)
                count+=1;
        }
        count+=day;
        return count;
    }

    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String str=scanner.nextLine();
            String[] dataSplit=str.split("\\|");
            String[] l=dataSplit[0].split(" ");
            String[] r=dataSplit[1].split(" ");
            int leftYear=Integer.parseInt(l[0]);
            int leftMonth=Integer.parseInt(l[1]);
            int leftDay=Integer.parseInt(l[2]);
            int leftWeek=Integer.parseInt(l[3]);
            int rightYear=Integer.parseInt(r[0]);
            int rightMonth=Integer.parseInt(r[1]);
            int rightDay=Integer.parseInt(r[2]);
            int left=days(leftYear,leftMonth,leftDay);
            int right=days(rightYear,rightMonth,rightDay);
            int res=(leftWeek+(right-left))%7;
            res=(res+7)%7;
            System.out.println(res==0?7:res);
        }
    }

    static int startYear=1000;
    static int[] MONTHDAY;

    public static void main(String[] args) {
        MONTHDAY=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        IO();
    }
}
