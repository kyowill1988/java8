package willzh.java8test;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator {
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {

		String username = "sample@qq.com";
		String password = "xxx";

		return new PasswordAuthentication(username,password);
	}

}
