package »ªÎª;

import java.util.*;
public class p8{
      public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
            String str=sc.nextLine();
             String[] strs=str.split(";");
          int i1=0;
          int i2=0;
          boolean flag=true;
          for(int i=0;i<strs.length;i++){
        	 
              try{
            	  switch(strs[i].charAt(0)){
            	  case('A'):i1=i1-Integer.parseInt(strs[i].substring(1));break;
            	  case('D'):i1=i1+Integer.parseInt(strs[i].substring(1));break;
            	  case('W'):i2=i2+Integer.parseInt(strs[i].substring(1));break;
            	  case('S'):i2=i2-Integer.parseInt(strs[i].substring(1));break;
            	  
            	  }
              }
              catch(Exception e) {
            	  continue;
              }
        }
          System.out.println(i1+","+i2);
      }
}