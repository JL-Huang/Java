package 剑指offer;

import java.util.ArrayList;

import Tree.TreeNode;

//输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
//路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
public class FindPath {
	ArrayList<ArrayList<Integer>> listall=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list=new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> test(TreeNode root,int target) {
        if(root==null) return listall;
        list.add(root.val);
        target-=root.val;
//        这里注意，必须新生成一个list对象来保存当前list，不然按照后面的代码list会被修改
//        list每次访问完左右子树就回退，最后必然为空
        if(target==0&&root.left==null&root.right==null) listall.add(new ArrayList<Integer>(list));
        test(root.left,target);
        test(root.right,target);
//        每次访问完左右子树，加上了叶子节点，就要回退，删除最后的叶子节点，不然会导致根-左-左叶子-右叶子这样的list
//        这个丢弃十分关键，当一个节点左右孩子都return之后就会删除当前节点，所以要摆在最后
        list.remove(list.size()-1);
//        这个return对非根节点完全就是为了满足编译要求，因为返回值不会被保存
        return listall;
    }
}
