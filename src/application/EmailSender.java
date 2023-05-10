package application;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

   private String email;
   private String password;

   public EmailSender(String email, String password) {
       this.email = email;
       this.password = password;
   }

   public void sendEmail(String to, String bookingNumber) throws Exception {
//       if (!isValidEmail(to)) {
//           throw new IllegalArgumentException("Invalid email address: " + to);
//       }
       if (bookingNumber == null || bookingNumber.trim().isEmpty()) {
           throw new IllegalArgumentException("Booking number is required");
       }

       System.out.println("Preparing to send email");
       Properties props = new Properties();
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "587");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");

       Session session = Session.getInstance(props, new Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(email, password);
           }
       });

       Message message = prepareMessage(session, email, to, bookingNumber);
       Transport.send(message);
       System.out.println("Sent successfully!");
   }

   private static Message prepareMessage(Session session, String email, String to, String bookingNumber)
           throws MessagingException {
       Message message = new MimeMessage(session);
       message.setFrom(new InternetAddress(email));
       message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
       message.setSubject("Confirmation for booking number " + bookingNumber);
       message.setText("Dear guest,\n\n"
               + "Thank you for making a reservation with us. Your booking number is " + bookingNumber + ".\n\n"
               + "We look forward to welcoming you!\n\n"
               + "Best regards,\n"
               + "The Room Reservation App team");
       return message;
   }

//   private static boolean isValidEmail(String email) {
//       // A simple email validation using regex
//       String regex = "..+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
//       return email.matches(regex);
//   }
}
