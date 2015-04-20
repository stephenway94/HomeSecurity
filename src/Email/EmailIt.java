/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Strategies.HomeStrategy;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author StephenRobert
 */
public class EmailIt implements HomeStrategy {
    private PasswordStored PasswordStored;

    public EmailIt(String[] email, String content) throws MessagingException {
        this.PasswordStored = new PasswordStored();
        String Password = PasswordStored.PasswordStored();
        Properties EmailSettings = new Properties();
        EmailSettings.put("mail.smtp.host", "smtp.gmail.com");
        EmailSettings.put("mail.smtp.socketFactory.port", "465");
        EmailSettings.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        EmailSettings.put("mail.smtp.auth", "true");
        EmailSettings.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(EmailSettings,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                      

                        return new PasswordAuthentication("wayswebcam@gmail.com", Password);
                    }
                });

        for (int i = 0; i < email.length; i++) {
            if(email[i] != null){

            Message SendEmail = new MimeMessage(session);
            SendEmail.setFrom(new InternetAddress("wayswebcam@gmail.com"));
            SendEmail.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email[i]));
            SendEmail.setSubject("Testing Subject");
            SendEmail.setText("Intrusion detected in " + content);

            Transport.send(SendEmail);

            System.out.println("Done");
            }
            else
                break;
        }

    }


    public PasswordStored GetEmail() {
        PasswordStored password = new PasswordStored();
        return password;
    }

}
