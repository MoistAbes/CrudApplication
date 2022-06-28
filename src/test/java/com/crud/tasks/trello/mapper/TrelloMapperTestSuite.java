package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards(){

        //Given
        TrelloListDto listDto = new TrelloListDto("1", "testList", false);
        TrelloListDto listDto2 = new TrelloListDto("2", "testList2", true);

        List<TrelloListDto> listsDtoList = Arrays.asList(listDto, listDto2);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "testBoard", listsDtoList);
        List<TrelloBoardDto> trelloBoardDtoList = List.of(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals("1", trelloBoards.get(0).getId());
        assertEquals("testBoard", trelloBoards.get(0).getName());
        assertEquals(1, trelloBoards.size());
        assertEquals(2, trelloBoards.get(0).getLists().size());
        assertEquals("testList", trelloBoards.get(0).getLists().get(0).getName());

    }

    @Test
    public void testMapToBoardsDto(){

        //Given
        TrelloList listDto = new TrelloList("1", "testList", false);
        TrelloList listDto2 = new TrelloList("2", "testList2", true);

        List<TrelloList> listsDtoList = Arrays.asList(listDto, listDto2);

        TrelloBoard trelloBoardDto = new TrelloBoard("1", "testBoard", listsDtoList);
        List<TrelloBoard> trelloBoardList = List.of(trelloBoardDto);

        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals("1", trelloBoardsDto.get(0).getId());
        assertEquals("testBoard", trelloBoardsDto.get(0).getName());
        assertEquals(1, trelloBoardsDto.size());
        assertEquals(2, trelloBoardsDto.get(0).getLists().size());
        assertEquals("testList", trelloBoardsDto.get(0).getLists().get(0).getName());

    }

    @Test
    public void testMapToCard(){

        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("testName", "testDesc", "top", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("testName", trelloCard.getName());
        assertEquals("testDesc", trelloCard.getDescription());
        assertEquals("top", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());

    }

    @Test
    public void testMapToCardDto(){

        //Given
        TrelloCard trelloCard = new TrelloCard("testName", "testDesc", "top", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("testName", trelloCardDto.getName());
        assertEquals("testDesc", trelloCardDto.getDescription());
        assertEquals("top", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }

}
