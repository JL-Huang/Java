package ����;

public class ���� {
private volatile static ���� instance;
private ����() {}
public static ���� getInstance() {
//	�����ķ��������Ƚ��е�һ�ηǿ��жϣ�����Ϊ�˼��ٿ�������Ϊ���������ܴ�
	if(instance==null) {
		synchronized (����.class) {
//			����ǿ��ж��Ǳ�֤����
			if(instance==null)
//				volatile�Ƿ�ֹ�����ָ������
//				1.���ٿռ�2.��������3.ָ��ʵ���������ڴ��ַ
//				��ָ������132�������������ǿ��ж϶��ᱻ����
//				��һ���߳�ֱ�ӷ���һ��û��ʵ������instance
				instance=new ����();
		}
	}
	return instance;
}
}
