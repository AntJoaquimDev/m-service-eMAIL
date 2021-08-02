package com.msemail.models;

import com.msemail.enuns.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
    private static final long serialVersionUId = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ownerRef;    // referencia de qm esta mandando o email
    private String emailFrom;  //  qm esta mandando o email
    private String emailTO;   // qm esta recebendo o email
    private String subject;   // titulo do email
    @Column(columnDefinition = "TEXT") // corpo do email testo
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;


}
