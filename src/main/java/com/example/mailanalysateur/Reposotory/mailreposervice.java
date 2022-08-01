package com.example.mailanalysateur.Reposotory;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mailanalysateur.Entity.EmailDetails;
import com.example.mailanalysateur.Exception.MailNotFoundException;


@Service
@Transactional
public class mailreposervice  {
	  private  Mailrepo mailrepo;
	    @Autowired
	    public mailreposervice(Mailrepo mailrepo) {
	        this.mailrepo = mailrepo;
	    }
	   
	    public EmailDetails addMail(EmailDetails mail){
	       return mailrepo.save(mail);
	    }
	    public List<EmailDetails> findallmail(){
	        return mailrepo.findAll();
	    }

	    public EmailDetails findMailById(Long id) {
	        return mailrepo.FindMailById(id).orElseThrow(() -> new MailNotFoundException("mail "+ id + "interoperable "));

	    }

	    public void deleteMail(Long id){
	        mailrepo.deleteMailById(id);
	    }
	

}
