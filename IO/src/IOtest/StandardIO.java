package IOtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StandardIO {
public static void main(String[] args) {
	File file1=new File("abc.txt");
	File file2=new File("abcd.txt");
	try {
		InputStream is=new FileInputStream(file1);
		OutputStream os=new FileOutputStream(file2);
//		byte[] bytes1=new byte[3];
//		String str = null;
//		int i;
//		while((i=is.read(bytes1,0,bytes1.length))!=-1) {
//			str=new String(bytes1, 0, bytes1.length);
//		}
//		byte[] bytes2=str.getBytes();
//		int o=2;	//��Ϊo��д�뵽�ļ���
//		for(int temp=0;temp<o;temp++) {
//			os.write(bytes2, 0, bytes2.length/o);
//		}
		byte[] bytes=new byte[3];
		int len;
		while((len=is.read(bytes))!=-1) {
//			�����ǱȽ��м��ɵ�һ���ط���д�볤��Ϊlen��֤�˲���3�ı���ʱ������ȷд��
//			���򵱳��Ȳ���3�ı���ʱ�����ظ����һ���ַ�
			os.write(bytes,0,len);
		}os.flush();
//		�Ȳ���������ر�
		os.close();
		is.close();

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
