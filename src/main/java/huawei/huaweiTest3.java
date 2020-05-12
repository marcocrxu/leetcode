package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class huaweiTest3 {
    enum type{Single,Double,Triple,Follow,Bomb,DoubleCat};

    public static type getType(String[] card){
        if(card.length==1)
            return type.Single;
        if(card.length==2&& card[0].equals(card[1])){
            return type.Double;
        }
        if(card.length==2&&card[0].equals("joker")&&card[1].equals("JOKER"))
            return type.DoubleCat;
        if(card.length==3&&card[0].equals(card[1])&&card[0].equals(card[2]))
            return type.Triple;
        if(card.length==4&&card[0].equals(card[1])&&card[0].equals(card[2])&&card[0].equals(card[3])){
            return type.Bomb;
        }
        else
            return type.Follow;
    }

    static Map<String,Integer> cardVal;

    /**
     * @return positive if s1 big than s2 else negative
     * */
    public static int judgeBigSmall(String s1,String s2) {
        return cardVal.get(s1)-cardVal.get(s2);
    }

    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            String[] split=s.split("-");
            String left=split[0];
            String right=split[1];
            String[] l=left.split(" ");
            String[] r=right.split(" ");
            type l_type=getType(l);
            type r_type=getType(r);
            if(l_type!=type.Bomb&&l_type!=type.DoubleCat&&r_type!=type.Bomb&&r_type!=type.DoubleCat){
                //都不是炸弹
                if(l_type.equals(r_type)){
                    if(judgeBigSmall(l[0],r[0])>0){
                        //l>r
                        System.out.println(left);
                    }else{
                        System.out.println(right);
                    }
                }
                else{
                    System.out.println("ERROR");
                }
            }
            else {
                if(l_type==type.DoubleCat)
                    System.out.println(left);
                else if(r_type==type.DoubleCat)
                    System.out.println(right);
                else{
                    if(l_type==type.Bomb&&r_type!=type.Bomb)
                        System.out.println(left);
                    else if(l_type!=type.Bomb&&r_type==type.Bomb)
                        System.out.println(right);
                    else {
                        if(judgeBigSmall(l[0],r[0])>0)
                            System.out.println(left);
                        else
                            System.out.println(right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //初始化牌大小
        String[] cardOrder=new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A","2","joker","JOKER"};
        cardVal=new HashMap<>();
        for(int i=0;i<cardOrder.length;i++){
            cardVal.put(cardOrder[i],i);
        }
        IO();
    }
}
