package ���ģʽ.����ģʽ;
//����ģʽ������ֻ����һ������
//1.������˽�л�->�����ⲿnew������
//2.�ṩ˽�еľ�̬����->��Ŷ���ĵ�ַ
//3.�ṩ�����ľ�̬����->��ȡ����
public class DoubleCheckedLocking {
//	û�����½�����ʱʵ�������ͽ�����ģʽ
//	˫�ؼ�������˫��ָ���������б��ྲ̬�����Ƿ�Ϊ�գ�һ���Ƿ�ֹ���߳��ظ�������һ���Ƿ�ֹ����Ҫ�ķǿ��жϵȴ�
	//1.������˽�л�->�����ⲿnew������
	private DoubleCheckedLocking() {
	}
	//2.�ṩ˽�еľ�̬����->��Ŷ���ĵ�ַ
	private static volatile DoubleCheckedLocking instance;
	//3.�ṩ�����ľ�̬����->��ȡ����
	public static DoubleCheckedLocking getinstance() {
//		�Ӹ�����Ϊ��ֱ�Ӷ�ȡ���Ƿ�ֹ�����̵߳ȴ�ǰ����߳̽�����������ж�
		if(instance!=null) {
			return instance;
		}
//		�Ӹ��ǿ��ж�,�Ӹ�����ע������Ҳ������instance�ģ���Ϊinstance�Ǿ�̬������Class�����ֻ��һ��instance
			synchronized (DoubleCheckedLocking.class) {
				
				if(instance==null) {
//		�����п��ܷ���ָ�����ţ������ǿ��ٶ���ռ�-��ʼ��������Ϣ-�������ַ�����õ�˳�򣬶��߳�����¿�������
//		��������ִ��instance��д��ִ��instance�Ķ������Ը�instance�Ӹ�volatile
					instance=new DoubleCheckedLocking();
				}
			}
		return instance;
	}

	public static void main(String[] args) {
//		���Կ�����������Ķ����ַһ��
		Thread t1=new Thread(()-> {
			System.out.println(DoubleCheckedLocking.getinstance());
		});
		t1.start();
		System.out.println(DoubleCheckedLocking.getinstance());
	}
}
