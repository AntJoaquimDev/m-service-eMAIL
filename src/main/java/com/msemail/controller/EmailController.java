package com.msemail.controller;

import com.msemail.dtos.EmailDto;
import com.msemail.models.EmailModel;
import com.msemail.services.EmailServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailServices emailServices;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties( emailDto, emailModel);
        emailServices.sendEmail(emailModel);
        return  new ResponseEntity<>(emailModel, HttpStatus.CREATED);

    }

}
