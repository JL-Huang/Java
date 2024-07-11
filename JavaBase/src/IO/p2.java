package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class p2 {
	public static void main(String[] args) {
		File src=new File("abc.txt");
		InputStream is=null;
		try {
			is=new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			int i;
			byte[] b=new byte[3];
			while((i=is.read(b))!=-1) {
				System.out.println(new String(b,0,i));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(is!=null) {
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
}
