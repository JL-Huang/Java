package Exception���;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//							Throwable
//		Error									Exception
//	UncheckedException			checkedException		RutimeException
//															UncheckedException
//RutimeException:��ָ���쳣��������������±�Խ��ȣ�����ʱ�����
//JVMû�й̶��Ĵ�������������Ҫ�Լ�����߼��жϣ���ָ��Ϊ��������������Ϊ0�������ȵ�
//checkedException���Ѿ�����������鵽���쳣��������Ѿ�����
public class �쳣 {
	public static void main(String[] args) {
		
		
	Animal a=new Dog();
//	�ж�a�Ƿ���Cat��
	if(a instanceof Cat) {
		Cat c=(Cat)a;
	}
	TryTest.hhh();
	}
}
//try����п����ж������룬ִ�й���������һ�����������׳�һ���쳣�������Ӧ��catch���
//	һ��try�������Ҫ��һ��catch�����һ��finally����
//	û���쳣���쳣������󣬶�������finally��䣬����ִ��try�е����
//	catch��toString()��ʾ�쳣����,getMessage()��ʾ�쳣ԭ��,printStackTrace()�����쳣�¼�����ʱ��ջ���ݵȳ��÷���
//	�쳣���м̳й�ϵʱ�������ǰ��
//	finally������ִ����û���쳣��Ҫִ�е���䣬��ر��ļ������ͷ����ݿ�����]
	
//	FileReader��InputStream������
	class TryTest{
//		ע��һ��Ҫ�Ѹ÷�������Ϊ��̬������main�����޷�����
		 static public void hhh() {
		FileReader reader=null;
		File f1=new File("f.txt");
		try {
		reader=new FileReader(f1);
		while(reader.read()!=-1) {
//			 ����ÿ�ζ����������ӵڶ�����ʼ��λ������
		char c1=(char)reader.read();
		System.out.println(c1);
		}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�Ҳ����ļ�");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("��ȡ����");
		}
				finally {
			System.out.println("�ͷ���Դ");
			try {
				if(reader!=null)
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}
	
	
//	throws��ֱ�Ӱ��쳣�׳���˭����˭����
//	throws�ڷ���֮���������׳��ľ���catch�����ڵ����ݣ���throws IOException;
//	Ҫע����ǣ�һ��throws���Ժ󣬵��ø÷����ķ�������Ҳthrows����trycatch
//	����һ���throws�����main������throws�׳���JRE
class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}