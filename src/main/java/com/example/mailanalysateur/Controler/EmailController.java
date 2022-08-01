package com.example.mailanalysateur.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mailanalysateur.Entity.EmailDetails;
import com.example.mailanalysateur.Reposotory.mailreposervice;
import com.example.mailanalysateur.Service.EmailService;
import com.example.mailanalysateur.Service.ReceiveMail;



@RestController
public class EmailController {
	@Autowired private mailreposervice mailreposervice;
	 @Autowired private EmailService emailService;
	    @Autowired private ReceiveMail receiveMail;
	    // Sending a simple Email
	    @PostMapping("/sendMail")
	    public String
	    sendMail(@RequestBody EmailDetails details)
	    {
	        String status
	                = emailService.sendSimpleMail(details);
	       
	        return status;
	    }

	    // Sending email with attachment
	    @PostMapping("/sendMailWithAttachment")
	    public String sendMailWithAttachment(
	            @RequestBody EmailDetails details)
	    {
	        String status
	                = emailService.sendMailWithAttachment(details);
	        
	        return status;
	    }

	    @GetMapping("checkmail")
	    public String checkmail(){
	        String result
	                = receiveMail.checkmail("pop.gmail.com","pop3");
	        return result;
	    }
	    
	    @GetMapping("getmail")
	    public String verifiermail(){
	        String result
	                = receiveMail.verifiermail();
	        return result;
	    }

}
