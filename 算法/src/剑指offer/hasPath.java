package ��ָoffer;

//�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
//·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
//���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� 
//����
//	a	b	c	e
//	s	f	c	s
//	a	d	e	e
//�����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
//��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
public class hasPath {
//	���Ǻܾ���Ļ���
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    	boolean[] flag=new boolean[matrix.length];
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
//    			��ÿһ���㣬�����ܷ�����Ϊ��������Ŀ���ַ���
    			if(recur(matrix, rows, cols, str, i, j, flag,0)) return true;
    		}
    	}
    	return false;
    }
//    ����ݹ�Ҫ������ǣ����ڸ��������һ���㣬�ݹ鳢���ܷ������������Ŀ���ַ���
//    ��ؼ��Ĳ�����k��k��¼���Ǳ���Ŀ���ַ����ĵ�ǰ�±�
//    flag��¼����ÿ��������û�б��߹����߹�Ϊfalse��û�߹�Ϊfalse��һ������������Ϊ��ֵ����false
	public boolean recur(char[] matrix, int rows, int cols, char[] str,int row,int col,boolean[] flag,int k) {
//		index��¼�ĵ�ǰ����
		int index=row*cols+col;
//		���Խ���ˣ����ߵ�ǰ�����Ѿ��߹��ˣ����ߵ�ǰ���Ӹ���Ҫ��Ŀ���ַ���ͬ������false
		if(row<0||col<0||row>=rows||col>=cols||flag[index]||matrix[index]!=str[k]) return false;
//		k==str.length-1����ζ�ű��������һ���ַ���û�в�����Է���true��
		if(k==str.length-1) return true;
//		�������˵�ǰ���ӣ���Ҫ��������ӱ��
		flag[index]=true;
//		Ȼ��������������εݹ飬ע��k+1
		if(recur(matrix, rows, cols, str, row, col+1, flag,k+1)||
			recur(matrix, rows, cols, str, row+1, col, flag,k+1)||
			recur(matrix, rows, cols, str, row-1, col, flag,k+1)||
			recur(matrix, rows, cols, str, row, col-1, flag,k+1)) return true;
//		����û�з��أ�˵����������ûһ�������ˣ���ǰ·���Ƿ���
//		Ȼ���Ҫ��flag���false����Ϊ���ֻ��һ��·���ڱ�ǣ��������ݰ��������˵�·�������е㶼��Ƕ�����
		flag[index]=false;
		return false;
	}
}