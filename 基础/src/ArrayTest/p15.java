package ArrayTest;

import java.util.Arrays;



public class p15 {
public static void main(String[] args) {
	//ð������
	
	
	int[] test= {8,9,5,5,3,8,6,5,623,880};
	int cnt=0;
	for(int i=0;i<test.length;i++) {
	for(int j=0;j<test.length-1-i;j++) {
		if(test[j]>test[j+1]) {
			int temp=test[j];
			test[j]=test[j+1];
			test[j+1]=temp;
			System.out.println(Arrays.toString(test));
			cnt++; 
		}
	}
}
	System.out.println(cnt);
//	System.out.println(erfenfa(623,test));
//	�������д������Integer��û�з��ؽ�����漰��p16�����еĻ�������
	System.out.println(erfenfa(5,test));
}
//���ַ������ź��������
private static int erfenfa(int value,int[] test) {
//Scanner scanner=new Scanner(System.in);
//int tar=Integer.parseInt(scanner.next());
int low=0;
int high=test.length-1;
while(low<high) {
	int mid=(low+high)/2;
//	Integer a=value;
//	Integer b=test[mid];
//	if(a==b) 
	if(value==test[mid])
	{
		return mid;
	}
	if(value<test[mid]) {
		high=mid-1;
		System.out.println("���");
	}
	if(value>test[mid]) {
		low=mid+1;
		System.out.println("�ұ�");
	}
}
return -1;
}
}
