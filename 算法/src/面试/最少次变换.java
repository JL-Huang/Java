package ����;
//����һ��m��n�е�����(����)grid��һ������x����ÿ�β������Զ����е�����Ԫ�����ӻ��߼���x����������ִ�м��β������԰������ɵ�ֵ��(����Ԫ��ֵ��һ��)����������ܣ�����-1��
//        ���ݷ�Χ: m = grid.size(), n = grid[.].size()��
//        1 <= m , n <= 100000
//        1 <= m * n <= 100000
//        1 <= x , grid[.][.] <= 10000
//        ���磺����grid[][] = {{2, 4}, {6, 8}}, x = 2
//        ���4��
//        ��Ϊ���Զ���Ϊ4������2��Ҫ����1�Σ�4��Ҫ����0�Σ�6��Ҫ����1�Σ�8��Ҫ����2�Ρ�
//        ���߿��Զ���Ϊ6�� ����2��Ҫ����2�Σ�4��Ҫ����1�Σ�6��Ҫ����0�Σ�8��Ҫ����1�Ρ�

import java.lang.reflect.Array;
import java.util.Arrays;

//˼·������н�Ļ����ǿ϶��Ǳ�ɾ����е�ĳ�����֣���������ÿ�����ֱ任����һ����x��������n1,n2����
//ÿ������xȡģ����ÿ������ʾΪmx+a����ô���ձ任�Ľ������(m+n)x+a,Ҳ����˵����н�������aһ������ͬ��
//���Ʋ⣬����н������£�һ���ǰ�����������ɾ����е�ĳһ��������m+n��ȡֵ�ǿ�����ٵ�
//Ŀ������n�ľ���ֵ֮����С
//����ͱ���������ϴ���֪��ѡ��һ���㣬ʹ����������֪�ĸ��������֮����С
//����ѧ�Ͽ϶���ѡ���м�ĵ�
public class ���ٴα任 {
    public static void main(String[] args) {
        int[][] grid={{1, 3}, {5, 19}};
        int x=2;
        System.out.println(���ٴα任.test(grid,x));
    }
    private static int test(int[][] grid, int x) {
        int a = grid[0][0] % x;
        int[] m = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] % x != a) {
//                    a���ȣ�ֱ�ӷ���-1��
                    return -1;
                }
//                ������m������
                m[j + i * grid[0].length] = grid[i][j] / x;
            }
        }
//        ��һ����
        Arrays.sort(m);
        int result_1 = 0, result_2 = 0;
//        ȡ�м�������㵽�������ľ���ֵ
        for (int i = 0; i < m.length; i++) {
            result_1 += Math.abs(m[m.length / 2] - m[i]);
            result_2 += Math.abs(m[m.length / 2] - m[i]);
        }
        return result_1 > result_2 ? result_2 : result_1;
    }
}
