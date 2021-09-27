package com.epam.tc.hw9.assertations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;

import com.epam.tc.hw9.dto.board.BoardDTO;
import io.restassured.response.Response;

public class BoardAssertions {
    public void assertBoardName(BoardDTO boardDTO, String boardName) {
        assertEquals(boardDTO.getName(), boardName,
            String.format("The boardName %s does not match what is expected (%s)", boardDTO.getName(), boardName));
    }

    public void boardHasId(BoardDTO boardDTO) {
        assertNotEquals(boardDTO.getId(), null, "Board must have ID");
    }

    public void boardDeleted(Response response) {
        assertNull(response.path("_value"), String.format("Response does not contain '_value' = null, %s", response));
    }

    public void boardNotExist(Response response) {
        assertEquals(response.asPrettyString(), "The requested resource was not found.",
            String.format("Response does not match what is expected"
                + " (\"The requested resource was not found.\"), see response: %s", response.asPrettyString()));
    }
}
