package ��ָoffer;

public class JunpFloor {
//	һ��ֻ����һ�����
//	�����һ��ʱֻ������ǰ��һ����ǰ�����������
    public int JumpFloortest1(int target) {
        if(target==1) return 1;
        if(target==2) return 2;
        return JumpFloortest1(target-1)+JumpFloortest1(target-2);
    }
//    һ������n��
//    �����һ���ܴ�ǰ�����м���������������f(1)+����+f(n-2)+f(n-1)
//    f(n-1)=f(1)+����+f(n-2)
    public int JumpFloortest2(int target) {
        if(target==1) return 1;
        return 2*JumpFloortest2(target-1);
    }
}