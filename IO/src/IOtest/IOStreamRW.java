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

//ת������InputStreamReader��OutputStreamWritter
//1.���ֽ���ת��Ϊ�ַ���
//2.ָ���ַ���
public class IOStreamRW {
public static void main(String[] args) {
//	System.in���ֽ�����������Ϊisr1���췽���Ĳ��������ַ�������Ȼ���Buffer���Ч��
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
//			�������У��Ժ��������Զ������������һ��
			bw.newLine();
//			ע�⣬������һ��Ҫflush����Ϊ���������Ǵ浽br�������������ǿ��ˢ�»�ֱ�����������
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
public static void test() {
	try {
//		URL�����openStream()�������Դ���һ���ֽ�������
//		isr�Ĺ��췽�������Է�һ�������������ֽ�������ת��Ϊ�ַ����ı�����뷽ʽ
//		������ע�͵��ˣ��ᾭ������̫����
		
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
//		�����������ͬ���ǰ��ֽ�������ַ���
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(new File("baidu.txt")),"UTF-8");
		BufferedWriter bw=new BufferedWriter(osw);
//		ָ���������
		String str="hdash";
		bw.write(str);
//		ͬ����Ҫflush
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
