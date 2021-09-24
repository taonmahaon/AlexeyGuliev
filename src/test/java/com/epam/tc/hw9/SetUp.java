package com.epam.tc.hw9;

import com.epam.tc.hw9.assertations.BoardAssertions;
import com.epam.tc.hw9.assertations.ListAssertions;
import com.epam.tc.hw9.dto.board.BoardDTO;
import com.epam.tc.hw9.dto.list.ListDTO;
import com.epam.tc.hw9.services.RestTrelloService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class SetUp {
    protected BoardDTO boardDTO;
    protected ListDTO listDTO;
    protected RestTrelloService restTrelloService;
    protected BoardAssertions boardAssertions;
    protected ListAssertions listAssertions;
    protected Response response;

    @BeforeClass
    public void setUp() {
        boardDTO = new BoardDTO();
        listDTO = new ListDTO();
        boardAssertions = new BoardAssertions();
        listAssertions = new ListAssertions();
        restTrelloService = new RestTrelloService();
    }
}
