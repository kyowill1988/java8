package willzh.java8test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
		
	public static void sendMail() throws MessagingException{
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");

		//设置ssl的端口  
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.ssl.enable", "true");
		
		Authenticator auth = new MailAuthenticator();
		
		Session session = Session.getInstance(props,auth);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("sample@qq.com"));
		msg.setSubject("Hello World");
		msg.setText("It is a happy way to learn java");
		msg.setRecipient(RecipientType.TO, new InternetAddress("sample@qq.com"));
		
		Transport.send(msg);
		System.out.println("SUCCESS");
		
	}
	
}
