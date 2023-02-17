package com.mogreene.jsp_servlet.command;

import com.mogreene.jsp_servlet.controller.Service;
import com.mogreene.jsp_servlet.dao.BoardDAO;
import com.mogreene.jsp_servlet.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@Log4j2
public class BoardCommand implements Service {

    @Override
    public Object execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        log.info("execute start...");
        BoardDAO dao = new BoardDAO();
        log.info("boardDAO get : " + dao);
        List<BoardDTO> dtoList = dao.getBoardList();
        log.info("BoardCommand execute : " + dtoList);
        return dtoList;
    }
}
