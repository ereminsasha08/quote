package com.kameleoon.quote.repository.quote;

import com.kameleoon.quote.domain.quote.Quote;
import com.kameleoon.quote.repository.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;
@NoRepositoryBean
public interface QuoteRepository extends BaseRepository<Quote> {
    List<Quote> findTopQuotes(Pageable pageable);

    Optional<Quote> findById(Integer id);

}
