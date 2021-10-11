package xmlTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class WebContent {
	 private List<Entity> entities;
	private List<Mapping> mappings;
//	这个键值对是servlet-name到servlet-class的映射
	private Map<String, String> entitymap=new HashMap<String, String>();
//	这个键值对是url-pattern到servlet-name的映射
	private Map<String, String> mappingmap=new HashMap<String, String>();
	public WebContent(List<Entity> entities, List<Mapping> mappings) {
		super();
		this.entities = entities;
		this.mappings = mappings;
//		把输入的List转换成Map
		for(Entity temp:entities) {
			entitymap.put(temp.getName(), temp.getClz());
		}
		for(Mapping temp:mappings) {
			for(String temp1:temp.getPattern()) {
				mappingmap.put(temp1, temp.getName());
			}
		}
	}
//	通过输入一个URLpattern来返回一个Servletname,再通过这个Servlet返回一个Class
	public String getClz(String pattern) {
		String name=mappingmap.get(pattern);
		return entitymap.get(name);
	}
	
}
