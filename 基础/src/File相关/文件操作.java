package File���;

import java.io.File;
import java.io.IOException;


public class �ļ����� {
public static void main(String[] args) throws IOException {
//	��Ŀ·��
	System.out.println(System.getProperty("user.dir"));
//	����һ���ļ��࣬ע���ʱ��û������ʵ���ļ�
	File f=new File("f.txt");
	f.renameTo(new File("ff.txt"));
//	 ����һ��ʵ��ʵ�����ļ���ע������project�ĸ�Ŀ¼�²�����������src�������ڰ���
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
//	 �ж��Ƿ����ļ���,�ǵĻ�������һ
	if(file.isDirectory()){
	level++;
//	�г������ļ������洢��fl������
	File[] fl=file.listFiles();
//	������������Ԫ�ؽ��еݹ����
	for(File temp:fl) {
		PrintFiles(temp,level);
	}
	}
}
}
