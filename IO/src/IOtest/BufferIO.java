package IOtest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//缓冲流	，默认8kb
public class BufferIO {
public static void main(String[] args) {
	File file=new File("abc.txt");

	try {
//		InputStream is=new FileInputStream(file);
//		就是以下这种写法。将输入的节点流作为缓冲流构造方法的参数套进缓冲流
		BufferedInputStream is=new BufferedInputStream(new FileInputStream(file));
		int len=-1;
		byte[] bytes=new byte[1024];
		while((len=is.read(bytes))!=-1){
			System.out.println(new String(bytes,0,len));
		}
//		多个流嵌套关闭的顺序一般是直接关闭最外层
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
