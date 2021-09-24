package com.epam.tc.hw9;

import static com.epam.tc.hw9.constans.Constants.DEFAULT_BOARD_NAME;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class BoardWithListDeletingTest extends SetUp {
    public Map<String, String> params = new HashMap<>();
    public Map<String, String> listParams = new HashMap<>();

    @Test()
    public void listDeleting() {
        params.put("name", DEFAULT_BOARD_NAME);
        boardDTO = restTrelloService.createNewBoard(params);
        listDTO = restTrelloService.createNewList(listParams, boardDTO);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardDeleted(response);
        listAssertions.assertListNotExist(listDTO);
    }
}
