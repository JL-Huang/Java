package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server01 {
	ServerSocket ss;
	Socket s;
//	static Response r;
public static void main(String[] args) throws IOException {
	Server01 s01=new Server01();
	s01.start();
	s01.receive();
	s01.response();
//	r.send();
}
public void start() {
	try {
		 ss=new ServerSocket(9999);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void receive() {
	try {
		s=ss.accept();
//		r=new Response(s);
		System.out.println("һ���ͻ��˼���������");
		InputStream is=s.getInputStream();
		byte[] bytes=new byte[1024*1024];
		int len=is.read(bytes);
		String str=new String(bytes, 0, len);
		System.out.println(str);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("����ʧ��");
	}
}
public void response() throws IOException {
//	 html��ʽ
	 StringBuilder content=new StringBuilder();
	 content.append("<html>");
	 content.append("<head>");
	 content.append("<title>");
	 content.append("��������Ӧ�ɹ�");
	 content.append("</title>");
	 content.append("</head>");
	 content.append("<body>");
	 content.append("���ڻ�����");
	 content.append("</body>");
	 content.append("</html>");
//	 һ��Ҫע�⣬������Ҫ����html��ʽ���ֽڳ��ȣ������ַ����ȣ�
	 int size=content.toString().getBytes().length;
	 StringBuilder responseinfo=new StringBuilder();
	 String blank=" ";
	 String CRLF="\r\n";
	 //��Ӧ��HTTP/1.1 200 OK
	 responseinfo.append("HTTP/1.1").append(blank);
	 responseinfo.append("200").append(blank);
	 responseinfo.append("OK").append(CRLF);
	 //��Ӧͷ�����һ�д��ڿ��У�
	 //��ʽһ��Ҫ��ȷ������ֱ������û��
	 responseinfo.append("Date:").append(new Date()).append(CRLF);
	 responseinfo.append("Server:").append("cazz;charset=GBK").append(CRLF);
	 responseinfo.append("Content-type:text/html").append(CRLF);
	 //��������Ҫע��ģ�size������㶨��ģ�������html��ʽ�ĳ���,������ˣ����ص�html���ȳ���
	 responseinfo.append("Content-length:").append(size).append(CRLF);
	 responseinfo.append(CRLF); 
//	 ����
	 responseinfo.append(content.toString());
//	 д�����ͻ���
	 BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	 bw.write(responseinfo.toString());
	 bw.flush();
}
}
