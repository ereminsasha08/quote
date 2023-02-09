package com.kameleoon.quote.util;

import com.kameleoon.quote.domain.quote.Quote;
import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.to.quote.QuoteTo;
import lombok.experimental.UtilityClass;

import java.util.Collections;

@UtilityClass
public class QuoteUtil {
    public static Quote createNewFromTo(QuoteTo quoteTo, User user) {
        return new Quote(null, user, quoteTo.getAuthor(), quoteTo.getContent());
    }

    public static QuoteTo quoteWithoutStatistic(Quote quote) {
        return new QuoteTo(quote.id(), quote.getUser(), quote.getAuthor(), quote.getContent(), quote.getScore(), Collections.emptyList());
    }

    public static QuoteTo quoteWithStatistic(Quote quote) {
        return new QuoteTo(quote.id(), quote.getUser(), quote.getAuthor(), quote.getContent(), quote.getScore(), quote.getVotes());
    }
}
