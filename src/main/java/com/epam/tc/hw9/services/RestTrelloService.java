package com.epam.tc.hw9.services;

import static com.epam.tc.hw9.constans.Endpoints.BOARDS;
import static com.epam.tc.hw9.constans.Endpoints.GET_BOARD;
import static com.epam.tc.hw9.constans.Endpoints.GET_LIST;
import static com.epam.tc.hw9.constans.Endpoints.LISTS;

import com.epam.tc.hw9.dto.board.BoardDTO;
import com.epam.tc.hw9.dto.list.ListDTO;
import com.epam.tc.hw9.utils.GetPropertyFile;
import io.restassured.response.Response;
import java.util.Map;

public class RestTrelloService extends CommonService {
    public BoardDTO createNewBoard(Map<String, String> params) {
        params.put("name", (GetPropertyFile.getProperty("src/test/resources/testHw9.properties")
                                           .getProperty("DEFAULT_BOARD_NAME")));
        return postWithParams(BOARDS, params).as(BoardDTO.class);
    }

    public ListDTO createNewList(Map<String, String> params, BoardDTO boardDTO) {
        params.put("name", (GetPropertyFile.getProperty("src/test/resources/testHw9.properties")
                                           .getProperty("DEFAULT_LIST_NAME")));
        params.put("idBoard", boardDTO.getId());
        return postWithParams(LISTS, params).as(ListDTO.class);
    }

    public BoardDTO getBoard(String boardId) {
        return getNoParams(String.format(GET_BOARD, boardId))
                .getBody().as(BoardDTO.class);
    }

    public Response getListResponse(String listId) {
        return getNoParams(String.format(GET_LIST, listId));
    }

    public ListDTO getList(String listId) {
        return getListResponse(listId)
                .getBody().as(ListDTO.class);
    }

    public Response deleteBoard(String boardId) {
        return deleteNoParams(String.format(GET_BOARD, boardId));
    }
}
