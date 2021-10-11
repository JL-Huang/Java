package TCPTest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Send implements Runnable{
	OutputStream os;
	DataOutputStream dos;
	BufferedReader br;
	Socket s;
	String name;
	public Send(Socket s, String name) {
		super();
		this.s = s;
		this.name = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			os=s.getOutputStream();
			dos=new DataOutputStream(os);
			br=new BufferedReader(new InputStreamReader(System.in));
			boolean isrunning =true;
			while(isrunning) {
				String data=br.readLine();
				dos.writeUTF(this.name+"หตฃบ"+data);
				dos.flush();
		} 
			dos.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
