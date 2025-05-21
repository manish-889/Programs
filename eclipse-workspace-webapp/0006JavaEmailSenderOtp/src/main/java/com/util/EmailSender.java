package com.util;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {
	public static void main(String[] args) {
		//sendMail("hariomtripathi12344@gmail.com", "Test Email", "This is testing email notification");
	}

	public static boolean sendMail(String to, String subject, String message) throws MessagingException{
		
		Properties properties = new Properties();
		
		//set the properties of smtp
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //creating session for sender Authentication
        Session session = Session.getInstance(properties, new Authenticator() {
		
        	@Override
        	protected PasswordAuthentication getPasswordAuthentication() {
        		// TODO Auto-generated method stub
        		return new PasswordAuthentication("hariomtripathi12344@gmail.com", "stlx sozm dzjp knzb");
        	}
        
        });

        
			MimeMessage message2 = new MimeMessage(session);
			
			message2.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message2.setSubject(subject);
			message2.setText(message);
			
			Transport.send(message2);
			
			return true;
	}
}
