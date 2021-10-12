package IOtest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//������	��Ĭ��8kb
public class BufferIO {
public static void main(String[] args) {
	File file=new File("abc.txt");

	try {
//		InputStream is=new FileInputStream(file);
//		������������д����������Ľڵ�����Ϊ���������췽���Ĳ����׽�������
		BufferedInputStream is=new BufferedInputStream(new FileInputStream(file));
		int len=-1;
		byte[] bytes=new byte[1024];
		while((len=is.read(bytes))!=-1){
			System.out.println(new String(bytes,0,len));
		}
//		�����Ƕ�׹رյ�˳��һ����ֱ�ӹر������
		if(is!=null) {			
			is.close();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
