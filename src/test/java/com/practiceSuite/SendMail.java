package com.practiceSuite;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public SendMail() throws MessagingException {
		String host = "smtp.gmail.com";
		String Password = "zlcffhajopljdgcb";
		String from = "singh.saurabh5686@gmail.com";
		String toAddress = "singh.saurabh5686@gmail.com";
		String filename = "C:\\Workspace\\Automation_Hybrid\\Temp\\AutomationReport.html";
		// Get system properties
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(props, null);

		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));

		message.setRecipients(Message.RecipientType.TO, toAddress);

		message.setSubject("JavaMail Attachment");

		BodyPart messageBodyPart = new MimeBodyPart();

		messageBodyPart.setText("Here's the file");

		Multipart multipart = new MimeMultipart();

		multipart.addBodyPart(messageBodyPart);

		messageBodyPart = new MimeBodyPart();

		DataSource source = new FileDataSource(filename);

		messageBodyPart.setDataHandler(new DataHandler(source));

		messageBodyPart.setFileName(filename);

		multipart.addBodyPart(messageBodyPart);

		message.setContent(multipart);

		try {
			Transport tr = session.getTransport("smtps");
			tr.connect(host, from, Password);
			tr.sendMessage(message, message.getAllRecipients());
			System.out.println("Mail Sent Successfully");
			tr.close();

		} catch (SendFailedException sfe) {

			System.out.println(sfe);
		}
	}

	public static void main(String args[]) {
		try {
			SendMail sm = new SendMail();
		} catch (MessagingException ex) {
			Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
