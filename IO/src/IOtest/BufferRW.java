package IOtest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferRW {
public static void main(String[] args) {
	File file=new File("abc.txt");
	try {
//		注意的是，这里不要发生多态，因为BufferedReader有父类Reader没有的方法
		BufferedReader is=new BufferedReader(new FileReader(file));
		String line=null;
//		char[] chars=new char[1024];
//		输出一行的数据，直到换行符
		while((line=is.readLine())!=null){
			System.out.println(line);
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
	
	try {
		BufferedWriter os=new BufferedWriter(new FileWriter(file,true));
//		加换行符另起一行
		os.newLine();
		os.append("dhas");
		os.flush();
		os.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
