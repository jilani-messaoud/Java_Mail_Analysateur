package com.example.mailanalysateur.Exception;


public class MailNotFoundException extends RuntimeException{
	public MailNotFoundException(String message)  {
        super(message);
    }
}
