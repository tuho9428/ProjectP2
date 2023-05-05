package application;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

	private String emailServer;
	private int emailPort;
	private String username;
	private String password;

	public EmailSender(String emailServer, int emailPort, String username, String password) {
		this.emailServer = emailServer;
		this.emailPort = emailPort;
		this.username = username;
		this.password = password;
	}

	public void sendEmail(String to, String subject, String body) throws MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", emailServer);
		props.put("mail.smtp.port", emailPort);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(subject);
		message.setText(body);

		Transport.send(message);
	}

	public void setServer(String server, int port) {
		this.emailServer = server;
		this.emailPort = port;
	}

	public void setCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
