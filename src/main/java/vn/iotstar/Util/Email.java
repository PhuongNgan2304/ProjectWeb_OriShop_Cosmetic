package vn.iotstar.Util;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import vn.iotstar.Entity.Users;

public class Email {
	public boolean EmailSend(Users user) {
		boolean test = false;
		String toEmail = user.getEmail();
//		String fromEmail = "21110524@student.hcmute.edu.vn";
//		String password = "ThuLai*1212";
		String fromEmail = "nhynhi2312003@gmail.com";
		String password = "gnvd piby zrvn lndo";
		
		try {
			// your host email smtp server details
			Properties pr = configEmail(new Properties());
			
			//get session to authenticate the host email address and password
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});
			
			//set email message details
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type", "text/plain; charset=UTF-8");
			//set from email address
			mess.setFrom(new InternetAddress(fromEmail));
			//set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			
			//set email subject
			mess.setSubject("Yours Password");
			//set message text
			mess.setText("Password: "+user.getPassword());
			//send the message
			Transport.send(mess);
			
			test= true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}
	
	
	public Properties configEmail(Properties pr) {
		//your host email smtp server details
		pr.setProperty("mail.smtp.host","smtp.gmail.com" );
		pr.setProperty("mail.smtp.port","587" );
		pr.setProperty("mail.smtp.auth","true" );
		pr.setProperty("mail.smtp.starttls.enable","true" );
		pr.put("mail.smtp.socketFactory.port", "587");
		pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		return pr;
	}
}
