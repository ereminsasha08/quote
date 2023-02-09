package com.kameleoon.quote.service.quote;

import com.kameleoon.quote.domain.support.AuthUser;
import com.kameleoon.quote.to.quote.QuoteTo;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface QuoteService {
    List<QuoteTo> getTenTopQuotes();

    QuoteTo getQuoteWithStatistic(Integer id);

    QuoteTo save(QuoteTo quoteTo, @NotNull AuthUser authUser);

    void addVote(AuthUser authUser, Integer id, Boolean like);

    void delete(Integer id);

    QuoteTo update(Integer id, QuoteTo quoteTo);
}
