package Fight;

import java.util.Scanner;

//����һ���У�����Ϊn������Ԫ�ؾ�Ϊ����Ԫ�ء�������һЩԪ����ȷ��ֵ����һЩԪ���ǲ�ȷ���ġ� ��������ǽ����в�ȷ��ֵ��Ԫ�ظ���һ��������ֵ��ʹ�ý��������зָ�����ٵĶΣ�ÿһ���ζ���һ���Ȳ����С� �ر�ģ�����Ϊ1��2�Ķζ��ǵȲ����С�
//��������������ݣ���ÿ�����ݵ�һ�а���һ������n ������һ��n���������ո�����������Ϊ-1,�����Ԫ�ز�ȷ���������Ԫ��Ϊȷ��ֵ����������������ֵ��
//���һ��һ����������ָ�����ٵĶ�����ʹ��ÿһ�ζ��ǵȲ�����
public class ShunFeng1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int n=Integer.parseInt(sc.nextLine());
			String[] nums_str=sc.nextLine().split(" ");
			int[] nums=new int[nums_str.length];
			for(int i=0;i<nums.length;i++) nums[i]=Integer.parseInt(nums_str[i]);
			outer1:for(int i=0;i<nums.length;i++) {
				if(nums[i]==-1) {
					int j=i,k=i;
					System.out.println(j);
					while(j>=0&&nums[j]==-1) j--;
					if(j>=1) {
						nums[j]=nums[j-1];
						continue outer1;
					}
					while(k<nums.length&&nums[k]==-1) k++;
						if(k<nums.length-1) {
							nums[k]=nums[k+1];
							continue outer1;
						}
					}
					nums[i]=1;
			}
			int result=1;
			for(int i=0;i<nums.length-1;i++) {
				if(nums[i]!=nums[i+1]-1) result++;
			}

			System.out.println(result);
			
		}
	}
}
