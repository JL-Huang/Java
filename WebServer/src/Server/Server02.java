package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//封装版服务器
public class Server02 {
public static void main(String[] args) throws IOException {
	ServerSocket ss=new ServerSocket(9099);
	Socket s;
	boolean isrunning=true;
	while(isrunning) {	
			s=ss.accept();
			new RR(s).start();
	}
}
}
class RR extends Thread{
	Socket s;
	
	public RR(Socket s) {
		super();
		this.s = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Request request=new Request(s);
			Response response=new Response(s);
//			response.send();
			if(request.getUrl().equals("login")){
				Servlet servlet=new LoginServlet();
				servlet.service(request, response);			
			}else if(request.getUrl().equals("reg")) {
				Servlet servlet=new RegisterServlet();
				servlet.service(request, response);	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
}

