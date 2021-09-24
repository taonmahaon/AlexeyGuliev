package com.epam.tc.hw9.assertations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;

import com.epam.tc.hw9.dto.board.BoardDTO;
import com.epam.tc.hw9.services.RestTrelloService;
import io.restassured.response.Response;

public class BoardAssertions {
    public void assertBoardName(BoardDTO boardDTO, String boardName) {
        assertEquals(boardDTO.getName(), boardName);
    }

    public void boardHasId(BoardDTO boardDTO) {
        assertNotEquals(boardDTO.getId(), null);
    }

    public void boardDeleted(Response response) {
        assertNull(response.path("_value"));
    }

    public void boardNotExist(BoardDTO boardDTO) {
        Response response = new RestTrelloService().deleteBoard(boardDTO.getId());
        assertEquals(response.asPrettyString(), "The requested resource was not found.");
    }
}
