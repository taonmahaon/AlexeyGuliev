package com.epam.tc.hw9;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class CreationListOnDeletedBoardTest extends SetUp {
    public Map<String, String> params = new HashMap<>();
    public Map<String, String> listParams = new HashMap<>();

    @Test()
    public void confirmBoardCreation() {
        boardDTO = restTrelloService.createNewBoard(params);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardDeleted(response);
        listAssertions.assertCreatingOnDeletedBoard(listParams, boardDTO);
    }
}
