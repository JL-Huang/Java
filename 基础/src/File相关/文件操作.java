package File相关;

import java.io.File;
import java.io.IOException;


public class 文件操作 {
public static void main(String[] args) throws IOException {
//	项目路径
	System.out.println(System.getProperty("user.dir"));
//	创建一个文件类，注意此时并没有生成实际文件
	File f=new File("f.txt");
	f.renameTo(new File("ff.txt"));
//	 创建一个实打实的新文件，注意是在project的根目录下产生，不是在src更不是在包中
	f.createNewFile();
	System.out.println(f.exists());
	System.out.println(f.length());
	File ff=new File("F:\\QQ\\1783588388\\FileRecv");
	PrintFiles(ff,0);
}
static void PrintFiles(File file,int level) {
	for(int temp=0;temp<level;temp++) {
		System.out.print("-");
	}
	System.out.println(file.getName());
//	 判断是否是文件夹,是的话层数加一
	if(file.isDirectory()){
	level++;
//	列出所有文件，并存储到fl数组中
	File[] fl=file.listFiles();
//	对数组中所有元素进行递归操作
	for(File temp:fl) {
		PrintFiles(temp,level);
	}
	}
}
}
