package IOtest;

import java.io.File;
import java.util.List;
import java.util.ListResourceBundle;

public class APItest {
	long l;
public static void main(String[] args) {
	File file1=new File("F:\\JAVA\\practice\\IOtest/folder1/test1");
//	mkdir()������ǰ·�������ļ��У�����һ��Ŀ¼������������
//	Boolean flag=file1.mkdir();
//	System.out.println(flag);
//	mkdirs(),����һ��Ŀ¼������Ҳһ�𴴽�
//	Boolean flag=file1.mkdirs();
//	System.out.println(flag);
	
//	�������ļ�
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
//	list()���г�������һ���ļ����ƣ�����String[]����
	String[] strs=file.list();
	for(String str:strs) {
		System.out.println(str);
	}
//	listFiles(),���������һ���ļ�������File[]����
	File[] files=file.listFiles();
	for(File temp:files) {
		System.out.println(temp.getAbsolutePath());
	}

}
//listRoots(),����̷�
public void getpan(File file) {
	File[] files=file.listRoots();
	for(File temp:files) {
	System.out.println(temp.getAbsolutePath());
	}
}
//�ļ��б����ӷ����ļ���С
public  void printname(File file,int deep) {
	for(int i=0;i<deep;i++) {
	System.out.print("-");
	}
	System.out.println(file.getName()+"\t"+"�ļ���С"+file.length());
	if(file==null||!file.exists()) {
		return;
	}else {
//		�ж��Ƿ�Ϊ�ļ��У��������������
		if(file.isDirectory()) {
		for(File temp:file.listFiles()) {
			printname(temp,deep+1);		
		}
		}
	}
}
// �����ļ��л��ļ���С
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
