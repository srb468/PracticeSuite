package com.practiceSuite;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava {

	public static void main(String args[]) throws EmailException {
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("C:\\Workspace\\Automation_Hybrid\\Temp\\AutomationReport.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Picture of John");
		  attachment.setName("John");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("mail.myserver.com");
		  email.addTo("singh.saurabh5686@gmail.com", "John Doe");
		  email.setFrom("singh.saurabh5686@gmail.com", "Me");
		  email.setSubject("The picture");
		  email.setMsg("Here is the picture you wanted");

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
	}
}
