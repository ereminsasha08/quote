package com.kameleoon.quote.domain.quote;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kameleoon.quote.domain.abstracts.BaseEntity;
import com.kameleoon.quote.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Table(name = "quote")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Quote extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    @JsonIgnore
    private User user;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "content", nullable = false, updatable = true)
    @Length(min = 10, max = 500, message = "Length content must be between 10 to 500 sign")
    private String content;

    @Column(name = "score")
    private int score;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "vote",
            joinColumns = @JoinColumn(name = "quote_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "quote_id"}, name = "uk_user_quote")
    )
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<Vote> votes = new LinkedList<>();

    public Quote(Integer id, User user, String author, String content) {
        super(id);
        this.user = user;
        this.author = author;
        this.content = content;
    }
}
