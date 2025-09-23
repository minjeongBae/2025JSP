<%@ page import="java.util.List" %>
<%@ page import="com.study.board.post.PostDTO" %>
<%@ page import="java.util.Map" %>
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

<form action="/board-search" method="post">
    등록일  <input type="date" name = "frontDate">
           <input type="date" name = "tailDate">
           <input type="text" name = "searchWord">
    <input type="hidden" name="command" value="/board-search">
    <select name="category" size="1">
        <option value="">선택하세요.</option>
        <%
            Map<Integer, String> categories = (Map<Integer, String>) request.getAttribute("categories");
            for(Map.Entry<Integer,String> category : categories.entrySet()) {
        %>
            <option value="<%=category.getKey()%>"><%= category.getValue()%></option>
        <%
            }
        %>
    </select>
    <button type="submit">검색</button>
</form>

<br/>
<table style="text-align: center;"  border="1" >
    <thead>
        <tr>
            <th> 카테고리 </th>
            <th> 파일 </th>
            <th> 제목 </th>
            <th> 작성자 </th>
            <th> 조회수 </th>
            <th> 등록일시 </th>
            <th> 수정일시 </th>
        </tr>
    </thead>
<%
    List<PostDTO> board = (List<PostDTO>) request.getAttribute("board");
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
<div align="right" style="width: 80%">
    <button onclick="window.location.href = '/boards/free/list/post/update_post.jsp">등록</button>
</div>

</body>
</html>

<script type="text/javascript">
    function showPost(postId) {
        window.location.href = '/boards/free/list/post/post.jsp?postid=' + postId;
    }
</script>