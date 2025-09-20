<%@ page import="com.study.post.PostDTO" %>
<%@ page import="com.study.post.PostDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>게시글 수정</title>
</head>

<body>
<%
    String id = request.getParameter("postid");
    PostDAO postdao = new PostDAO();
    PostDTO post  = postdao.selectPost(Integer.parseInt(id));
%>
<%=  post.getTitle()%>

</body>
</html>
