package com.ats.ATS.Controller;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Async;


public class Email {
	public static String sendinterviewscheduledmail(String mail,String round,String date,String time,String url) throws AddressException {
		InternetAddress[] address = { new InternetAddress(mail) };

		int smtpPort = 587; // Use 587 for TLS or 465 for SSL
		String smtpHost = "smtp.gmail.com";
		String username = "pradeepcyfuturemeghdoot@gmail.com"; // Office 365 email address
		String password = "mgujrlhbvqcecwpb";
		String subject = "Interview Round 1";
		int length = 6;
		boolean useLetters = false;
		boolean useNumbers = true;
		String otp = RandomStringUtils.random(length, useLetters, useNumbers);
		String body ="Hi Panelist.\n" + "\n" + ",Round "+round+"interview is scheduled with you on"+date+"at"+time+"\n URL- "+url+"\n Please join on time."+
				

				"Best regards,\n" + "Team ATS\n" + "";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props);
		try {
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, address);
			message.setFrom(new InternetAddress(username));
			message.setSubject(subject);
			message.setText(body);

			Transport transport = session.getTransport("smtp");

			transport.connect(smtpHost, smtpPort, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

			System.out.println("Email sent to panelist");
			return otp;

		} catch (Exception e) {
			System.out.println("error in sending mail to panelist" + e);
			e.printStackTrace();
			return "error";
		}
}
	public static String sendmail(String to,String subject,String body) throws AddressException {
		InternetAddress[] address = { new InternetAddress(to) };

		int smtpPort = 587; // Use 587 for TLS or 465 for SSL
		String smtpHost = "smtp.gmail.com";
		String username = "pradeepcyfuturemeghdoot@gmail.com"; // Office 365 email address
		String password = "mgujrlhbvqcecwpb";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(props);
		try {
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, address);
			message.setFrom(new InternetAddress(username));
			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(smtpHost, smtpPort, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Email sent to panelist");
			return "Success";
		} catch (Exception e) {
			System.out.println("error in sending mail to panelist" + e);
			e.printStackTrace();
			return "error";
		}
}
	public static void sendoffer(String mail, String body, String subject, String filePath,
            String fileName) throws AddressException {
		InternetAddress[] address = { new InternetAddress(mail) };
int smtpPort = 587; // Use 587 for TLS or 465 for SSL
System.out.println("file"+filePath);
String smtpHost = "smtp.gmail.com";
String username = "pradeepcyfuturemeghdoot@gmail.com"; // Office 365 email address
String password = "mgujrlhbvqcecwpb";

 
//address

Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.host", smtpHost);
props.put("mail.smtp.port", smtpPort);
props.put("mail.smtp.ssl.protocols", "TLSv1.2");

Session session = Session.getInstance(props);

try {
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, address);
            message.setFrom(new InternetAddress(username));
            message.setSubject(subject);

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();

            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect(smtpHost, smtpPort, username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
           System.out.println("email sent!!");

} catch (Exception e) {
            System.out.println("error in sending mail" + e);
}

}
	}
