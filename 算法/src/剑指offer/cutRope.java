package ��ָoffer;
//����һ������Ϊn�����ӣ�������Ӽ�����������m�Σ�m��n����������n>1����m>1��m<=n����ÿ�����ӵĳ��ȼ�Ϊk[1],...,k[m]��
//����k[1]x...xk[m]���ܵ����˻��Ƕ��٣�
//���磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
public class cutRope {
//	˼·�ܼ򵥣�4�϶��ָ��2*2��5�϶��ָ��2*3��6�϶��ָ��3*3������2*2*2����֮�Ƿָ�������ܶ��3
//	ֻ�е�����Ϊ1���Ű�3*1����2*2
    public int test(int target) {
    	if(target==2) return 1;
    	if(target==3) return 2;
    	if(target%3==0) return (int) Math.pow(3, target/3);
    	if(target%3==1) return (int) (4*Math.pow(3, target/3-1));
    	if(target%3==2) return (int) (2*Math.pow(3, target/3));
    	return 0;
    }
}
