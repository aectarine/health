package com.ksd.health.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column
    private String content;

//    @ManyToOne
//    @JoinColumn(name = "post_seq")
//    private Post post;


}
