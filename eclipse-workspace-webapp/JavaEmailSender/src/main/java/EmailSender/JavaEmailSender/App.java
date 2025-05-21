package EmailSender.JavaEmailSender;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;



public class App 
{
    public static void main( String[] args )
    {
       String message = "This is meassage verification for that the email application is run correctly or not, if you received this message it's means that the application succesfully...";
       String subject = "Verification";
       String to = "mgiri4683@gmail.com";
       String from = "dtech1241@gmail.com";
       
       sendEmail(message, subject, to, from);
    }

	private static void sendEmail(String message, String subject, String to, String from) {
		
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
	
				return new PasswordAuthentication("mgiri4683@gmail.com", "ManishGiri78@");
			}
			
		});
		
		session.setDebug(true);
		
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			
			mimeMessage.setFrom(from);
			
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			mimeMessage.setSubject(subject);
			
			Transport.send(mimeMessage);
			
			System.out.println("Message Sent...");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
