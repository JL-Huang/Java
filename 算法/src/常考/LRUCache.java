package 常考;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    public static void main(String[] args) {
        LRUCache sds=new LRUCache(2);
        sds.put(1,1);
        sds.put(2,2);
        sds.get(1);
        sds.put(3,3);
        sds.get(2);
        sds.put(4,4);
        sds.get(1);

        sds.get(3);
        sds.get(4);
    }
    private LinkedList list=new LinkedList();
    private HashMap<Integer,Integer> cacheHashMap=new HashMap();
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(cacheHashMap.containsKey(key)){
            list.remove((Integer)key);
            list.addLast(key);
            return cacheHashMap.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cacheHashMap.containsKey(key)){
            list.remove((Integer)key);
        }else{
            if(list.size()==capacity){
                int old=(Integer)list.removeFirst();
                cacheHashMap.remove((Integer)old);
            }
        }
        list.addLast(key);
        cacheHashMap.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */