package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloConfigTestSuite {



    @Autowired
    TrelloConfig trelloConfig;


    @Test
    void testGetTrelloApiEndpoint(){
        //Given
        String apiEndpoint = trelloConfig.getTrelloApiEndpoint();

        //When


        //Then
        assertEquals("https://api.trello.com/1", apiEndpoint);
    }

    @Test
    void testGetTrelloAppKey(){
        //Given
        String appKey = trelloConfig.getTrelloAppKey();

        //When


        //Then
        assertEquals("683e3bbedbee4521d1ec535a9d16f2a9", appKey);
    }

    @Test
    void testGetTrelloToken(){
        //Given
        String token = trelloConfig.getTrelloToken();

        //When


        //Then
        assertEquals("20fa847544b84a27ccd653a6f50c2794244ef6ad5d6a02b665bc6df63615b9aa", token);
    }

    @Test
    void testGetTrelloUsername(){
        //Given
        String username = trelloConfig.getTrelloUsername();

        //When


        //Then
        assertEquals("sebaszymek", username);
    }

}
