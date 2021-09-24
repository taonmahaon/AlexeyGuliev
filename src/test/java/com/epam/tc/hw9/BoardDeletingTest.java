package com.epam.tc.hw9;

import static com.epam.tc.hw9.constans.Constants.DEFAULT_BOARD_NAME;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class BoardDeletingTest extends SetUp {
    public Map<String, String> params = new HashMap<>();

    @Test()
    public void boardDeleting() {
        params.put("name", DEFAULT_BOARD_NAME);
        boardDTO = restTrelloService.createNewBoard(params);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardDeleted(response);
    }
}
