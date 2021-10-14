package 常考;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
	private int capacity;
	private HashMap<Integer, Integer> map;
	private LinkedList<Integer> list;
//	list存key，map存key-value
    public LRU(int capacity) {
    	this.capacity=capacity;
    	this.map=new HashMap<Integer, Integer>();
    	this.list=new LinkedList<Integer>();
    }
//    取的时候在list把key去除，重新放在队尾
    public int get(int key) {
    	if(map.containsKey(key)) {
    		list.remove(key);
    		list.addLast(key);
    		return map.get(key);
    	}
    	return -1;
    }
//    存的时候进行两个判断，一个是list或map里有没有，有则去除
//    一个是看是不是满了，满了就把队头去除
//    然后才添加，list与map都添加
    public void put(int key, int value) {
    	if(map.containsKey(key))  list.remove((Integer)key);
    	if(list.size()==capacity) map.remove(list.removeFirst());
    	map.put(key, value);
    	list.addLast(key);
		return;
    }
}
