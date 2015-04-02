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

    public EmailIt(String content) throws MessagingException {
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
        String[] EmailAdd = new String[2];
        EmailAdd[0] = "wayswebcam@gmail.com";
        EmailAdd[1] = "f672707e8cd24a9197cd853b24401335@api.pushalot.com";
        for (int i = 0; i < EmailAdd.length; i++) {

            Message SendEmail = new MimeMessage(session);
            SendEmail.setFrom(new InternetAddress("wayswebcam@gmail.com"));
            SendEmail.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EmailAdd[i]));
            SendEmail.setSubject("Testing Subject");
            SendEmail.setText("Intrusion detected in " + content);

            Transport.send(SendEmail);

            System.out.println("Done");
        }

    }


    public PasswordStored GetEmail() {
        PasswordStored password = new PasswordStored();
        return password;
    }

}
