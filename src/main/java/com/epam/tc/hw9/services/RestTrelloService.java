package com.epam.tc.hw9.services;

import static com.epam.tc.hw9.constans.Constants.DEFAULT_BOARD_NAME;
import static com.epam.tc.hw9.constans.Constants.DEFAULT_LIST_NAME;
import static com.epam.tc.hw9.constans.Endpoints.BOARDS;
import static com.epam.tc.hw9.constans.Endpoints.GET_BOARD;
import static com.epam.tc.hw9.constans.Endpoints.GET_LIST;
import static com.epam.tc.hw9.constans.Endpoints.LISTS;

import com.epam.tc.hw9.dto.board.BoardDTO;
import com.epam.tc.hw9.dto.list.ListDTO;
import io.restassured.response.Response;
import java.util.Map;

public class RestTrelloService extends CommonService {
    public BoardDTO createNewBoard(Map<String, String> params) {
        params.put("name", DEFAULT_BOARD_NAME);
        return new CommonService()
            .postWithParams(BOARDS, params).as(BoardDTO.class);
    }

    public ListDTO createNewList(Map<String, String> params, BoardDTO boardDTO) {
        params.put("name", DEFAULT_LIST_NAME);
        params.put("idBoard", boardDTO.getId());
        return new CommonService()
            .postWithParams(LISTS, params).as(ListDTO.class);
    }

    public BoardDTO getBoard(String boardId) {
        return
            new CommonService()
                .getNoParams(String.format(GET_BOARD, boardId))
                .getBody().as(BoardDTO.class);
    }

    public ListDTO getList(String listId) {
        return
            new CommonService()
                .getNoParams(String.format(GET_LIST, listId))
                .getBody().as(ListDTO.class);
    }

    public Response deleteBoard(String boardId) {
        return
            new CommonService()
                .deleteNoParams(String.format(GET_BOARD, boardId));
    }

}
