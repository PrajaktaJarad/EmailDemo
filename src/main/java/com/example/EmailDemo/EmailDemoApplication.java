package com.example.EmailDemo;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.EmailDemo.service.EmailSenderService;

@SpringBootApplication
public class EmailDemoApplication {

	@Autowired
	private EmailSenderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailDemoApplication.class, args);
	}

	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendEmailWithAttachment("pjarad096@gmail.com", "This is Email Body with Attachment...", 
				                        "This email has attachment","C:\\Users\\admin\\Pictures\\17243649.jpg");

	}
}
