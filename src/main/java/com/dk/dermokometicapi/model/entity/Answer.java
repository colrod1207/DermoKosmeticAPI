package com.dk.dermokometicapi.model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String content;

    @Column(nullable = false)
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(
            name = "parent_id",
            referencedColumnName = "id",
            nullable = true
    )
    private Answer parentAnswer;

    @ManyToOne
    @JoinColumn(
            name = "question_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Question question;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User user;

    @OneToMany
    @JoinColumn(
            name = "like_id",
            referencedColumnName = "id",
            nullable = true
    )
    private List<AnswerLike> likes;
}
