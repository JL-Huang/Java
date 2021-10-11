package Server;

import java.io.IOException;

public class LoginServlet implements Servlet{
	@Override
	public void service(Request request,Response respons)  {
		// TODO Auto-generated method stub
	System.out.println("LoginServlet");	
	try {
		respons.send("ªÿ”¶", "Welcome"+request.findvalue("uname", 0));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
