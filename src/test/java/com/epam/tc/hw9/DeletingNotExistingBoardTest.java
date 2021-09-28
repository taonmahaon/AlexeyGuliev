package com.epam.tc.hw9;

import org.testng.annotations.Test;

public class DeletingNotExistingBoardTest extends SetUp {

    @Test(dataProvider = "testData", dataProviderClass = TestData.class)
    public void confirmBoardCreation(String name) {
        boardDTO = restTrelloService.createNewBoard(name);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardDeleted(response);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardNotExist(response);
    }
}
