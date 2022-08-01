package com.example.mailanalysateur.Service;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.mail.MailReceiver;
import org.springframework.integration.mail.Pop3MailReceiver;
import org.springframework.mail.MailMessage;
import org.springframework.stereotype.Service;

import com.example.mailanalysateur.Entity.EmailDetails;


@Service
public class ReceiveMailImpl implements ReceiveMail {

	 @Value("${spring.mail.username}")private String user;
	 @Value("${spring.mail.password}")private String password;
	public String checkmail(String host, String stereotype) {
		 try {
             Properties properties = new Properties();
             properties.put("mail.pop3.host", host);
             properties.put("mail.pop3.port", "995");
             properties.put("mail.pop3.starttls.enable", "true");
             Session emailsession = Session.getInstance(properties);

             Store store = emailsession.getStore("pop3s");
             store.connect(host, user, password);

             Folder emailfolder = store.getFolder("INBOX");
             emailfolder.open(Folder.READ_WRITE);

             Message messages[] = emailfolder.getMessages();

             String result;
             int i = messages.length - 1;
             result="les nombre de message reçu est "+messages.length;
             for (int x=0;x<i;x++) {
             Message message = messages[x];
             result = result +"||"+"From " + message.getFrom() + " / subject " + message.getSubject() + "/ contenue " + message.getDescription();
             }
             
             emailfolder.close(true);
             return result;
         } catch (NoSuchProviderException e) {
             return "no provider exception";
         } catch (MessagingException e) {
             return "messaging exception";
         } catch (Exception e) {
             return "other exception";
         }
	}

	@Override
	public String verifiermail() {
		MailReceiver mailReceiver=new Pop3MailReceiver("mail.pop3.host",user,password);
		   try {
			   	 Object[] msg = mailReceiver.receive();
				   return msg.toString();
			   
			   
	   }catch (MessagingException e) {
		   			return "error";
	}
	}

}
