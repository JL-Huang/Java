package ���ڵ����.����ģʽ;

public class StaticInnerClass {
	public static void main(String[] args) {
		StaticInnerClass staticInnerClass=StaticInnerClass.getinstance();
	}
	private StaticInnerClass() {}
//	����ʱ������ⲿ�࣬�����ڲ��಻�ᱻ���أ��ڲ�����new��ʱ��ſ�ʼ���ص�
	private static class Inner {
//	���ַ����ô����ڣ����ⲿ�౻����ʱ�������ϼ����ڲ��࣬��getinstance�ŻῪʼ�����ڲ��࣬�������ڲ����κ�������
//	����±�֤�̰߳�ȫ����Ϊ����߳�ͬʱȥ��ʼ��һ���ֻ࣬��һ���ᱻִ�У������߳�����������ֻ�ᱻ��ʼ��һ��
//	ע���ʼ����ͬ�ڴ�������������ļ���ʱ�Ĳ���
//	����Ҳ�в��õĵط�,����getinstance�����������
		private static StaticInnerClass instance=new StaticInnerClass();
	}
//	ע�⣬�ⲿ���޷�ֱ�ӵ����ڲ���ĳ�Ա��������Ϊ��̬����ͨ����������
	public static StaticInnerClass getinstance() {
		return Inner.instance;
	}
}
