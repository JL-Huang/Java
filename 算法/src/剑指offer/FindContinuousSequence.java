package ��ָoffer;

import java.util.ArrayList;

//�ҳ����к�ΪS�������������У���������������
public class FindContinuousSequence{
	public static void main(String[] args) {
		FindContinuousSequence findContinuousSequence=new FindContinuousSequence();
		ArrayList<ArrayList<Integer>> lists=findContinuousSequence.test(100);
		for(ArrayList<Integer> temp:lists) System.out.println(temp.toString());
	}
	public ArrayList<ArrayList<Integer>> test(int sum) {
		ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
		//left,right���ڱ߽�ֵ
		for(int i=0,left=1,right=1,temp=0;i<=sum/2;i++) {
			if(temp<sum) {
//				�����Ҵ���ֵ����������
				temp+=right;
				++right;
			}
			else if(temp>sum) {
//				��ȥ�󴰿�ֵ�����ڼ�С
				temp-=left;
				++left;
			}
			else {
//				ǡ����ȣ����󴰿ڽ�ȡ���Ҵ���
				ArrayList<Integer>list=new ArrayList<Integer>();
				for(int k=left;k<right;k++) list.add(k);
				lists.add(list);
//				������С������
				temp-=left;
				++left;
			}
		}
		return lists;
	}
}
//    public ArrayList<ArrayList<Integer>> test(int sum) {
//    	ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
////    	��Ϊ������������һ�����
//        for(int i=1;i<sum/2+1;i++) {
////        	�ӵ�һ��ָ�뿪ʼ��temp����sum��ֵ��temp�Լ�j�����temp����0����˵���������ǰ��ĳ��������Ҫ�����
//        	for(int j=i,temp=sum;temp>=0;j++) {
//        		temp-=j;
////        		System.out.println(temp+"+"+j);
//        		if(temp==0) {
////        			��ʱ���½����飬�����ڴ濪��
//        			ArrayList<Integer> list=new ArrayList<Integer>();
////        			�ӵ�ǰ����ʼ��ǰ������j,j-1,j-2������tempsum��Ϊ��־,ע��forѭ�����ص�
////        			�������д��tempsum>sum,���һ��ʹ�������������ĵ���������ӽ���������������жϣ������Ѿ�����
////        			����������ж�����Ҫ�ر�����
////        			����һ�����ǣ���j-depth<0���ڶ����жϻ�����������Ҫ��һ������0���ж�
//        			for(int tempsum=0,depth=0;(j-depth)>0&&tempsum+(j-depth)<=sum;depth++) {
//        				tempsum+=(j-depth);
//        				list.add(j-depth);
//        			}
//        			if(list.size()>1&&(!lists.contains(list))) {
////        				����Ҳ����ֱ����list��sort
//        				Collections.reverse(list);
//        				lists.add(list);
//        			}
//        		}
//        	}
//        }
//        return lists;
//    }

