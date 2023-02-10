package com.kameleoon.quote.service.quote;

import com.kameleoon.quote.domain.quote.Quote;
import com.kameleoon.quote.domain.quote.Vote;
import com.kameleoon.quote.domain.support.AuthUser;
import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.repository.quote.QuoteRepository;
import com.kameleoon.quote.service.user.UserService;
import com.kameleoon.quote.to.quote.QuoteTo;
import com.kameleoon.quote.util.QuoteUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class QuoteServiceImp implements QuoteService {

    private final QuoteRepository quoteRepository;

    private final UserService userService;


    @Override
    public List<QuoteTo> getTopQuotes() {
        log.info("Get top 10 quotes");
        List<Quote> tenTopQuotes = quoteRepository.findTopQuotes(PageRequest.of(0, 10));
        return tenTopQuotes.stream()
                .map(QuoteUtil::quoteWithoutStatistic)
                .sorted(Comparator.comparing(QuoteTo::getScore).reversed())
                .toList();
    }

    @Override
    public QuoteTo getQuoteWithStatistic(Integer id) {
        Quote existed = quoteRepository.getExisted(id);
        log.info("Get quote {}", existed);
        return QuoteUtil.quoteWithStatistic(existed);
    }

    @Override
    @Transactional
    public QuoteTo save(QuoteTo quoteTo, AuthUser authUser) {
        User user;
        if (!Objects.isNull(authUser))
            user = authUser.getUser();
        else user = userService.findByName("Anonymous");
        Quote newFromTo = QuoteUtil.createNewFromTo(quoteTo, user);
        Quote saveQuote = quoteRepository.save(newFromTo);
        log.info("Save quote {}", saveQuote);
        return QuoteUtil.quoteWithoutStatistic(saveQuote);
    }

    @Override
    @Transactional
    public void addVote(AuthUser authUser, Integer id, Boolean like) {
//        if (Objects.isNull(authUser))
//            throw new IllegalArgumentException("Голосовать могут только авторизованные пользователи");
//        Integer user_id = authUser.getUser().getId();
        Random random = new Random();
        int user_id = random.nextInt(1, 10);
        like = random.nextBoolean();

        Quote quote = quoteRepository.getExisted(id);
        List<Vote> votes = quote.getVotes();
        int score = quote.getScore();

        Optional<Vote> pastVote = votes.stream().filter(vote -> vote.getUserId() == user_id).findFirst();

        Vote newVote = new Vote(quote, user_id, like);
        score = calculationScore(like, votes, score, pastVote, newVote);
        quote.setScore(score);
        log.info("Update votes for quote {}", quote);
    }

    private static int calculationScore(Boolean like, List<Vote> votes, int score, Optional<Vote> pastVote, Vote newVote) {
        if (pastVote.isPresent() && pastVote.get().isVoteValue() == like) {
            votes.remove(pastVote.get());
            score = !like ? score + 1 : score - 1;
        }
        else if (pastVote.isPresent()) {
            votes.remove(pastVote.get());
            score = like ? score + 2 : score - 2;
            votes.add(newVote);
        } else {
            score = like ? score + 1 : score - 1;
            votes.add(newVote);
        }
        return score;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        quoteRepository.deleteById(id);
        log.info("Delete quote with id {}", id);
    }

    @Override
    @Transactional
    public QuoteTo update(Integer id, QuoteTo quoteTo) {
        Quote modify = quoteRepository.getExisted(id);
        modify.setAuthor(quoteTo.getAuthor());
        modify.setContent(quoteTo.getContent());
        log.info("Update quote {}", modify);
        return QuoteUtil.quoteWithoutStatistic(modify);
    }
}
