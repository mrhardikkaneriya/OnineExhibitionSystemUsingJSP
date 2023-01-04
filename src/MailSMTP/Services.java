package MailSMTP;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Services 
{
	public static void sendMailViaOTP(String emailid,String otp)
	{
	 
        System.out.println("Start");
        
        final String username  = "onlinejobportal2021@gmail.com";//Sender Email
		final String password   = "ukcq itxv kgil nvbl";//Sender Password
		
		System.out.println("1");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
		System.out.println("2");
		Session session = Session.getInstance(props,
		  new Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
				
			}
		  });
		System.out.println("3");
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("abc@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailid));//to mail address.
			message.setSubject("New OTP Generation");
			System.out.println("4");
			String msg1="<h1>OTP</h1>"+otp;
			
			message.setContent(msg1, "text/html");
			System.out.println("5");
			Transport.send(message);
		
			System.out.println("Done");
		} 
		catch (MessagingException e) 
		{
			throw new RuntimeException(e);
		}		
	}
}