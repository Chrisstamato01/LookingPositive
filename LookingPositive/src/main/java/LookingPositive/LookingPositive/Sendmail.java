package LookingPositive.LookingPositive;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.*;

public class Sendmail {
  final static String from = "lookingprositive@gmail.com";
  final static String to = "nikolas1813@gmail.com";
  final static String password = "lookingpositive1!";
  final static String SMTPserver = "smtp.gmail.com";
  final static String emailServerPort = "465";
  final static String emailSubject = " Επείγον μήνυμα ";
  final static String emailBody = " Έχετε έρθει σε επαφή με επιβεβαιωμένο κρούσμα. Μείνετε προληπτικά σπίτι. ";

  @SuppressWarnings("unused")
  public static void email() {
    Properties props = new Properties();
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.host", SMTPserver);
    props.put("mail.smtp.port", emailServerPort);
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.socketFactory.port", emailServerPort);
    props.put("mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    SecurityManager security = System.getSecurityManager();

    class SMTPAuthenticator extends javax.mail.Authenticator {
      public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(from, password);
      }
    }
    try {
      Authenticator auth = new SMTPAuthenticator();
      Session session = Session.getInstance(props, auth);
      MimeMessage msg = new MimeMessage(session);
      msg.setText(emailBody);
      msg.setSubject(emailSubject);
      msg.setFrom(new InternetAddress(from));
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      Transport.send(msg);
      System.out.println("Message send Successfully:)");
    } catch (Exception mex) {
      mex.printStackTrace();
    }

  }

}
