import java.io.*;
public class leetcode_6 {
	public static String convert(String s, int numRows) {
		String result="";
		int t=2*numRows-2;
		//positon用来记录位置
		//比如numRows=4时，一个周期会有2*4-2=6个元素
		//*	#
		//*	#   #
		//*	# #
		//*	#
		if(s.equals(""))
			return result;
		else {
		int[] order=new int[t];
		order[0]=1;order[t-1]=numRows;
		for(int i=1;i<numRows-1;i++) {
			order[2*i-1]=i+1;
			order[2*i]=2*numRows-i-1;
		}
		int len=s.length();
		int[] charpos=new int[len];
		//初始化
		for(int i=0;i<len;i++) {
			charpos[i]=0;
		}
		int turn=len/t;
		StringBuilder sb=new StringBuilder(s);
		int k=0;
		for(int i=0;i<numRows;i++) {
			for(int j=0;j<turn+1;j++) {
				if(i==0||i==numRows-1) {
					if((j*t+i)<len) 
						sb.setCharAt(k++, s.charAt(j*t+i));
				}
				else {
					if((j*t+order[2*i-1]-1)<len)
						sb.setCharAt(k++,s.charAt(j*t+order[2*i-1]-1));
					if((j*t+order[2*i]-1)<len)
						sb.setCharAt(k++,s.charAt(j*t+order[2*i]-1));
				}
			}
		}
		result=sb.toString();
		return result;
		}
    }
	
	public static void main(String[] arg) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        line=in.readLine();
        //line = in.readLine();
        String s = line;
		//String s="";
		int row=1;
		String result=convert(s,row);
		System.out.println(result);
	}
}
