
public class leetcode_12 {
	public static String intToRoman(int num) {
		//1,5,10,50,100,500,1000
		//I,V,X,L,C,D,M
		int[] numberOfroman= {1000,500,100,50,10,5,1};
		String[] roman= {"M","D","C","L","X","V","I"};
		StringBuilder result=new StringBuilder("");
		for(int i=0;i<7;i++) {
			int temp=num/numberOfroman[i];
			if(temp==0)
				continue;
			if(temp==4&&i%2==0) {
				num=num-4*numberOfroman[i];
				result=result.append(roman[i]).append(roman[i-1]);
				continue;
			}
			if(i%2==1) {
				if(num/numberOfroman[i+1]==9) {
					result=result.append(roman[i+1]).append(roman[i-1]);
					num=num-9*numberOfroman[i+1];
					continue;
				}
			}
			
			num=num-temp*numberOfroman[i];
			for(int j=0;j<temp;j++) {
				result=result.append(roman[i]);
			}
			
		}
		
		return result.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(intToRoman(1994));
	}
}
