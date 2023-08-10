-- myapp_member 테이블 예제 데이터
insert into myapp_member(member_no, name, email, weight, pnum, password, birth, gender) 
  values(1, 'aaa', 'aaa@test.com', '40', '010-0000-0000', sha1('1111'), '2000.1.13', 'W');
insert into myapp_member(member_no, name, email, weight, pnum, password, birth, gender) 
  values(2, 'bbb', 'bbb@test.com', '40', '010-2222-2222', sha1('1111'), '1999.2.23', 'M');
insert into myapp_member(member_no, name, email, weight, pnum, password, birth, gender) 
  values(3, 'ccc', 'ccc@test.com', '40', '010-3333-3333', sha1('1111'), '1970.6.15', 'W');
insert into myapp_member(member_no, name, email, weight, pnum, password, birth, gender) 
  values(4, 'ddd', 'ddd@test.com', '40', '010-4444-4444', sha1('1111'), '2008.1.13', 'M');
insert into myapp_member(member_no, name, email, weight, pnum, password, birth, gender) 
  values(5, 'eee', 'eee@test.com', '40','010-5555-5555', sha1('1111'), '2010.11.10', 'W');
insert into myapp_member(member_no, name, email, weight, pnum, password, birth, gender) 
  values(6, 'fff', 'fff@test.com', '40', '010-6666-6666', sha1('1111'), '1987.12.8', 'M');
insert into myapp_member(member_no, name, email, weight, pnum, password, birth, gender) 
  values(7, 'abc', 'abc@test.com', '300', '010-7777-7777', sha1('1111'), '1998.8.30', 'M');

-- myapp_board 테이블 예제 데이터
insert into myapp_board(board_no, title, content, writer, password, category)
  values(11, '제목1', '내용', 1, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(12, '제목2', '내용', 1, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(13, '제목3', '내용', 3, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(14, '제목4', '내용', 4, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(15, '제목5', '내용', 5, sha1('1111'), 2);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(16, '제목6', '내용', 5, sha1('1111'), 2);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(17, '제목7', '내용', 5, sha1('1111'), 2);