package ����;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
	private int capacity;
	private HashMap<Integer, Integer> map;
	private LinkedList<Integer> list;
//	list��key��map��key-value
    public LRU(int capacity) {
    	this.capacity=capacity;
    	this.map=new HashMap<Integer, Integer>();
    	this.list=new LinkedList<Integer>();
    }
//    ȡ��ʱ����list��keyȥ�������·��ڶ�β
    public int get(int key) {
    	if(map.containsKey(key)) {
    		list.remove(key);
    		list.addLast(key);
    		return map.get(key);
    	}
    	return -1;
    }
//    ���ʱ����������жϣ�һ����list��map����û�У�����ȥ��
//    һ���ǿ��ǲ������ˣ����˾ͰѶ�ͷȥ��
//    Ȼ�����ӣ�list��map�����
    public void put(int key, int value) {
    	if(map.containsKey(key))  list.remove((Integer)key);
    	if(list.size()==capacity) map.remove(list.removeFirst());
    	map.put(key, value);
    	list.addLast(key);
		return;
    }
}
