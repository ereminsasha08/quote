package com.kameleoon.quote.to.quote;

import com.kameleoon.quote.domain.quote.Vote;
import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.to.BaseTo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class QuoteTo extends BaseTo {

    @Null
    private String user;

    @NotNull
    private String author;

    @NotNull
    @Length(min = 10, max = 500, message = "Length content must be between 10 to 500 sign")
    private String content;

    private int score;
    @Null
    private List<Vote> votes;


    public QuoteTo(Integer id, User user, String author, String content, int score, List<Vote> votes) {
        super(id);
        this.user = user.getName();
        this.author = author;
        this.content = content;
        this.score = score;
        this.votes = votes;
    }
}
