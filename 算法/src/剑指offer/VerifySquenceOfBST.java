package 剑指offer;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class VerifySquenceOfBST {
	public static void main(String[] args) {
		int[] sequence= {4,8,6,12,16,14,10};
		System.out.println(new VerifySquenceOfBST().test(sequence));
	}
	boolean flag=true;
//	判断一个数组是否是后序遍历
//	根据左右中的规则，最后一个数一定是根节点，保持原数组不变，截取范围递归判断
//	自己写的时候想着直接截取数组，发现数组的复制非常麻烦，遂放弃
//	截取范围的话，终止递归的条件与截取数组有所不同
//	注意参数传入的直接就是下标
	public boolean judge(int [] sequence,int left,int right) {
//		if(sequence==null) return true;
//		if(sequence.length==0) return true;
//		int root=sequence[sequence.length-1];错误
		if(left>right) return true;
		int root=sequence[right];
		int i=left;
//		经过一番操作，i已经是左子树长度
		for(;sequence[i]<root;i++) {}	
//		这里直接就是i不是i+1
		for(int j=i;j<right;j++) {if(sequence[j]<root) return false;}	
		return judge(sequence, left, i-1)&&judge(sequence, i, right-1);
	}
    public boolean test(int [] sequence) {
        if(sequence==null) return false;
        if(sequence.length==0) return false;
        return judge(sequence, 0, sequence.length-1);
    }
}
