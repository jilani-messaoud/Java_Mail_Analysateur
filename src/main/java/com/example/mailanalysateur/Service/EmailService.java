package com.example.mailanalysateur.Service;

import com.example.mailanalysateur.Entity.EmailDetails;

public interface EmailService {
	 
	String sendSimpleMail(EmailDetails details);

	    // Method
	    // To send an email with attachment
	    String sendMailWithAttachment(EmailDetails details);
}
