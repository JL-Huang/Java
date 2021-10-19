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
		System.out.println("一个客户端简历了连接");
		InputStream is=s.getInputStream();
		byte[] bytes=new byte[1024*1024];
		int len=is.read(bytes);
		String str=new String(bytes, 0, len);
		System.out.println(str);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("建立失败");
	}
}
public void response() throws IOException {
//	 html格式
	 StringBuilder content=new StringBuilder();
	 content.append("<html>");
	 content.append("<head>");
	 content.append("<title>");
	 content.append("服务器响应成功");
	 content.append("</title>");
	 content.append("</head>");
	 content.append("<body>");
	 content.append("终于回来了");
	 content.append("</body>");
	 content.append("</html>");
//	 一定要注意，这里需要的是html格式的字节长度，不是字符长度！
	 int size=content.toString().getBytes().length;
	 StringBuilder responseinfo=new StringBuilder();
	 String blank=" ";
	 String CRLF="\r\n";
	 //响应行HTTP/1.1 200 OK
	 responseinfo.append("HTTP/1.1").append(blank);
	 responseinfo.append("200").append(blank);
	 responseinfo.append("OK").append(CRLF);
	 //响应头（最后一行存在空行）
	 //格式一定要正确，否则直接整行没有
	 responseinfo.append("Date:").append(new Date()).append(CRLF);
	 responseinfo.append("Server:").append("cazz;charset=GBK").append(CRLF);
	 responseinfo.append("Content-type:text/html").append(CRLF);
	 //这里是需要注意的，size不是随便定义的，是上文html格式的长度,如果错了，返回的html长度出错
	 responseinfo.append("Content-length:").append(size).append(CRLF);
	 responseinfo.append(CRLF); 
//	 正文
	 responseinfo.append(content.toString());
//	 写出到客户端
	 BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	 bw.write(responseinfo.toString());
	 bw.flush();
}
}
