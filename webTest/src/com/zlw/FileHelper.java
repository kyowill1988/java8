package com.zlw;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * fileHelper test
 * @author 
 *
 */
public class FileHelper extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Properties props = new Properties();
		props.put("mail.host", "smtp.qq.com");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		
		
		
		
		
		
		
		super.doPost(req, resp);
	}

}
