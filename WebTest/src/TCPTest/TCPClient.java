package TCPTest;
import java.io.BufferedReader;
import java.io.DataInputStream;
//�ͻ�����UDP��ͬ���ǣ�TCP����Ҫָ����ǰ�˿ڣ�Ҳ����Ҫ����ɱ��ģ���������Ҫ�������ͣ�ֻ��Ҫ�����ݴ�������
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
public static void main(String[] args) {
	try {
//		1.ʹ��Socket�����ͻ����׽��֣�ָ��Ŀ�ĵ�ַ�ͷ������˿�
		Socket socket=new Socket("localhost", 9998);
//		2.�������������,ʹ��DataOutputStream���Ҫ�����Ķ���
//		��������˵����Socket������IP+port
//		��Socket��������InputStream��OutputStream��������
//		��Ҫ��Socket�����ݽ��в������õ���д���ӳ���д��socket�����������������write
		OutputStream os=socket.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
//		Ҫע����ǣ���ü����������ݣ���Ҫ�Ƚ���ת��Ϊ�ַ���
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�������˺�");
		String name=br.readLine();
		System.out.print("����������");
		String password=br.readLine();
//		��һ���ַ���д�룬��UTF-8����
		dos.writeUTF("�˺�="+name+"&"+"����="+password);
		dos.flush();
//		�����getInputStream�Ƚ�����⣬��socket��getInputStream��socket������д����
//		������ͨ�Ź����У��������ֶ�socket������д������������������Ƿ�����������������
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		System.out.println(dis.readUTF());
//		3.�رտͻ���
		dos.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
