package 华为;

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
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.poll();
            }
            // 添加当前值对应的数组下标
            queue.add(i);
            // 判断当前队列中队首的值是否有效
            if(queue.size()>k){
                queue.poll();   
            } 
            // 从遍历到第k个开始往结果数组加入值当窗口长度为k时 保存当前窗口中最大值
//            当遍历到下标为i，可以确定i在队列中（add），也可以保证队列头存的是包含i对应值在内最大的值
            if(i-k+1>=0){
                result[i-k+1] = nums[queue.peek()];
            }
        }
        return result;
    }
}
