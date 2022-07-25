package com.kkulpa.kodillalibrary.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name ="lendings")
public class Lending {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book lentBook;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
    private User borrower;

    @Column(name = "lent_date")
    private LocalDate lentDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

}
