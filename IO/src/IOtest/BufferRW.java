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
//		ע����ǣ����ﲻҪ������̬����ΪBufferedReader�и���Readerû�еķ���
		BufferedReader is=new BufferedReader(new FileReader(file));
		String line=null;
//		char[] chars=new char[1024];
//		���һ�е����ݣ�ֱ�����з�
		while((line=is.readLine())!=null){
			System.out.println(line);
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
	
	try {
		BufferedWriter os=new BufferedWriter(new FileWriter(file,true));
//		�ӻ��з�����һ��
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
