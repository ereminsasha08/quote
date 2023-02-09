package com.kameleoon.quote.controller;

import com.kameleoon.quote.service.quote.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(QuoteController.API_URL)
@RequiredArgsConstructor
public class QuoteController {
    public final static String API_URL = "api/quotes";

    private final QuoteService quoteService;
}
