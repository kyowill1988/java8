package willzh.java8test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		//封装数据源
		File srcfile = new File("D:/123");
		//封装目的地
		File destfile  = new File("D:/789");
		//判断是否存在目的地这个文件夹
		if(!destfile.exists()){
			destfile.mkdir();
		}
		//得到每一个文件以及文件夹对象
		File[] file = srcfile.listFiles();
		//遍历
		for(File f:file){
			String name = f.getName();
			File newfile = new File(destfile,name);
			CopyFolder(f,newfile);
		}
	}

	private static void CopyFolder(File f, File newfile) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newfile));

		byte[] by = new byte[1024];
		int len = 0;
		while((len=bis.read(by))!=-1){			
			bos.write(by, 0, len);		
			bos.flush();
		}
		bos.close();
		bis.close();
	}



}
