package IOtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StandardOS {
public static void main(String[] args) {
	File file=new File("abc.txt");
	try {
//		true��ʾ��������ļ��Ĳ�����׷�Ӷ����������Ĭ����false���
//		���û������ļ����Զ�����
		OutputStream os=new FileOutputStream(file,true);
		String str="hjl";
		byte[] bytes=str.getBytes();	//���嵽���󣬱������
//		os.write(bytes);
//		��������д�����ã���һ���������ֽ����飬�ڶ���������ƫ������ע��ƫ���볤��������ַ�����������ֽ�
//		��������д�볤�ȣ�ע��ȫд�Ļ����ü�һ������ƫ�ƣ�Ȼ��Ӹ��꿪ʼ���ָ�����ȵ��ַ���
//		���jl��˵��ȷʵ�Ƕ��ַ������������Ƕ��ֽ��������Ӧ�������hj��
		os.write(bytes, 1, bytes.length-1);
//		flush()ˢ����������������������ݱ�д����һ�㶼����һ��
		os.flush();
		if(os!=null) {
			os.close();			
		}

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
