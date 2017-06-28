package willzh.java8test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
//		testCreateFileWithCreateNewFile();
//		testCopyFile();
//		Thread.sleep(5000);
//		testDeleteFile();
		
		//testCreateDirectoryWithMkdir();
		//testCreateDirectoryWithMkdirs();
		
		fileInputStreamTest();
		
	}

	private void test() throws IOException{
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


	private static void testCreateFileWithCreateNewFile() throws IOException{

		File file = new File("D:\\test\\456.txt");
		if(!file.exists()){
			file.createNewFile();
			System.out.println("文件生成成功！");
		}
	}
	
	private static void testFileCreateWithCreateTempFile() throws IOException{
		
		String prefix = "temp_";
		String suffix = ".log";
		File directory = new File("D:\\test");
		
		File.createTempFile(prefix, suffix, directory);
		System.out.println("文件生成成功！");
		
	}
	
	private static void testDeleteFile(){
		
		File file = new File("D:\\test\\456.txt");
		if(file.exists()){
			file.delete();
			System.out.println("文件删除成功!");
		}
	}
	
	private static void testCopyFile() throws IOException{
		
		File sourceFile = new File("D:\\test\\456.txt");
		if(!sourceFile.exists()){
			throw new IOException("文件不存在！");
		}
		
		File destoryFile = new File("D:\\test1\\666.txt");
		sourceFile.renameTo(destoryFile);
		System.out.println("文件移动成功！");
		
	}
	
	private static void testCreateDirectoryWithMkdir(){
		
		File file = new File("D:\\t");
		if(!file.exists()){
			file.mkdir();
			System.out.println("目录创建成功");
		}
	}

	private static void testCreateDirectoryWithMkdirs(){

		File file = new File("D:\\t\\t1");
		if(!file.exists()){
			file.mkdir();
			System.out.println("目录创建成功");
		}
	}

	private static void testFileAPI(String path){

		File file = new File(path);
		System.out.println("*****文件属性测试 *****");
		System.out.println("文件是否存在："+file.exists());
		System.out.println("文件名:"+file.getName());
		System.out.println("上级目录:"+file.getParent());
		System.out.println("是否可读:"+file.canRead());
		System.out.println("是否可写:"+file.canWrite());
		System.out.println("绝对路径:"+file.getAbsolutePath());
		System.out.println("相对路径:"+file.getPath());
		System.out.println("是否为绝对路径:"+file.isAbsolute());
		System.out.println("是否为目录:"+file.isDirectory());
		System.out.println("是否为文件:"+file.isFile());
		System.out.println("是否为隐藏文件:"+file.isHidden());
		System.out.println("最后修改时间:"+new Date(file.lastModified()));
		System.out.println("文件长度:"+file.length());

	}
	
	private static void fileInputStreamTest(){

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try{
			fis = new FileInputStream("D:\\test\\123.txt");
			isr = new InputStreamReader(fis,"UTF-8");
			br = new BufferedReader(isr);
			String tmp = null;
			while((tmp=br.readLine())!=null){
				System.out.println(tmp);
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(isr != null){
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	private static void fileOutputStreamTest(){

		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try{
			fos = new FileOutputStream("D:\\test\\123.txt");
			osw = new OutputStreamWriter(fos,"UTF-8");
			bw = new BufferedWriter(osw);
			//原文覆盖
			bw.write("世界第一");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(osw != null){
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

}
