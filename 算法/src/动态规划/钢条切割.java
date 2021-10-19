package ��̬�滮;

//����һ�γ���ΪnӢ��ĸ�����һ���۸���ά����p,(i=1,2,��,n),
//���и��������,ʹ����������r���
public class �����и� {
    //    �жϵ��������ӽṹ����
//    ÿ���и�ʱ�г������֣���߲����и�ұ߼����ظ�
//    ���Ž���r(n)=max(p(i-1)+r(n-i) 1<=i<=n)
//    ״̬ת�Ʒ���Ϊr(i)=max(p(j-1)+r(i-j) 1<=j<=i) (1<=i<=n)
//    i��ʾ�����ĳ��ȣ�j��ʾ�����и�ĳ��ȣ�r(i)��ʾ�и��i�ĸ��������Ž⣬����r(0)=0;֮������p(i-1)����Ϊp(0)���ǳ���Ϊ1�ļ۸�
    public static void main(String[] args) {
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 25};
        int n = 10;
        System.out.println(recur(price,n));
    }

    private static int recur(int[] price, int n) {
        int[] r = new int[n + 1];
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            r[i] = Integer.MIN_VALUE;
            int temp_max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                temp_max = temp_max > price[j-1] + r[i - j] ? temp_max : price[j-1] + r[i - j];
            }
            r[i] = temp_max;
        }
        return r[n];
    }
}

