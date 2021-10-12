package IOtest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//���ļ������ֽ����Խӣ�ʵ���ļ�ת��Ϊ�ֽ����飬�ٰ��ֽ�����ת��Ϊ�ļ���һ���ǳ�
public class pack {
public static void main(String[] args) throws IOException {
//	byte[] b=FtoB("F:\\JAVA\\practice\\IOsrc\\hhh.bmp");
//	System.out.println(b.length);
//	BtoF(b,"F:\\JAVA\\practice\\IOsrc\\jjj.bmp");
	
	String InFilepath ="F:\\JAVA\\practice\\IOsrc\\hhh.bmp";
	InputStream iis=new FileInputStream(new File(InFilepath));
	ByteArrayOutputStream baos =new ByteArrayOutputStream();
	FtoB(iis,baos);
//	toByteArray��ȡ�ֽ������������
	byte[] bb=baos.toByteArray();
	String OutputFilepath = "F:\\JAVA\\practice\\IOsrc\\jjj.bmp";
	ByteArrayInputStream bais=new ByteArrayInputStream(bb);
	OutputStream ios=new FileOutputStream(new File(OutputFilepath));
	BtoF(bais,ios);
}
public static byte[] FtoB(InputStream is,ByteArrayOutputStream baos) {
	try {
		byte[] bottle=new byte[1024*10];
		int i=-1;
		while((i=is.read(bottle))!=-1) {
			baos.write(bottle, 0, i);
		}
		if(is!=null) {
			closeIS(is);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return baos.toByteArray();
}
public static void BtoF(ByteArrayInputStream bais,OutputStream os) {
	try {
		
		byte[] bottle=new byte[1024*10];
		int i=-1;
		while((i=bais.read(bottle))!=-1) {
			os.write(bottle, 0, i);
		}
		if(os!=null) {
			closeOS(os);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
public static void closeOS(OutputStream os) {
	try {
	if(os!=null) {
		os.close();
	}
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//JDK9֮���еķ���������Ҫ�ֶ�close��try������һ��IO����
public static void newcloseOS(OutputStream os) {
	
	try(os;/*is*/) {
	if(os!=null) {
//		os.close();
	}
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void closeIS(InputStream is) {
	try {
	if(is!=null) {
		is.close();
	}
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//�����е�ѽ⣬Closeable��һ���ӿڣ�ΪɶҲ�ж���
//�����Ҷ��ˣ�ʵ�ʵ���ʱ������βζ����ʵ��Ӧ����һ���ӿ�ʵ�������
public static void closeIO(Closeable...ios) {
	for(Closeable io:ios) {
		try {
			if(io!=null) {
				io.close();
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
}
