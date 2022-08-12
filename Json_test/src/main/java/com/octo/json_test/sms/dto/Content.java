package com.octo.json_test.sms.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Content {

    @Id
    @SequenceGenerator (name = "messageIdGenerator", sequenceName = "message_id_seq", schema = "public", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "messageIdGenerator")
    private Long id;

    private String text;
}
