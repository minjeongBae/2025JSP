<%@ page import="com.study.board.post.PostDTO" %>
<%@ page import="com.study.board.post.PostDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>게시글 - 수정</title>
</head>

<body>
    <h4>기본정보</h4>

<%
    String id = request.getParameter("postid");
    PostDAO postdao = new PostDAO();
    PostDTO post  = postdao.selectPost(Integer.parseInt(id));

    String writer = post.getWriter();
    String title = post.getTitle();
    String content = post.getContent();
%>

<table border="1" style="width: 85%; height: 85%">
    <tr>
        <th>카테고리</th>
        <th><%=post.getCategory()%></th>
    </tr>

    <tr>
        <th>등록일시</th>
        <th><%=post.getCreateDate()%></th>
    </tr>

    <tr>
        <th>수정일시</th>
        <th><%=post.getUpdateDate()%></th>
    </tr>

    <tr>
        <th>조회수</th>
        <th><%=post.getViews()%></th>
    </tr>

    <tr>
        <th>작성자</th>
        <th>
            <input type="text" value="<%=writer%>" id="new_writer">
        </th>
    </tr>
    <tr>
        <th>비밀번호</th>
        <th><input type="password" id="new_password"/></th>
    </tr>
    <tr>
        <th>제목</th>
        <th><input type="text" value="<%=title%>" id="new_title"></th>
    </tr>
    <tr>
        <th>내용</th>
        <th><textarea value="<%=content%>" id="new_content"></textarea>
        </th>
    </tr>
    <tr>
        <th>파일첨부</th>
        <th>
            <p> 파일 1 </p>
            <p> 파일 2 </p>
            <p> 파일 3 </p>
        </th>
    </tr>
</table>
<div>
    <button onclick="location.href = '/boards/free/list/board.jsp'">취소</button>
    <button onclick="updatePost()">수정</button>
</div>

</body>
</html>
<script type="text/javascript">
    function updatePost() {
        PostDTO post = new PostDTO();

    }

</script>