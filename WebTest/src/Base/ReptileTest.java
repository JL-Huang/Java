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
//	模拟请求，value以后补充
//	HttpURLConnection hurlc=(HttpURLConnection)url1.openConnection();
//	hurlc.setRequestMethod("GET");
//	hurlc.setRequestProperty("User-Agent", value);
//	注意不是所有的IP都能openStream
	InputStream is=url1.openStream();
	BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
	String msg;
//	read是一个一个读，返回一个int，用-1来判断结束
//	readline是一行行读，返回一个String，用null判断结束
	while((msg=br.readLine())!=null) {
		System.out.println(msg);
	}
	br.close();
	
}
}
