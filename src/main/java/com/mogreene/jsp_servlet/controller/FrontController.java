package com.mogreene.jsp_servlet.controller;

import com.mogreene.jsp_servlet.command.BoardCommand;
import com.mogreene.jsp_servlet.dto.BoardDTO;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@Log4j2
@WebServlet("*.do")
public class FrontController extends HttpServlet {

    public FrontController() {
        super();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        actionDo(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        actionDo(req, resp);
    }

    private void actionDo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        log.info("actionDo...");
        RequestDispatcher dispatcher = null;

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String command = uri.substring(contextPath.length());
        log.info("command : " + command);

        if (command.equals("/board/list.do")) {
            log.info("/board/list.do...");
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<head></head>");

            Service service = new BoardCommand();
            List<BoardDTO> dtoList = (List<BoardDTO>) service.execute(req, resp);
            log.info("dtoList : " + dtoList);
        }
    }
}
