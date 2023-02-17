package com.mogreene.jsp_servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public interface Service {

    public Object execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException;
}
