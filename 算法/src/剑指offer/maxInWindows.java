package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class maxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	if(num==null||num.length==0||size==0||num.length<size) return new ArrayList<Integer>();
    	ArrayList<Integer> list=new ArrayList<Integer>();
        LinkedList<Integer> templist=new LinkedList<Integer>();
        if(num.length==size) {
            int max=Integer.MIN_VALUE;
            for(int i=0;i<num.length;i++) max=max>num[i]?max:num[i];
            list.add(max);
        	return list;
        }
        int index=0;
        for(int i=index;i<index+size;i++) templist.offer(num[i]);
        while(index<num.length-size+1) {
        	LinkedList<Integer> newlist=new LinkedList<Integer>(templist);
        	Collections.sort(newlist);
        	list.add(newlist.get(size-1));
        	templist.poll();
        	if(index+size<num.length)
        	templist.offer(num[index+size]);
        	index++;
        }
        return list;
    }
}
