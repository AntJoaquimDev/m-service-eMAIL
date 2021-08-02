package com.msemail.services;

import com.msemail.enuns.StatusEmail;
import com.msemail.models.EmailModel;
import com.msemail.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServices {
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
            emailModel.setSendDateEmail(LocalDateTime.now());
            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom(emailModel.getEmailFrom());
                message.setTo(emailModel.getEmailTO());
                message.setSubject(emailModel.getSubject());
                message.setText(emailModel.getText());

                emailSender.send(message);

                emailModel.setStatusEmail(StatusEmail.SENT);

            }catch (MailException e){
                emailModel.setStatusEmail(StatusEmail.ERROR);
            }finally {
                return emailRepository.save(emailModel);
            }
    }
}
