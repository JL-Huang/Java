package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReptileTest {
public static void main(String[] args) throws IOException {
	URL url1=new URL("http://www.baidu.com");
//	ģ������value�Ժ󲹳�
//	HttpURLConnection hurlc=(HttpURLConnection)url1.openConnection();
//	hurlc.setRequestMethod("GET");
//	hurlc.setRequestProperty("User-Agent", value);
//	ע�ⲻ�����е�IP����openStream
	InputStream is=url1.openStream();
	BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
	String msg;
//	read��һ��һ����������һ��int����-1���жϽ���
//	readline��һ���ж�������һ��String����null�жϽ���
	while((msg=br.readLine())!=null) {
		System.out.println(msg);
	}
	br.close();
	
}
}
