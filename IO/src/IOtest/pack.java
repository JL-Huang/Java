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

//将文件流与字节流对接，实现文件转化为字节数组，再把字节数组转化为文件，一气呵成
public class pack {
public static void main(String[] args) throws IOException {
//	byte[] b=FtoB("F:\\JAVA\\practice\\IOsrc\\hhh.bmp");
//	System.out.println(b.length);
//	BtoF(b,"F:\\JAVA\\practice\\IOsrc\\jjj.bmp");
	
	String InFilepath ="F:\\JAVA\\practice\\IOsrc\\hhh.bmp";
	InputStream iis=new FileInputStream(new File(InFilepath));
	ByteArrayOutputStream baos =new ByteArrayOutputStream();
	FtoB(iis,baos);
//	toByteArray获取字节输出流的内容
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
//JDK9之后有的方法，不需要手动close，try里面列一下IO就行
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
//这里有点费解，Closeable是一个接口，为啥也有对象
//好了我懂了，实际调用时，这个形参对象的实参应该是一个接口实现类对象
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
