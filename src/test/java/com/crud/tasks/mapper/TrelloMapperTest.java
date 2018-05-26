package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {
    @InjectMocks
    private TrelloMapper trelloMapper;


    @Test
    public void shouldMapToBoards(){
        //Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test_list", false));
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("1", "test_board", trelloLists));

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        assertNotNull(trelloBoards);
        assertEquals(1, trelloBoards.size());
        assertEquals("test_board", trelloBoards.get(0).getName());
    }

    @Test
    public void shouldMapToBoardsDto(){
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test_list", false));
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test_board", trelloLists));

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertNotNull(trelloBoards);
        assertEquals(1, trelloBoardDtos.size());
        assertEquals("test_board", trelloBoardDtos.get(0).getName());
    }

    @Test
    public void shouldMapToList(){
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "test_list", false));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertNotNull(trelloLists);
        assertEquals(1, trelloLists.size());
        assertEquals("1", trelloLists.get(0).getId());
    }

    @Test
    public void shouldMapToListDto(){
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test_list", false));

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertNotNull(trelloListDtos);
        assertEquals(1, trelloListDtos.size());
        assertEquals("1", trelloListDtos.get(0).getId());
    }

    @Test
    public void shouldMapToCard(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test_card", "test_description", "top", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertNotNull(trelloCard);
        assertEquals("test_card", trelloCard.getName());
    }

    @Test
    public void shouldMapToCardDto(){
        //Given
        TrelloCard trelloCard = new TrelloCard("test_card", "test_description", "top", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertNotNull(trelloCardDto);
        assertEquals("test_card", trelloCardDto.getName());
    }
}
