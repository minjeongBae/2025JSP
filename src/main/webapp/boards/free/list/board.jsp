<%@ page import="com.study.board.BoardDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.study.post.PostDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>
    tbody:hover {
        background-color: darkgray;
    }
</style>

<!DOCTYPE html>
<html>
<head>
    <title>게시판 JSP</title>
</head>
<body>
<h1><%= "자유 게시판 - 목록" %>
</h1>
<br/>

<form >
    등록일  <input type="date" id = "frontDate">
           <input type="date" id = "tailDate">
    <input type="text" id = "searchWord">
    <button type="submit">검색</button>
</form>

<%
    BoardDAO boardDao = new BoardDAO();
    List<PostDTO> board = boardDao.selectBoard();
%>

<br/>
<table style="text-align: center;"  border="1" >
    <thead>
        <tr>
            <th>카테고리</th>
            <th></th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>등록일시</th>
            <th>수정일시</th>
        </tr>
    </thead>
<%
    for(int i=0; i<board.size(); i++) {
%>
    <tbody>
        <tr onclick="showPost(<%= board.get(i).getPostId() %>)" style="padding: 2px">
            <td>
                <%
                    String category = "-";
                    if(board.get(i).getCategory() != null) {
                        category = String.valueOf(board.get(i).getCategory());
                    }
                %>
                <%= category%>
            </td>
            <td>
                <%= board.get(i).getFiles()%>
            </td>
            <td>
                <%= board.get(i).getTitle()%>
            </td>
            <td>
                <%= board.get(i).getWriter()%>
            </td>
            <td>
                <%= board.get(i).getViews()%>
            </td>
            <td>
                <%= board.get(i).getCreateDate()%>
            </td>
            <td>
                <%
                    String updateDate = "-";
                    if(board.get(i).getUpdateDate() != null) {
                        updateDate = String.valueOf(board.get(i).getUpdateDate());
                    }
                %>
                <%= updateDate%>
            </td>
        </tr>
    </tbody>
    <%
        }

    %>

</table>



</body>
</html>

<script type="text/javascript">
    function showPost(postId) {
        window.location.href = '/boards/free/list/post/post.jsp?postid=' + postId;
    }

</script>