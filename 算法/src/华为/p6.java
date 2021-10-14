package »ªÎª;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class p6{
      public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          String s=sc.nextLine();
            char[] c=s.toCharArray();
          Set<Character> set=new HashSet<Character>();
          for(int i=0;i<c.length;i++){
              set.add(c[i]);
          }
          System.out.println(set.size());

      } 
      
}