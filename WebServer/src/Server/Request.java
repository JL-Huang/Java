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
//	������Ϣ
	private String requestInfo;
//	����ʽ
	private String method;
//	����url
	private String url;
//	�������
	private String queryldx;
//	��ȡ������������������棩
	private Map<String, List<String>> map;
	private String[] keys=new String[10];
	private String[] values=new String[10];
	
	public String getUrl() {
		return url;
	}
	public Request(InputStream is) {
		map=new HashMap<String, List<String>>();
		try {
			System.out.println("һ���ͻ��˼���������");
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
//		thisֻ�������У�����trycatch
//		�����ǵ�����ǰ�����صĹ��췽��
		this(s.getInputStream());
	}
	private void parseRequestinfo() {
		System.out.println("----�ֽ�----");
		System.out.println(requestInfo);
		System.out.println("----��ȡ����ʽ----");
//		trim()ȥ����β�Ŀո�
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
			System.out.println("----�������----");
		switch(method) {
		case("GET"):{
			if(this.queryldx==null) {
				System.out.println("��");
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
//		��&�ָ���ֵ��
		String[] keyvalues=queryldx.split("&");
//		��ֹ����&����Ϊ�յ����
		keyvalues=Arrays.copyOf(keyvalues,2);
//		��=�ָ�����ֵ
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
//		����һ��Ҫд����������᷵��Object[]
		return list.toArray(new String[0]);
	}
	public String findvalue(String key,int i) {
		String[] s=findvalues(key);
		return s==null?null:s[i];
	}
		
	}

