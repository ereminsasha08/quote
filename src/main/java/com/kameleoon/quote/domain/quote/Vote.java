package com.kameleoon.quote.domain.quote;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Parent;

import javax.persistence.*;
import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
public class Vote {
    @Parent
    @Column(name = "quote_id")
    @JsonIgnore
    private Quote quote;
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "vote_value", nullable = false)
    private boolean voteValue;

    @Column(name = "date", columnDefinition = "timestamp default now()", updatable = false)
    private Date date = new Date();

    public Vote(Quote quote, int userId, boolean voteValue) {
        this.quote = quote;
        this.userId = userId;
        this.voteValue = voteValue;
    }

}
