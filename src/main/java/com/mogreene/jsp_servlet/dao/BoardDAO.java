package com.mogreene.jsp_servlet.dao;

import com.mogreene.jsp_servlet.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

@Log4j2
public class BoardDAO{
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream configuration = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static final String namespace = "com.mogreene.jsp_servlet.mapper";

    /**
     * 전체 조회
     * @return List<BoardDTO>
     */
    public List<BoardDTO> getBoardList() throws SQLException {
        log.info("getBoardList...");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        log.info("got it?");
        try {
            List<BoardDTO> boardDTO = sqlSession.selectList(namespace + getBoardList());
            log.info("boardDTO : " + boardDTO);
            return boardDTO;
        } finally {
            sqlSession.close();
        }
    }

}
