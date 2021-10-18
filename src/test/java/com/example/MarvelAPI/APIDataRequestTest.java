package com.example.MarvelAPI;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class APIDataRequestTest {

    APIDataRequest apiRequest = new APIDataRequest();

    public APIDataRequestTest() throws IOException, ParseException {
    }

    @Test
    @DisplayName("It should give a Response code.")
    public void printNumber() throws Exception {
        apiRequest.getAPI();
    }
}
