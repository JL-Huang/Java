 package IOtest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

//DataInputStream,DataOutputStream
//���췽������Ϊһ���ֽ���,���������еĶ�д�������Խ���ͬ���͵����ݷֱ�洢
//���ǽ�֧�ְ����������ͺ��ַ���
//�岥һ�������������������Էֱ�洢�κ�������ݣ���ǰ���Ǹ���ʵ����java.io.Serializable�ӿ�
//������д��һ��dos.writeObject������дʱû���⣬���Ƕ�ȡʱҪǿת
//�ж��ǲ���ĳ�����ͣ���instanceof���������ز�������
public class DataStream {
public static void main(String[] args) {
	// ��д��һ���ֽ������

	try {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
//		�κ�����ʵ����ʱ����ָ���������Ŀ�����
		DataOutputStream dos=new DataOutputStream(baos);
		dos.writeUTF("������");
		dos.writeInt(7);
		dos.write(6);
		dos.flush();
		byte[] bytes=baos.toByteArray();
		ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
		DataInputStream dis=new DataInputStream(bais);
//		ע����ǣ����˳��Ҫ��ȡ��˳��һģһ��������ᱨ��
		String s=dis.readUTF();
		int i=dis.readInt();
		System.out.println(i);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
