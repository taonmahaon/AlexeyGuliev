package com.epam.tc.hw9.assertations;

import static com.epam.tc.hw9.constans.Endpoints.LISTS;
import static org.testng.Assert.assertEquals;

import com.epam.tc.hw9.dto.board.BoardDTO;
import com.epam.tc.hw9.dto.list.ListDTO;
import com.epam.tc.hw9.services.CommonService;
import com.epam.tc.hw9.services.RestTrelloService;
import com.epam.tc.hw9.utils.GetPropertyFile;
import io.restassured.response.Response;
import java.util.Map;

public class ListAssertions {
    RestTrelloService restTrelloService = new RestTrelloService();

    public void assertListNotExist(ListDTO listDTO) {
        Response response = restTrelloService.getListResponse(listDTO.getId());
        assertEquals(response.asPrettyString(), "model not found", String.format("Response does not match what is expected"
            + " (\"model not found\"), see response: %s", response.asPrettyString()));
    }

    public void assertCreatingOnDeletedBoard(Map<String, String> params, BoardDTO boardDTO) {
        params.put("name", (GetPropertyFile.getProperty("src/test/resources/testHw9.properties")
                                           .getProperty("DEFAULT_LIST_NAME")));
        params.put("idBoard", boardDTO.getId());
        Response response = new CommonService()
            .postWithParams(LISTS, params);
        assertEquals(response.asPrettyString(),
            String.format("unauthorized board list requested %s", boardDTO.getId()),
            String.format("Response does not match what is expected"
                + " (%s), see response: %s", String.format("unauthorized board list requested %s", boardDTO.getId()),
                response.asPrettyString()));
    }
}
