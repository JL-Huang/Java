package xmlTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class WebContent {
	 private List<Entity> entities;
	private List<Mapping> mappings;
//	�����ֵ����servlet-name��servlet-class��ӳ��
	private Map<String, String> entitymap=new HashMap<String, String>();
//	�����ֵ����url-pattern��servlet-name��ӳ��
	private Map<String, String> mappingmap=new HashMap<String, String>();
	public WebContent(List<Entity> entities, List<Mapping> mappings) {
		super();
		this.entities = entities;
		this.mappings = mappings;
//		�������Listת����Map
		for(Entity temp:entities) {
			entitymap.put(temp.getName(), temp.getClz());
		}
		for(Mapping temp:mappings) {
			for(String temp1:temp.getPattern()) {
				mappingmap.put(temp1, temp.getName());
			}
		}
	}
//	ͨ������һ��URLpattern������һ��Servletname,��ͨ�����Servlet����һ��Class
	public String getClz(String pattern) {
		String name=mappingmap.get(pattern);
		return entitymap.get(name);
	}
	
}
