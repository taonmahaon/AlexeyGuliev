package com.epam.tc.hw9;

import org.testng.annotations.Test;

public class BoardDeletingTest extends SetUp {

    @Test(dataProvider = "testData", dataProviderClass = TestData.class)
    public void boardDeleting(String name) {
        boardDTO = restTrelloService.createNewBoard(name);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardDeleted(response);
    }
}
