package huawei;

import java.util.LinkedList;

public class p12 {
	public static void main(String[] args) {
		int[]a={1,3,1,2,0,5};
		int[]b=new Solution1().maxSlidingWindow(a,3);
		for(Integer temp:b) {
			System.out.print(temp+",");
			
		}
	}
}
class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // ˫����� ���浱ǰ�������ֵ������λ�� ��֤����������λ�õ���ֵ���Ӵ�С����
        LinkedList<Integer> queue = new LinkedList();
        // �������
        int[] result = new int[nums.length-k+1];
        // ����nums����
        for(int i = 0;i < nums.length;i++){
            // ��֤�Ӵ�С ���ǰ����С����Ҫ���ε�����ֱ������Ҫ��
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.poll();
            }
            // ��ӵ�ǰֵ��Ӧ�������±�
            queue.add(i);
            // �жϵ�ǰ�����ж��׵�ֵ�Ƿ���Ч
            if(queue.size()>k){
                queue.poll();   
            } 
            // �ӱ�������k����ʼ������������ֵ�����ڳ���Ϊkʱ ���浱ǰ���������ֵ
//            ���������±�Ϊi������ȷ��i�ڶ����У�add����Ҳ���Ա�֤����ͷ����ǰ���i��Ӧֵ��������ֵ
            if(i-k+1>=0){
                result[i-k+1] = nums[queue.peek()];
            }
        }
        return result;
    }
}