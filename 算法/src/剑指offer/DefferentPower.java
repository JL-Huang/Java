package ��ָoffer;
//����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
public class DefferentPower {
	public static void main(String[] args) {
		DefferentPower defferentPower=new DefferentPower();
		System.out.println(defferentPower.test2(2.0,3));
	}
//	��Ϊ��ʹ�ÿ⺯������������ֻ���۳�
//	ֱ���۳�ʱ�临�Ӷ�O(n),Ҫע��ϸ��
//	���ȵ�����Ϊ0ָ������������
//	Ȼ��double����ֵ�жϣ�double a=1.00,a==1����true��double b=1.01,a==1����false
    public double test1(double base, int exponent) {
        if(base==0) {
        	if(exponent<=0) throw new RuntimeException("��ĸ����Ϊ0");
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
//    ��Ȼ�����ֶ�ʵ�������㣬��õķ������Ƕ��֣��ܰ�ʱ�临�ӶȽ���O(logn)
//    ���Ƕ���ϸ��Ҫע��һ��ϸ�ھ��Ƕ��ֽ�����������Զ�����ȡ��
    double result=1;
    public double test2(double base, int exponent) {
        if(base==0) {
        	if(exponent<=0) throw new RuntimeException("��ĸ����Ϊ0");
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
