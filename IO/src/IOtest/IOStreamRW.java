package IOtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;

//转换流：InputStreamReader与OutputStreamWritter
//1.将字节流转换为字符流
//2.指定字符集
public class IOStreamRW {
public static void main(String[] args) {
//	System.in是字节输入流，作为isr1构造方法的参数产生字符流对象，然后加Buffer提高效率
//	InputStreamReader isr=new InputStreamReader(System.in);
	test();
	test1();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	String str="";
	while(!br.equals("hhh")) {
		try {
			str=br.readLine();
			bw.write(str);
//			加了这行，以后的输出会自动换到输出的下一行
			bw.newLine();
//			注意，这里是一定要flush，因为输入内容是存到br这个缓冲流，不强制刷新会直到存满才输出
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
public static void test() {
	try {
//		URL对象的openStream()方法可以创建一个字节输入流
//		isr的构造方法还可以放一个参数，就是字节输入流转换为字符流的编码解码方式
//		这里先注释掉了，会经常弹出太烦人
		
		InputStreamReader isr=new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8");
		BufferedReader bf=new BufferedReader(isr);
		String str="";
		while((str=bf.readLine())!=null) {
			System.out.println(str);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static void test1() {
	try {
//		创建输出流，同样是把字节流变成字符流
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(new File("baidu.txt")),"UTF-8");
		BufferedWriter bw=new BufferedWriter(osw);
//		指定输出内容
		String str="hdash";
		bw.write(str);
//		同样需要flush
		bw.flush();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
