package com.epam.tc.hw9.services;

import static com.epam.tc.hw9.constans.Constants.DEFAULT_BOARD_NAME;
import static com.epam.tc.hw9.constans.Constants.DEFAULT_LIST_NAME;
import static com.epam.tc.hw9.constans.Endpoints.BOARDS;
import static com.epam.tc.hw9.constans.Endpoints.GET_BOARD;
import static com.epam.tc.hw9.constans.Endpoints.GET_LIST;
import static com.epam.tc.hw9.constans.Endpoints.LISTS;

import com.epam.tc.hw9.dto.board.BoardDTO;
import com.epam.tc.hw9.dto.list.ListDTO;
import com.epam.tc.hw9.utils.GetPropertyFile;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class RestTrelloService extends CommonService {
    public BoardDTO createNewBoard(String boardName) {
        Map<String, String> params = new HashMap<>();
        params.put("name", boardName);
        return postWithParams(BOARDS, params).as(BoardDTO.class);
    }

    public ListDTO createNewList(String listName, BoardDTO boardDTO) {
        return createNewListResponse(listName, boardDTO).as(ListDTO.class);
    }

    public Response createNewListResponse(String listName, BoardDTO boardDTO) {
        Map<String, String> params = new HashMap<>();
        params.put("name", listName);
        params.put("idBoard", boardDTO.getId());
        return postWithParams(LISTS, params);
    }

    public BoardDTO getBoard(String boardId) {
        return getNoParams(String.format(GET_BOARD, boardId))
                .getBody().as(BoardDTO.class);
    }

    public Response getListResponse(String listId) {
        return getNoParams(String.format(GET_LIST, listId));
    }

    public Response deleteBoard(String boardId) {
        return deleteNoParams(String.format(GET_BOARD, boardId));
    }
}
