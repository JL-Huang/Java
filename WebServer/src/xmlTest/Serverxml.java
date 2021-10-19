package xmlTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//浏览器输入网址/g,返回键g对应的类
public class Serverxml {
public static void main(String[] args) throws Exception {
	try {
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parse=factory.newSAXParser();
		WebHandler webHandler=new WebHandler();
		InputStream is=new FileInputStream(new File("s.xml"));
		parse.parse(is,webHandler);
		
		WebContent webContent=new WebContent(webHandler.getEnties(), webHandler.getMappings());
//		这都丢进WebContent里面了
//		List<Entity> entities=webHandler.getEnties();
//		List<Mapping> mappings=webHandler.getMappings();
//		慢慢讲讲下面在干什么
//		首先,是根据URLpattern返回一个Class路径,根据这个路径获取Class对象
//		这个对象是指向了LoginServlet.class,所以下面是获得构造方法,实例化对象
//		这样子就实现了URLpattern到实例化其对应对象的转换
//		同样道理可以换成/reg
		Class C1=Class.forName(webContent.getClz("/login"));
		Servlet s1=(Servlet) C1.getConstructor().newInstance();
		System.out.println(s1);
		s1.service();

	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
class WebHandler extends DefaultHandler{
	private List<Entity> entities;
	private Entity entity;
	private List<Mapping> mappings;
	private Mapping mapping;
	private String tag;
	boolean isMaping=false;
	
	
	public List<Entity> getEnties() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
//		System.out.println("检索文件头,解析开始");
		mappings=new ArrayList<Mapping>();
		entities=new ArrayList<Entity>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
//		System.out.println("获取开始标签名"+qName);
		if(qName!=null) {
			tag=qName;		
		}
		if(qName.equals("servlet")) {
			entity=new Entity();
			isMaping=false;
		}else if(qName.equals("servlet-mapping")) {
			mapping=new Mapping();
			isMaping=true;
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String content=new String(ch,start,length);
//		System.out.println("内容为"+content);
		if(tag!=null) {
			if(isMaping) {
				if(tag.equals("servlet-name")) {
					mapping.setName(content);
				}else if(tag.equals("url-pattern")) {
					mapping.addpattern(content);
				}
			}else {
				if(tag.equals("servlet-name")) {
					entity.setName(content);
				}else if(tag.equals("servlet-class")) {
					entity.setClz(content);
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
//		System.out.println("获取结束标签名"+qName);
		if(qName.equals("servlet")) {
			entities.add(entity);			
		}else if(qName.equals("servlet-mapping")) {
			mappings.add(mapping);		
		}

		tag=null;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
//		System.out.println("解析文档结束");
	}
	
}
