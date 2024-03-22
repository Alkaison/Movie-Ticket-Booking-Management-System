package application;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailCodeByAmit {
	public static void main(String[] args) {
		System.out.println("Sending Email process...");

		String message = "Welcome to JavaFX Movie Ticket Booking Management System Project! Regards, Team Alkaison.";
		String subject = "Welcome to the Team!";
		String to = "gmfalcongamer@gmail.com";

		// Assuming Address is javax.mail.Address
		Address from = null;
		try {
			from = new InternetAddress("amitnare4303@gmail.com");
		} catch (AddressException e) {
			e.printStackTrace();
		}

		sendEmail(message, subject, to, from);
	}

	private static void sendEmail(String message, String subject, String to, Address from) {
		String host = "smtp.gmail.com";

		// get system properties
		Properties prop = System.getProperties();
		System.out.println("Properties : " + prop);

		// set info to properties object
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Enable TLS 1.2 protocol
		prop.put("mail.smtp.auth", "true");

		// get session object
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("amitnare4303@gmail.com", "psgxoxgrucvnpyhe");
			}
		});

		session.setDebug(true);

		// set message body
		MimeMessage msg = new MimeMessage(session);

		// from email
		try {
			msg.setFrom(from);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);

			// send email
			Transport.send(msg);
			System.out.println("Send successful..");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
