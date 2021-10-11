package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
	 StringBuilder content=null;
	 StringBuilder responseinfo=null;
	 Socket s;
	 int size;
	 int status=200;
	final String BLANK=" ";
	final String CRLF="\r\n";
	
	public Response(Socket s) {
		super();
		this.s = s;
	}
//	public void send() throws IOException {
//		sethtml("连接成功","成功了");
	public void send(String title,String body) throws IOException {
		sethtml( title,body);
		if(content==null) {
			status=505;
		}
		creatline(status);
		creathead();
		 responseinfo.append(content.toString());
		 BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		 bw.write(responseinfo.toString());
		 bw.flush();
//		 这一行非常关键，执行到这一步没有关Socket，下一个Socket就进不了
		 s.close();
	}
	public void sethtml(String title,String body) {
		responseinfo=new StringBuilder();
		 content=new StringBuilder();
		 content.append("<html>");
		 content.append("<head>");
		 content.append("<title>");
		 content.append(title);
		 content.append("</title>");
		 content.append("</head>");
		 content.append("<body>");
		 content.append(body);
		 content.append("</body>");
		 content.append("</html>");
		 size=content.toString().getBytes().length;
	}
	public void creatline(int code) {
		 responseinfo.append("HTTP/1.1").append(BLANK);
		 responseinfo.append(code).append(BLANK);
		 switch(code){
		 case 200:
			 responseinfo.append("OK").append(CRLF);
			 break;
		 case 404:
			 responseinfo.append("NotFound").append(CRLF);
			 break;
		 case 505:
			 responseinfo.append("ServerError").append(CRLF);
			 break;
		 }
	}
	public void creathead() {
		 responseinfo.append("Date:").append(new Date()).append(CRLF);
		 responseinfo.append("Server:").append("cazz;charset=GBK").append(CRLF);
		 responseinfo.append("Content-type:text/html").append(CRLF);
		 responseinfo.append("Content-length:").append(size).append(CRLF);
		 responseinfo.append(CRLF); 
	}
}
