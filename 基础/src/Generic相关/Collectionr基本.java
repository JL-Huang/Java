package Generic相关;

//Collectionr容器接口
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Collectionr基本 {
public static void main(String[] args) {
//	Collection是一个接口,其实现类为ArrayList
	Collection<String> c=new ArrayList<String>();
	c.add("一");
	c.add("二");
	System.out.println(c);
	System.out.println(c.size());
	System.out.println(c.isEmpty());
	Object[] objectlist=c.toArray();
	System.out.println(Arrays.toString(objectlist));
//	移除并非是删除,数据对象还在,只是在c对象中删掉了对象的地址
	c.remove("一");
	System.out.println(c);
	System.out.println(c.contains("一`"));
//	与上面同理
	c.clear();
	System.out.println(c.isEmpty());
}
}
