package 剑指offer;

import java.util.ArrayList;

//找出所有和为S的连续正数序列，序列最少两个数
public class FindContinuousSequence{
	public static void main(String[] args) {
		FindContinuousSequence findContinuousSequence=new FindContinuousSequence();
		ArrayList<ArrayList<Integer>> lists=findContinuousSequence.test(100);
		for(ArrayList<Integer> temp:lists) System.out.println(temp.toString());
	}
	public ArrayList<ArrayList<Integer>> test(int sum) {
		ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
		//left,right窗口边界值
		for(int i=0,left=1,right=1,temp=0;i<=sum/2;i++) {
			if(temp<sum) {
//				加上右窗口值，窗口扩大
				temp+=right;
				++right;
			}
			else if(temp>sum) {
//				减去左窗口值，窗口减小
				temp-=left;
				++left;
			}
			else {
//				恰好相等，从左窗口截取到右窗口
				ArrayList<Integer>list=new ArrayList<Integer>();
				for(int k=left;k<right;k++) list.add(k);
				lists.add(list);
//				窗口缩小，继续
				temp-=left;
				++left;
			}
		}
		return lists;
	}
}
//    public ArrayList<ArrayList<Integer>> test(int sum) {
//    	ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
////    	因为最少两个，到一半就行
//        for(int i=1;i<sum/2+1;i++) {
////        	从第一个指针开始，temp保存sum的值，temp自减j，如果temp等于0，则说明这个数及前面某几个数是要保存的
//        	for(int j=i,temp=sum;temp>=0;j++) {
//        		temp-=j;
////        		System.out.println(temp+"+"+j);
//        		if(temp==0) {
////        			这时才新建数组，减少内存开销
//        			ArrayList<Integer> list=new ArrayList<Integer>();
////        			从当前数开始往前，保存j,j-1,j-2……用tempsum作为标志,注意for循环的特点
////        			如果条件写成tempsum>sum,最后一个使得条件不成立的的数不该添加进来，但先添加再判断，所以已经晚了
////        			所以这里的判断条件要特别留意
////        			还有一个就是，当j-depth<0，第二个判断会恒成立，所以要加一个大于0的判断
//        			for(int tempsum=0,depth=0;(j-depth)>0&&tempsum+(j-depth)<=sum;depth++) {
//        				tempsum+=(j-depth);
//        				list.add(j-depth);
//        			}
//        			if(list.size()>1&&(!lists.contains(list))) {
////        				这里也可以直接用list的sort
//        				Collections.reverse(list);
//        				lists.add(list);
//        			}
//        		}
//        	}
//        }
//        return lists;
//    }

