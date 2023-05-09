package application;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
//import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;



public class EmailSender {

//	private String emailServer;
//	private int emailPort;
//	private String username;
//	private String password;

	public EmailSender() {

	}

	public void sendEmail(String to, String bookingNumber) throws Exception {
		
		System.out.println("Preparing to send email");
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		String myEmail = "thanhtu10c9@gmail.com";
		String pass = "Th@nht2$10";

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmail, pass);
			}
		});
		
		Message message = prepareMessage(session,myEmail,to,bookingNumber ) ;
		Transport.send(message);
		System.out.println("Sent successfully!");
		
	}
	
	private static Message prepareMessage(Session session,String myEmail,String to, String bookingNumber ){
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("A Subject");
			message.setText("Hello your booking number: " + bookingNumber);
			return message;
		} catch (Exception ex) {
			Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

//	public void setServer(String server, int port) {
//		this.emailServer = server;
//		this.emailPort = port;
//	}
//
//	public void setCredentials(String username, String password) {
//		this.username = username;
//		this.password = password;
//	}

}
