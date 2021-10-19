package 剑指offer;
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public class DefferentPower {
	public static void main(String[] args) {
		DefferentPower defferentPower=new DefferentPower();
		System.out.println(defferentPower.test2(2.0,3));
	}
//	因为不使用库函数，所以这里只能累乘
//	直接累乘时间复杂度O(n),要注意细节
//	首先当底数为0指数必须是正数
//	然后double类型值判断，double a=1.00,a==1返回true，double b=1.01,a==1返回false
    public double test1(double base, int exponent) {
        if(base==0) {
        	if(exponent<=0) throw new RuntimeException("分母不能为0");
        	else return 0;
        }else {
        	if(exponent==0) return 1;
        	if(exponent>0) {
        		double result=1;
        		for(int i=0;i<exponent;i++) {
        			result=result*base;
        		}
        		return result;
        	}
        	if(exponent<0) {
        		double result=1;
        		for(int i=0;i<-exponent;i++) {
        			result=result*base;
        		}
        		return 1/result;
        	}
        	return 0;
        }
  }
//    当然这种手动实现幂运算，最好的方法还是二分，能把时间复杂度降到O(logn)
//    但是二分细节要注意一个细节就是二分结果非整数会自动向下取整
    double result=1;
    public double test2(double base, int exponent) {
        if(base==0) {
        	if(exponent<=0) throw new RuntimeException("分母不能为0");
        	else return 0;
        }else {
        	if(exponent==0) return 1;
        	double half=test2(base,exponent/2);
        	if(exponent>0) return exponent%2==0?half*half:half*half*base;
        	if(exponent<0) return exponent%2==0?half*half:half*half*1/base;
        }
        return 0;
    }
}
