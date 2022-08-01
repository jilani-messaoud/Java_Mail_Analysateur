package com.example.mailanalysateur.Resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mailanalysateur.Entity.EmailDetails;
import com.example.mailanalysateur.Reposotory.mailreposervice;



@RestController
@RequestMapping("/mail")
public class MailResources {
	 private final mailreposervice mailservice;

	    public MailResources(mailreposervice mailservice) {
	        this.mailservice = mailservice;
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<EmailDetails>> getAllMail(){
	            List<EmailDetails> mails = (List<EmailDetails>) mailservice.findallmail();
	            return new ResponseEntity<>(mails, HttpStatus.OK);
	    }
	    @GetMapping("/find/{id}")
	    public ResponseEntity<EmailDetails> getEmployeeById (@PathVariable("id") Long id) {
	        EmailDetails mail = mailservice.findMailById(id);
	        return new ResponseEntity<>(mail, HttpStatus.OK);
	    }
	    @PostMapping("/add")
	    public ResponseEntity<EmailDetails> addEmployee(@RequestBody EmailDetails mail) {
	        EmailDetails newMail = mailservice.addMail(mail);
	        return new ResponseEntity<>(newMail, HttpStatus.CREATED);
	    }


}
