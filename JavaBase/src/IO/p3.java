package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class p3 {
	public static void main(String[] args) throws Exception {
		File src=new File("output.txt");
		OutputStream os=null;
		try {
			os=new FileOutputStream(src,true);
			//true为追加，false为替代
			String str="我在学java";
			os.write(str.getBytes());
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if(os!=null) {
				os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
