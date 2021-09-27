package com.epam.tc.hw9;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class BoardDeletingTest extends SetUp {
    public Map<String, String> params = new HashMap<>();

    @Test()
    public void boardDeleting() {
        boardDTO = restTrelloService.createNewBoard(params);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardDeleted(response);
    }
}
