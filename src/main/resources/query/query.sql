/* 더미데이터 */
insert into board (title, content, writer, reg_date, password, cno)
    (select title, content, writer, reg_date, password, 1 from board);


SELECT bno, c.category, title, writer, view, reg_date as regDate, mod_date as modDate
FROM board
    JOIN category c on c.cno = board.cno
ORDER BY bno DESC
LIMIT 0, 5;

INSERT INTO board(cno, writer, password, title, content)
VALUES(?,?,?,?,?);