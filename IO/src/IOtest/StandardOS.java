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
//		true表示输出流对文件的操作是追加而不是替代，默认是false替代
//		如果没有这个文件会自动创建
		OutputStream os=new FileOutputStream(file,true);
		String str="hjl";
		byte[] bytes=str.getBytes();	//具体到抽象，编码过程
//		os.write(bytes);
//		下面这种写法更好，第一个参数是字节数组，第二个参数是偏移量，注意偏移与长度是针对字符串不是针对字节
//		第三个是写入长度，注意全写的话不用减一，浮标偏移，然后从浮标开始输出指定长度的字符串
//		输出jl，说明确实是对字符串操作（若是对字节数组操作应该是输出hj）
		os.write(bytes, 1, bytes.length-1);
//		flush()刷新输出流，将缓冲容器数据被写出，一般都加这一句
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
