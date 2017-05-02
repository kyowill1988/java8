package willzh.java8test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.*;

public class FreemarkerTest {

	private Configuration config;
	
	public FreemarkerTest() throws IOException{
	
		config = new Configuration(Configuration.VERSION_2_3_26);
		config.setDirectoryForTemplateLoading(new File("D:/test"));
	}
	
	public void foo() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException{
		
		Template t = config.getTemplate("test.ftl");
		
		OutputStream fos = new FileOutputStream(new File("D:/test1","1.txt"));
		Writer out = new OutputStreamWriter(fos);
		
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("root", "Test");
		root.put("type1", "String");
		root.put("column1", "name");
		
		t.process(root, out);
		
	}
	
	
	
	
	
}
