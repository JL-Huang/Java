package IOtest;
//�����������ļ��ϵ��������뵽�ڴ棬���������췽���Ĳ������ǵ��ļ�
//��������read()��������ָ�������������ݣ��൱�ڼ�Ӷ��ļ�������
//����������ڴ������һ���ļ����������д���ǰ���������ڴ棩������д���ļ���
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class StandardIS {
public static void main(String[] args) {
	File file=new File("abc.txt");
//	InputStream��һ�������࣬������дread()�����������ļ�����ʵ����ΪFileInputStream
//Ҫע����ǣ��������try������ø���������trycatchǰһ��Ҫ������is������try��ʵ����
		try {
//			�ļ���������ȻҪ�׳��쳣�����Ҳ����ļ��쳣
			InputStream is=new FileInputStream(file);
//			�������һ���ֽڣ��ٶ���һ�������-1
//		��API�ĵ��ŷ���һ�����飬�������������ǲ�����������ȡ�����������ġ�����֮��������֮ǰӰ�죬��������������
//	�������������ǲ���ȷ�ġ�ÿһ��ִ��read()���������Ὣһ������������read()�����Ĳ�������������b��ֻҪִ����
//	read()�������ͻ��b��ȡ��ǰ������λ�ã�Ȼ�����һ�����ٸ���b��ֵ������read()���м���ġ�����������ͬ��������
//	����ǰ���ݣ�����a����a��Ϊ-1������ǰ���ݴ���b�����b����������ȫ��ͬ��
//			while(is.read()!=-1) {
//			read()��������ֵ��int��Ҫǿת���ܱ�Ϊchar
//				System.out.println(is.read());
//			}
//			read()��������ֵ��int��Ҫǿת���ܱ�Ϊchar
//			read()����Ҳһ��Ҫ�׳��쳣����IO�����쳣
			System.out.println((char)is.read());
//			System.out.println(is.read(new byte[4]));ֱ���������ص��ǻ�����������,����Ҫ����������ת������Ӧ����
			byte[] bytes=new byte[3];	//����һ��������,1024����1kb
//			�������������Ϳ�������whileѭ����������Ϊ���м�����bytes
			int j;
			while((j=is.read(bytes))!=-1) {			//��ȡ�������ȵ����ݣ�Ȼ�����������
//				ע�����ƫ��������ָд��bytesʱ��bytes�ĸ��ط���ʼ������Ŀ�ĵص�ƫ��
				String str=new String(bytes,0,j);	//�������������ת�����ַ���,�ɳ��󵽾��壬�������
				System.out.print(str);
			}
//	���һ��Ҫ�ر����������ر�ʱҲҪ�׳��쳣���׳����쳣��checkedException
//	�������ﻹ���ܳ���RutimeException��Ҫ�ֶ�����
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


	
}
}
