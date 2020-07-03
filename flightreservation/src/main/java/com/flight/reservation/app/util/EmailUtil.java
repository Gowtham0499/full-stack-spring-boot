package com.flight.reservation.app.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	private JavaMailSender mailsender;

	public void sendItinerary(String toAddress, String filePath) {
		MimeMessage message = mailsender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toAddress);
			helper.setSubject("Itinerary for your Flight");
			helper.setText("Please Find your Itinerary attached.");
			helper.addAttachment("Itinerary", new File(filePath));
			mailsender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
