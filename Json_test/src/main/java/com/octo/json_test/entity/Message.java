package com.octo.json_test.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity(name = "messages")
public class Message implements Comparable<Message> {

    public static final Integer TYPE_NOTIFICATION = 0;
    public static final Integer TYPE_GROUP_NOTIFICATION = 1;
    public static final Integer TYPE_MASS_NOTIFICATION = 2;
    public static final Integer TYPE_3DS = 3;
    public static final String STATUS_NEW = "new";
    public static final String STATUS_IN_PROGRESS = "in progress";
    public static final String STATUS_DELIVERED = "delivered";
    @Id
    @SequenceGenerator(name = "messageIdGenerator", sequenceName = "message_id_seq", schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageIdGenerator")
    private Long id;

    private String serverMessageId;

    private String text;

    private String destAddress;

    private String sourceAddress;

    private String status;

    private Integer type;

    private Date createTime;

    public Message(String sessionId, String text, String destAddress, String sourceAddress) {
        this.serverMessageId = sessionId;
        this.text = text;
        this.destAddress = destAddress;
        this.sourceAddress = sourceAddress;
        this.status = STATUS_NEW;
    }

    @Override
    public int compareTo(Message other) {
        if(other == null){
            return -2;
        }
        if (other.type < this.type) {
            return -1;
        } else if (other.type.equals(this.type)) {
            return 0;
        } else {
            return 1;
        }
    }
}
