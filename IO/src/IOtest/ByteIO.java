package IOtest;
//�ֽ���������ֱ�Ӷ��ڴ��������GC�����ڴ��������Ҫclose
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteIO {
public static void main(String[] args) {
	System.out.println(ByteI());
//	����Ĵ���������ַ��ԭ���Ƿ��ص���д�õ��ֽ����飬��û�о�������
	System.out.println(ByteO());
//	String���췽����ƫ�����볤�ȣ���ԵĶ����ֽ�����������ַ���
	System.out.println(new String(ByteO(),0,ByteO().length-4));
}
public static StringBuffer ByteI() {
	String str="caahszxchz";
	StringBuffer sb=new StringBuffer();
	byte[] bytes1=str.getBytes();	//����Ҫ��ȡ������
	ByteArrayInputStream is=new ByteArrayInputStream(bytes1);	//�ֽ��������Լ��乹�췽��
	try {
		int i=-1;
		byte[] temp=new byte[2];
		while((i=is.read(temp))!=-1) {
			sb.append(new String(temp, 0,i));
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sb;
}
public static byte[] ByteO() {
//	�ֽ������д���ֽ�Դ�����Ȳ��ð��գ�������ϵͳ���в���Դ
//	���ﲻ����OutputStream����ΪByteArrayOutputStream()��������������ʵ�ֶ�̬
	ByteArrayOutputStream os=new ByteArrayOutputStream();
	String str="ahauhaschacuh";
	try {
		os.write(str.getBytes());
		os.flush();			//�κ������д���Ҫflush���������������������ȫ��ˢ�³�ȥ

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	���ֽ������д�õ��������ʹ�õ����ֽ��������toByteArray()����
	return os.toByteArray();	
}
}