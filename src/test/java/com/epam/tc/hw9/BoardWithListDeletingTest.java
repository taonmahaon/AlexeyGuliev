package com.epam.tc.hw9;

import org.testng.annotations.Test;

public class BoardWithListDeletingTest extends SetUp {

    @Test(dataProvider = "testData", dataProviderClass = TestData.class)
    public void listDeleting(String name) {
        boardDTO = restTrelloService.createNewBoard(name);
        listDTO = restTrelloService.createNewList(name, boardDTO);
        response = restTrelloService.deleteBoard(boardDTO.getId());
        boardAssertions.boardDeleted(response);
        response = restTrelloService.getListResponse(listDTO.getId());
        listAssertions.assertListNotExist(response);
    }
}
