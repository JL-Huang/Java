package ��ָoffer;
//������һ��m�к�n�еķ���
//һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
//���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
//���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19��
//���ʸû������ܹ��ﵽ���ٸ����ӣ�
public class movingCount {
    public int test(int threshold, int rows, int cols)
    {
        boolean[][] flag=new boolean[rows][cols];
        return recur(rows, cols, 0, 0, flag, threshold);
    }
//	˼·��haspathһģһ�������ǻ���
//	��ס��������ͻ�����סģʽ�ˣ�rows��cols�̶�����
//	row��col��¼ÿ������������boolean[][]��¼�����߹�
//	limit����ĿҪ��ķ�Χ
//  ��������ֵ�ܹؼ�������Ҫ�����·�������ͷ���int
    public int recur(int rows, int cols, int row,int col,boolean[][] flag,int limit) {
    	if(row<0||col<0||row>=rows||col>=cols||flag[row][col]||sum(row)+sum(col)>limit) return 0;
//    	ͬ��,�߹��˾ͱ��Ϊtrue
    	flag[row][col]=true;
//    	���Ľ����ǰ���������ߵ�·��+��ǰ�ڵ��1
    	return(recur(rows, cols, row+1, col, flag, limit)+
    			recur(rows, cols, row-1, col, flag, limit)+
    			recur(rows, cols, row, col+1, flag, limit)+
    			recur(rows, cols, row, col-1, flag, limit)+1);
    }
    int sum(int input) {
    	return input%10+input/10;
    }
}
