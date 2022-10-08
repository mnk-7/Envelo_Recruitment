package com.envelo.exercises.ex3.connectionApi;

import com.envelo.exercises.ex3.entities.Quote;
import com.envelo.exercises.ex3.constants.Error;
import com.envelo.exercises.ex3.constants.Source;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QuotesApi {

    public static Quote callApi() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Source.QUOTE_API_ADDRESS))
                .GET()
                .build();
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new QuotesApiException(Error.API_CONNECTION_ERROR);
        }

        String body = response.body();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(body, Quote.class);
        } catch (JsonProcessingException e) {
            throw new QuotesApiException(Error.JSON_PROCESSING_ERROR);
        }
    }

}
