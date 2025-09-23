package com.study.board.comment;

import com.study.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

    public int insertComment(int postid, String cotent) {
        String sql = "INSERT INTO COMMENT (POST_ID, WRITER, CREATE_DATE, CONTENT) " +
                "VALUES (?,?,sysdate(),?)";
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1,postid);
            pstmt.setString(2,"admin");
            pstmt.setString(3,cotent);

            return pstmt.executeUpdate();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int insertComment(CommentDTO comment) {
        String sql = "INSERT INTO COMMENT (POST_ID, CID, WRITER, CREATE_DATE, CONTENT) " +
                "VALUES (?,?,?,?,?)";
        try(Connection conn = ConnectionUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, comment.getPostId());
            pstmt.setInt(2, comment.getCId());
            pstmt.setString(3, comment.getWriter());
            pstmt.setString(4, String.valueOf(comment.getCreateDate()));
            pstmt.setString(5, comment.getContent());

            return pstmt.executeUpdate();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CommentDTO> selectComments(int postId){
        List<CommentDTO> comments = new ArrayList<>();
        String sql = "SELECT * FROM COMMENT WHERE POST_ID = ?";

        try(Connection conn = ConnectionUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1,postId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                CommentDTO comment = new CommentDTO();
                comment.setPostId(rs.getInt("POST_ID"));
                comment.setCreateDate(rs.getDate("CREATE_DATE"));
                comment.setContent(rs.getString("CONTENT"));

                comments.add(comment);
            }
            return  comments;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
