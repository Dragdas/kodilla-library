package com.kkulpa.kodillalibrary.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookStatus status;


}
