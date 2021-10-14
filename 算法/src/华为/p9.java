package »ªÎª;

import java.util.*;

public class p9 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set=new TreeSet();
        while(sc.hasNext()){
          set.add(Integer.parseInt(sc.nextLine()));
        }
        for(int i:set){
            System.out.println(i);
        }
//        System.out.println(Integer.parseInt(sc.nextLine()));
    }
      
      
}