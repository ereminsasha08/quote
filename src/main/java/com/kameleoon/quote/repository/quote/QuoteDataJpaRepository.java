package com.kameleoon.quote.repository.quote;

import com.kameleoon.quote.domain.quote.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuoteDataJpaRepository extends QuoteRepository {

    @Override
    @EntityGraph(attributePaths = ("user"))
    @Query("SELECT q from Quote q")
    List<Quote> findTenTopQuotes(Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"user", "votes"})
    @Query("SELECT q FROM Quote q WHERE q.id = :id")
    Quote get(int id);

}
