package 剑指offer;

public class JunpFloor {
//	一次只能跳一或二级
//	跳最后一级时只能由其前面一级或前面二级跳上来
    public int JumpFloortest1(int target) {
        if(target==1) return 1;
        if(target==2) return 2;
        return JumpFloortest1(target-1)+JumpFloortest1(target-2);
    }
//    一次能跳n级
//    跳最后一级能从前面所有级跳上来，所以是f(1)+……+f(n-2)+f(n-1)
//    f(n-1)=f(1)+……+f(n-2)
    public int JumpFloortest2(int target) {
        if(target==1) return 1;
        return 2*JumpFloortest2(target-1);
    }
}
