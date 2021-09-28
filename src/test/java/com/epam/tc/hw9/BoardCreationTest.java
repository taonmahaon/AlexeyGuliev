package com.epam.tc.hw9;

import org.testng.annotations.Test;

public class BoardCreationTest extends SetUp {

    @Test(dataProvider = "testData", dataProviderClass = TestData.class)
    public void confirmBoardCreation(String name) {
        boardDTO = restTrelloService.createNewBoard(name);
        boardDTO = restTrelloService.getBoard(boardDTO.getId());
        boardAssertions.assertBoardName(boardDTO, name);
        boardAssertions.boardHasId(boardDTO);
    }
}
