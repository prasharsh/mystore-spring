package com.app.mystore.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class MystoreHelper {

	public void sendEmail(String email, String body, String subject) {
		System.out.println("inside send email");
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("mystoreweb.dalhousie@gmail.com", "test123test");
				}
			});
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("mystoreweb.dalhousie@gmail.com", false));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			msg.setSubject(subject);
			msg.setContent(body, "text/html");
			msg.setSentDate(new Date());


			Transport.send(msg);
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}   
	}

}

