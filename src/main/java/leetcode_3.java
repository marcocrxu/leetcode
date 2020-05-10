/**************************************************************
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 *************************************************************/
public class leetcode_3{
	/*
	public static int lengthOfLongestSubstring(String s) {
		int result=0;
		//����
		int len=s.length();
		int maxlen=0;
		for(int i=0;i<len;i++) {
			//��һ��hash���ж�
			int [] hashmap=new int[128];
			//��ʼ����ϣ��
			for(int j=0;j<128;j++) {
				hashmap[j]=0;
			}
			int count=1;
			hashmap[s.charAt(i)]=1;
			for(int j=i+1;j<len;j++) {
				//�ж�����ַ��ǲ����Ѿ����ֹ�
				if(hashmap[s.charAt(j)]==1)
					break;
				else
					hashmap[s.charAt(j)]=1;
				count++;
			}
			if(count>maxlen)
				maxlen=count;
		}
			
		result=maxlen;
		
		return result;
    }
	 */
	public static int lengthOfLongestSubstring(String s) {
		int result=0;
		//ǰ��Ļ���ָ��
		int front=0;
		int last=0;
		int len=s.length();
		boolean [] hashmap=new boolean[128];
		int maxlen=0;
		//��ʼ��hashmap
		for(int i=0;i<128;i++) {
			hashmap[i]=false;
		}
			
		while(last<len) {			
			if(hashmap[s.charAt(last)]==false) {
				//���Ƚ���һ����������
				hashmap[s.charAt(last)]=true;
				last++;
				maxlen++;
			}
			else {
				//������Ҫ�����maxlen��¼����
				if(maxlen>result)
					result=maxlen;
				//�������ַ��Ѿ����ˣ��Ǿ͸�front++
				while(s.charAt(front++)!=s.charAt(last)) {
					//������Ҫ��һ����ԭ�����ַ�ɾȥ�Ĳ���
					hashmap[s.charAt(front-1)]=false;
					//maxlen--;
					//front++;
				}
				hashmap[s.charAt(front-1)]=false;
				maxlen=last-front;
			}
		}
		if(maxlen>result)
			result=maxlen;
		return result;
	}
	
	public static void main(String arg[]) {
		String s=" ";
		int maxlen=lengthOfLongestSubstring(s);
		System.out.println(maxlen);
		
	}
}


