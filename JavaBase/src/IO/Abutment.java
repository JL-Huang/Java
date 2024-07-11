package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//将文件流与字节流对接，实现文件转化为字节数组，再把字节数组转化为文件，一气呵成
public class Abutment {
public static void main(String[] args) {
	byte[] b=FtoB("F:\\JAVA\\practice\\IOsrc\\hhh.bmp");
	System.out.println(b.length);
	BtoF(b,"F:\\JAVA\\practice\\IOsrc\\jjj.bmp");
}
public static byte[] FtoB(String InFilepath) {
	File file =new File(InFilepath);
	ByteArrayOutputStream baos = null;
	try {
		InputStream iis=new FileInputStream(file);
		baos=new ByteArrayOutputStream();
		byte[] bottle=new byte[1024*10];
		int i=-1;
		while((i=iis.read(bottle))!=-1) {
			baos.write(bottle, 0, i);
		}
		if(iis!=null) {
			iis.close();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return baos.toByteArray();
}
public static void BtoF(byte[] bb,String OutFilepath) {
	ByteArrayInputStream bais=new ByteArrayInputStream(bb);
	File file=new File(OutFilepath);
	try {
		OutputStream ios=new FileOutputStream(file);
		byte[] bottle=new byte[1024*10];
		int i=-1;
		while((i=bais.read(bottle))!=-1) {
			ios.write(bottle, 0, i);
		}
		if(ios!=null) {
			ios.close();
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
