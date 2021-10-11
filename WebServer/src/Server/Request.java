package Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
	final String CRLF="\r\n";
//	所有信息
	private String requestInfo;
//	请求方式
	private String method;
//	请求url
	private String url;
//	请求参数
	private String queryldx;
//	获取参数（在请求参数里面）
	private Map<String, List<String>> map;
	private String[] keys=new String[10];
	private String[] values=new String[10];
	
	public String getUrl() {
		return url;
	}
	public Request(InputStream is) {
		map=new HashMap<String, List<String>>();
		try {
			System.out.println("一个客户端简历了连接");
			byte[] bytes=new byte[1024*1024];
			int len;
			len = is.read(bytes);
			this.requestInfo=new String(bytes, 0, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		parseRequestinfo();
		
	}
	public Request(Socket s) throws IOException {
//		this只能在首行，不能trycatch
//		这里是调用了前面重载的构造方法
		this(s.getInputStream());
	}
	private void parseRequestinfo() {
		System.out.println("----分解----");
		System.out.println(requestInfo);
		System.out.println("----获取请求方式----");
//		trim()去除首尾的空格
		this.method=this.requestInfo.substring(0,this.requestInfo.indexOf('/')).trim();
		System.out.println(this.method);
		System.out.println("----url----");
		int start=this.requestInfo.indexOf('/')+1;
		int end=this.requestInfo.indexOf("HTTP/");
		this.url=requestInfo.substring(start, end);
		int queryldx=this.url.indexOf("jjj");	//"\\?"
			if(queryldx>=0) {
				String[] temp=url.split("jjj");//"?"
				this.url=temp[0];
				this.queryldx=temp[1];	
			}
			System.out.println(url);
			System.out.println("----请求参数----");
		switch(method) {
		case("GET"):{
			if(this.queryldx==null) {
				System.out.println("无");
			}else {
				System.out.println(this.queryldx);
			}
			break;
		}
		case("POST"):{
			String body=requestInfo.substring(requestInfo.lastIndexOf(CRLF));
			this.queryldx+="&"+body;
			System.out.println(this.queryldx);
			break;
		}
		}
		keymap();		
			
		}
	private void keymap() {
//		用&分隔键值对
		String[] keyvalues=queryldx.split("&");
//		防止出现&后面为空的情况
		keyvalues=Arrays.copyOf(keyvalues,2);
//		用=分隔键和值
		for(int i=0;i<keyvalues.length;i++) {
				String[] keyvalue=keyvalues[i].split("=");
				keys[i]=keyvalue[0];
				values[i]=keyvalue[1];
				if(!map.containsKey(keys[i])) {
					map.put(keys[i], new ArrayList<String>());
				}
				map.get(keys[i]).add(values[i]);
				
//				System.out.println(findvalue(keys[i],i));
		}
		
	}
	
	private String[] findvalues(String key) {
		List<String> list=this.map.get(key);
		if(list==null||list.size()<0) {
			return null;
		}
//		括号一定要写东西，否则会返回Object[]
		return list.toArray(new String[0]);
	}
	public String findvalue(String key,int i) {
		String[] s=findvalues(key);
		return s==null?null:s[i];
	}
		
	}

