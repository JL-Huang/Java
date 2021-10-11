package Server;

import java.io.IOException;

public class RegisterServlet implements Servlet{
	@Override
	public void service(Request request,Response response) {
		// TODO Auto-generated method stub
	try {
		response.send("зЂВс","Success");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}