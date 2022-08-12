package com.octo.json_test.sms.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sms {

    @Id
    @SequenceGenerator (name = "messageIdGenerator", sequenceName = "message_id_seq", schema = "public", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "messageIdGenerator")
    private Long id;

    private String originator;

    @ManyToOne
    private Content content;

}
