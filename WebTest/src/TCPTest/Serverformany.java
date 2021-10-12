package TCPTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverformany {
public static void main(String[] args) throws IOException {
	ServerSocket ss=new ServerSocket(9998);
//	���whileѭ������ؼ��ĵط�����Ȼaccept֮���һֱִ����ȥ��������accept��
	while(true) {
		Socket s1=ss.accept();
		System.out.println("һ���ͻ��˴���������");
		new Thread(new Channel(ss, s1)).start();
		
	}
}
}
class Channel implements Runnable{
	ServerSocket ss;
	Socket s;
	String name;
	String password;
	
	public Channel(ServerSocket ss, Socket s) {
		super();
		this.ss = ss;
		this.s = s;
	}


	@Override
	public void run() {
			try {			
				String data=getinput(s);
				analyze(data);
				setoutput(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}
	
	public String getinput(Socket s) throws IOException{
		InputStream is=s.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		String data=dis.readUTF();
		return data;
	}
	
	public void setoutput(Socket s) throws IOException {
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		if(name.equals("123456")&& password.equals("abc")) {
			dos.writeUTF("��¼�ɹ�");				
		}else {
			dos.writeUTF("��¼ʧ��");
		}
		dos.flush();
		dos.close();
		s.close();
	}
	public void analyze(String data) {
		String[] strs=data.split("&");
		for(String temp:strs) {
			String[] strss=temp.split("=");
			if(strss[0].equals("�˺�")) {
				System.out.println("�����˺�Ϊ"+strss[1]);
				name=strss[1];
			}else {
				System.out.println("��������Ϊ"+strss[1]);
				password=strss[1];
			}
		}
	}
	
}
