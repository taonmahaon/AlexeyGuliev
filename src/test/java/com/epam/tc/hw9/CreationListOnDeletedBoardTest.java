package com.epam.tc.hw9;

import org.testng.annotations.Test;

public class CreationListOnDeletedBoardTest extends SetUp {

    @Test(dataProvider = "testData", dataProviderClass = TestData.class)
    public void confirmBoardCreation(String name) {
        boardDTO = restTrelloService.createNewBoard(name);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardDeleted(response);
        response = restTrelloService.createNewListResponse(name, boardDTO);
        listAssertions.assertCreatingOnDeletedBoard(boardDTO, response);
    }
}
