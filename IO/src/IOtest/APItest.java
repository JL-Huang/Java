package IOtest;

import java.io.File;
import java.util.List;
import java.util.ListResourceBundle;

public class APItest {
	long l;
public static void main(String[] args) {
	File file1=new File("F:\\JAVA\\practice\\IOtest/folder1/test1");
//	mkdir()，按当前路径创建文件夹，若上一级目录不存在则作罢
//	Boolean flag=file1.mkdir();
//	System.out.println(flag);
//	mkdirs(),若上一级目录不存在也一起创建
//	Boolean flag=file1.mkdirs();
//	System.out.println(flag);
	
//	创建新文件
//	try {
//		file1.createNewFile();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	File file2=new File("F:\\JAVA\\practice\\IOtest");
	APItest apitest=new APItest();
	System.out.println(file2.getName());
	apitest.getnext(file2);
	apitest.getpan(file2);
	apitest.printname(file2,0);
	System.out.println(apitest.getlength(file2));
}

public void getnext(File file) {
//	list()，列出所有下一级文件名称，返回String[]对象
	String[] strs=file.list();
	for(String str:strs) {
		System.out.println(str);
	}
//	listFiles(),获得所有下一级文件，返回File[]对象
	File[] files=file.listFiles();
	for(File temp:files) {
		System.out.println(temp.getAbsolutePath());
	}

}
//listRoots(),获得盘符
public void getpan(File file) {
	File[] files=file.listRoots();
	for(File temp:files) {
	System.out.println(temp.getAbsolutePath());
	}
}
//文件夹遍历加返回文件大小
public  void printname(File file,int deep) {
	for(int i=0;i<deep;i++) {
	System.out.print("-");
	}
	System.out.println(file.getName()+"\t"+"文件大小"+file.length());
	if(file==null||!file.exists()) {
		return;
	}else {
//		判断是否为文件夹，若是则继续遍历
		if(file.isDirectory()) {
		for(File temp:file.listFiles()) {
			printname(temp,deep+1);		
		}
		}
	}
}
// 返回文件夹或文件大小
public long getlength(File file) {
	long l = 0;
	if(file!=null&&file.exists()) {
	if(file.isFile()) {
		return file.length();
	}else
		for(File s:file.listFiles()) {
			l=l+getlength(s);
		}
	}	
	return l;
}
}
