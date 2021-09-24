package com.epam.tc.hw9.assertations;

import static com.epam.tc.hw9.constans.Constants.DEFAULT_LIST_NAME;
import static com.epam.tc.hw9.constans.Endpoints.GET_LIST;
import static com.epam.tc.hw9.constans.Endpoints.LISTS;
import static org.testng.Assert.assertEquals;

import com.epam.tc.hw9.dto.board.BoardDTO;
import com.epam.tc.hw9.dto.list.ListDTO;
import com.epam.tc.hw9.services.CommonService;
import io.restassured.response.Response;
import java.util.Map;

public class ListAssertions {
    public void assertListNotExist(ListDTO listDTO) {
        Response response = new CommonService()
            .getNoParams(String.format(GET_LIST, listDTO.getId()));
        assertEquals(response.asPrettyString(), "model not found");
    }

    public void assertCreatingOnDeletedBoard(Map<String, String> params, BoardDTO boardDTO) {
        params.put("name", DEFAULT_LIST_NAME);
        params.put("idBoard", boardDTO.getId());
        Response response = new CommonService()
            .postWithParams(LISTS, params);
        assertEquals(response.asPrettyString(),
            String.format("unauthorized board list requested %s", boardDTO.getId()));
    }
}
