/**
  * Looking Positive E-mail.
  */
package lookingpositive.lookingpositive;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class sends E-mails to the contacts of infected users.
 */
public final class Mail {
  /**
   * private constructor.
   */
  private Mail() {
  }

  /**
   * sender's E-mail.
   */
  private static final String FROM = "LookingPositiveApp@gmail.com";
  /**
   * sender's E-mail password.
   */
  private static final String PASSWORD = "lookingpositive123";
  /**
   * G-mail SMTP server.
   */
  private static final String SMTP_SERVER = "smtp.gmail.com";
  /**
   * G-mail's server port.
   */
  private static final String EMAIL_SERVER_PORT = "465";
  /**
   * E-mail subject.
   */
  private static final String EMAIL_SUBJECT = "Urgent Message";
  /**
   * E-mail body.
   */
  private static final String EMAIL_BODY = "You have contacted"
      + " a verified Covid case."
      + " Stay home precautionarily ";

  /**
   * this method sends E-mails.
   * @param list unique E-mails
   */
  @SuppressWarnings("unused")
  public static void email(final ArrayList<String> list) {
    Properties props = new Properties();
    props.put("mail.smtp.user", FROM);
    props.put("mail.smtp.host", SMTP_SERVER);
    props.put("mail.smtp.port", EMAIL_SERVER_PORT);
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.socketFactory.port", EMAIL_SERVER_PORT);
    props.put("mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    SecurityManager security = System.getSecurityManager();
    /**
     * This class obtains authentication to the connection.
     */
    class SMTPAuthenticator extends javax.mail.Authenticator {
      @Override
      public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(FROM, PASSWORD);
      }
    }
    try {
      Authenticator auth = new SMTPAuthenticator();
      Session session = Session.getInstance(props, auth);
      MimeMessage msg = new MimeMessage(session);
      msg.setText(EMAIL_BODY);
      msg.setSubject(EMAIL_SUBJECT);
      msg.setFrom(new InternetAddress(FROM));
      InternetAddress[] mailAddressTo = new InternetAddress[list.size()];
      for (int i = 0; i < list.size(); i++) {
        mailAddressTo[i] = new InternetAddress(list.get(i));
      }
      msg.addRecipients(Message.RecipientType.BCC, mailAddressTo);
      mailAddressTo = new InternetAddress[mailAddressTo.length];
      System.out.println("Please wait...");
      Transport.send(msg);
      System.out.println("Thanks for the update!");
    } catch (SendFailedException mex) {
      mex.printStackTrace();
    } catch (Exception mex) {
      mex.printStackTrace();
    }
  }
}
