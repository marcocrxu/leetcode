
public class leetcode_2{
	
	public static int getNodeLen(ListNode l1)
	{
		/*返回ListNode的长度*/
		int len=1;
		ListNode l=l1.next;
		while(l!=null)
		{
			len++;
			l=l.next;
		}
		return len;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		/*创建返回的结果的节点*/
		ListNode result=new ListNode(0);
		/*包含头节点的链表*/
		int len1=getNodeLen(l1);
		int len2=getNodeLen(l2);
		int minlen=(len1<len2)?len1:len2;
		int minorder=(len1<len2)?1:2;
		/*c表示进位*/
		int c=0;
		ListNode temp1=l1;
		ListNode temp2=l2;
		ListNode temp_result=result;
		for(int i=0;i<minlen;++i)
		{
			if(temp1==null&&temp2==null)
			{
				System.out.println("out of index");
			}
			int number=temp1.val+temp2.val+c;
			if(i==0) {
				result.val=number%10;
			}
			else {
				ListNode temp=new ListNode(number%10);
				temp_result.next=temp;
				temp_result=temp_result.next;
			}
			temp1=temp1.next;
			temp2=temp2.next;
			/*计算新的进位*/
			c=number/10;
		}
		/*如果两个长度相同*/
		if(len1==len2)
		{
			if(c==0)
				return result;
			else {
				temp_result.next=new ListNode(c);
				return result;
			}
		}

		ListNode nexttemp;
		if(minorder==1)
		{
			nexttemp=temp2;
		}
		else
		{
			nexttemp=temp1;
		}
		
		/*长度不同就将接到后面*/
		if(c==0) {
			temp_result.next=nexttemp;
		}
		else{
			ListNode temp=nexttemp;
			while(temp!=null) {
				int val=temp.val+c;
				temp_result.next=new ListNode(val%10);
				c=val/10;
				temp_result=temp_result.next;
				temp=temp.next;
			}
			if(c!=0)
			{
				temp_result.next=new ListNode(c);
			}
		}
		return result;
		
	}
	
	public static void printNode(ListNode l)
	{
		ListNode temp=l;
		while(temp!=null)
		{
			System.out.println(temp.val);
			temp=temp.next;
		}
		return;
	}
	
	public static ListNode convert(int x)
	{
		ListNode result=new ListNode(x%10);
		x=x/10;
		ListNode temp=result;
		while(x!=0) {
			temp.next=new ListNode(x%10);
			temp=temp.next;
			x=x/10;
		}
		return result;
	}
	
	public static void main(String arg[])
	{
		System.out.println("start");
		ListNode l1=convert(1);
		ListNode l2=convert(99);
		ListNode result=addTwoNumbers(l1,l2);
		printNode(result);
	}
}

