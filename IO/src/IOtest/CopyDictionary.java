package IOtest;
//����ճ���ļ��м���������
//�޷����ļ��зŽ�IO����IO��ֻ����ָ���ļ������Է���һ�㹦��
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
//		�����·�����ļ�������һ�ݵ�Ŀ���ַ
		if(file1.isFile()) {
			copy(cd,pd);			
			}
//		�����·�����ļ��У�����Ŀ���ַ�½�һ���ļ���
		else {
			file2.mkdir();
//			�Ը��ļ��н��б�����Ȼ��ݹ飬���Ƶ�ַ������������ļ��ĵ�ַ��ճ����ַ��Ϊ��ǰĿ�ĵ�ַ��\\�ļ���
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
