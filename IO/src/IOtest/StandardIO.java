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
//		int o=2;	//分为o次写入到文件中
//		for(int temp=0;temp<o;temp++) {
//			os.write(bytes2, 0, bytes2.length/o);
//		}
		byte[] bytes=new byte[3];
		int len;
		while((len=is.read(bytes))!=-1) {
//			这里是比较有技巧的一个地方，写入长度为len保证了不是3的倍数时还能正确写入
//			否则当长度不是3的倍数时，会重复最后一个字符
			os.write(bytes,0,len);
		}os.flush();
//		先操作的流后关闭
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
