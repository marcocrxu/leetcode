import java.util.Currency;

public class leetcode_5385 {
    public static int maxDiff(int num) {
        int max=0;
        int SameBigLeastNumber=(int)Math.pow(10,(int)Math.log10(num));
        int temp=SameBigLeastNumber;
        int currentVal=num/temp;
        boolean find=false;
        int tempNum=num;
        //tempNum-=currentVal*temp;
        while(currentVal==9){
            tempNum=tempNum-currentVal*temp;
            temp=temp/10;
            if(temp==0) {
                find=true;
                max=num;
                break;
            }
            currentVal=tempNum/temp;
        }
        if(!find){
            max=num+(9-currentVal)*temp;
        }

        int min=num;
        temp=SameBigLeastNumber;
        currentVal=num/temp;
        if(currentVal!=1){
            min=num-(currentVal-1)*temp;
        } else {
            tempNum=num;
            tempNum-=currentVal*temp;
            temp/=10;
            currentVal=tempNum/temp;
            find=false;
            while(currentVal==0){
                tempNum=tempNum-currentVal*temp;
                temp=temp/10;
                if(temp==0) {
                    find=true;
                    min=num;
                    break;
                }
                currentVal=tempNum/temp;
            }
            if(!find){
                min=num-(currentVal)*temp;
            }
        }

        return max-min;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(1000));
    }
}
