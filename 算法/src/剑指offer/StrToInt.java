package ��ָoffer;
//��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
//����
//+2147483647
//1a33
//���
//2147483647
//0
public class StrToInt {
	public static void main(String[] args) {
		StrToInt strToInt=new StrToInt();
		System.out.println(strToInt.test("123"));
		
	}
    public int test(String str) {
//    	ASCII�������������λת����int����10��count-1�η�
    	if(str==null||str.length()==0) return 0;
    	int result=0;
    	int count=1;
//    	ע��ӵ�λ��ʼ����Ϊ��һλ������Ƚϸ��ӣ�֮���ٴ���
        for(int i=str.length()-1;i>0;i--) {
        	if(str.charAt(i)>=48&&str.charAt(i)<=57)
        	result=result+(str.charAt(i)-48)*count;
        	else return 0;
        	count*=10;
        }
        if(str.charAt(0)=='+') return result;
        if(str.charAt(0)=='-') return result*(-1);
        if(str.charAt(0)>=48&&str.charAt(0)<=57) return result+(str.charAt(0)-48)*count;
        return 0;
        }
    }
