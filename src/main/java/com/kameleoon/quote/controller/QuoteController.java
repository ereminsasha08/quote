package com.kameleoon.quote.controller;

import com.kameleoon.quote.domain.support.AuthUser;
import com.kameleoon.quote.service.quote.QuoteService;
import com.kameleoon.quote.to.quote.QuoteTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(QuoteController.API_URL)
@RequiredArgsConstructor
public class QuoteController {
    public final static String API_URL = "api/quotes";

    private final QuoteService quoteService;

    @GetMapping
    public List<QuoteTo> tenTopQuotes() {
        return quoteService.getTenTopQuotes();
    }

    @GetMapping("/{id}")
    public QuoteTo getStatistic(@PathVariable Integer id) {
        return quoteService.getQuoteWithStatistic(id);
    }

    @PostMapping
    public ResponseEntity<QuoteTo> create(@Valid @RequestBody QuoteTo quoteTo, @AuthenticationPrincipal AuthUser authUser) {
        QuoteTo created = quoteService.save(quoteTo, authUser);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(API_URL + "/" + created.id()).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PatchMapping("{id}")
    public QuoteTo updateQuote(@PathVariable Integer id, @Valid @RequestBody QuoteTo quoteTo) {
        return quoteService.update(id, quoteTo);
    }

    @PatchMapping("{id}/vote/{like}")
    public void addVote(@AuthenticationPrincipal AuthUser authUser,
                        @PathVariable Integer id,
                        @PathVariable Boolean like) {
        quoteService.addVote(authUser, id, like);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        quoteService.delete(id);
    }
}
