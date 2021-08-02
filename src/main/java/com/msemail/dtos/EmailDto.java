package com.msemail.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {

    @NotBlank
    private String ownerRef;    // referencia de qm esta mandando o email
    @NotBlank
    @Email
    private String emailFrom;  //  qm esta mandando o email

    @NotBlank
   @Email
    private String emailTO;   // qm esta recebendo o email
    @NotBlank
    private String subject;   // titulo do email
    @NotBlank
    private String text;
}
