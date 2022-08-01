package com.example.mailanalysateur.Reposotory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.mailanalysateur.Entity.EmailDetails;





public interface Mailrepo extends JpaRepository<EmailDetails, Long> {
	Optional<EmailDetails> FindMailById(Long id);
	@Transactional
    @Modifying
    @Query("delete from Mail m")
    void deleteMailById(Long  id);
	EmailDetails save(EmailDetails mail);
	List<EmailDetails> findAll();

}
