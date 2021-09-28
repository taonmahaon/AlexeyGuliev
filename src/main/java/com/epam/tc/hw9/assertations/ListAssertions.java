package com.epam.tc.hw9.assertations;

import static org.testng.Assert.assertEquals;

import com.epam.tc.hw9.dto.board.BoardDTO;
import io.restassured.response.Response;

public class ListAssertions {
    public void assertListNotExist(Response response) {
        assertEquals(response.asPrettyString(), "model not found",
            String.format("Response does not match what is expected"
            + " (\"model not found\"), see response: %s", response.asPrettyString()));
    }

    public void assertCreatingOnDeletedBoard(BoardDTO boardDTO, Response response) {
        assertEquals(response.asPrettyString(),
            String.format("unauthorized board list requested %s", boardDTO.getId()),
            String.format("Response does not match what is expected"
                + " (%s), see response: %s", String.format("unauthorized board list requested %s", boardDTO.getId()),
                response.asPrettyString()));
    }
}
