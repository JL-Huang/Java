package ÇïÕĞ;

import java.util.ArrayList;
import java.util.HashMap;

public class Shopee1 {
    public int validateTreeNodes (int n, int[][] dependency) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        HashMap<Integer, ArrayList<Integer>> map_list=new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<n;i++) {
        	map.put(i, 0);
        }
        for(int i=0;i<n;i++) {
        	map_list.put(i, null);
        	ArrayList<Integer> list=new ArrayList<Integer>();
        	for(int j=0;j<dependency[i].length;j++) {
        		list.add(dependency[i][j]);
        		if(map.containsKey(dependency[i][j]))
        			map.put(dependency[i][j], map.get(dependency[i][j])+1);
        		else map.put(dependency[i][j], 1);
        	}
        	map_list.put(i, list);
        }
        int flag=0;
        for(int i=0;i<n;i++) {
        		if(map.get(i)>1) return 0;
        		if(map.get(i)==0) flag++;
        		ArrayList<Integer> list1=map_list.get(i);
        		for(Integer temp1:list1) {
        			if(temp1==-1) continue;
        			ArrayList<Integer> list2=map_list.get(temp1);
        			for(Integer temp2:list2) {
        				if(i==temp2) return 0;
        			}
        		}
        		
        }
        if(flag>1) return 0;
        return 1;
    }
}
