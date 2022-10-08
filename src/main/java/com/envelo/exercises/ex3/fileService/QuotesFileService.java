package com.envelo.exercises.ex3.fileService;

import com.envelo.exercises.ex3.entities.Quote;
import com.envelo.exercises.ex3.constants.Error;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuotesFileService {

    public static void saveQuote(String path, Quote quote) {
        try {
            Files.write(Path.of(path), quote.getQuote().concat("\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new QuotesFileException(Error.FILE_PROCESSING_ERROR);
        }
    }

    public static Optional<Quote> findQuote(String path, Quote quote) {
        List<Quote> quotes = getQuotes(path);
        return quotes.stream()
                .filter(q -> q.getQuote().equals(quote.getQuote()))
                .findFirst();
    }

    public static List<Quote> getQuotes(String path) {
        List<Quote> quotes = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            for (String line : lines) {
                quotes.add(new Quote(line));
            }
        } catch (IOException e) {
            throw new QuotesFileException(Error.FILE_PROCESSING_ERROR);
        }
        return quotes;
    }

    public static void deleteQuotes(String path) {
        try {
            Files.write(Path.of(path), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new QuotesFileException(Error.FILE_PROCESSING_ERROR);
        }
    }

}
