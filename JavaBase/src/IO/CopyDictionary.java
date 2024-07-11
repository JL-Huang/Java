package IO;
//复制粘贴文件夹及里面内容
//无法将文件夹放进IO流，IO流只能是指向文件，所以废了一点功夫
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDictionary {
public static void main(String[] args) {
	m("F:\\JAVA\\practice\\IOtest","F:\\JAVA\\practice\\h");
}
public  static void m(String cd,String pd) {
	File file1=new File(cd);
	File file2=new File(pd);
	if(file1==null||!file1.exists()) {
		return;
	}else {
//		如果该路径是文件，则复制一份到目标地址
		if(file1.isFile()) {
			copy(cd,pd);			
			}
//		如果该路径是文件夹，则在目标地址新建一个文件夹
		else {
			file2.mkdir();
//			对该文件夹进行遍历，然后递归，复制地址变成所遍历到文件的地址，粘贴地址变为当前目的地址加\\文件名
			for(File temp:file1.listFiles()) {
				m(temp.getAbsolutePath(),file2.getAbsolutePath()+"\\"+temp.getName());
			}
		}
		}
	}


public static void copy(String cd,String pd) {
	File file1=new File(cd);
	File file2=new File(pd);

	try {
		InputStream is=new FileInputStream(file1);
		OutputStream os=new FileOutputStream(file2);
		byte[] bytes=new byte[1024];
		int temp;
		while((temp=is.read(bytes))!=-1) {
			os.write(bytes, 0, temp);
		}os.flush();
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
