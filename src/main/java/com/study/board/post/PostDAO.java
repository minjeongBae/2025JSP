package com.study.board.post;

import com.study.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    public PostDTO selectPost(int id) {
        String sql = "SELECT * FROM POST WHERE POST_ID = ?";
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                PostDTO post = new PostDTO();
                post.setPostId(rs.getInt("POST_ID"));
                post.setWriter(rs.getString("WRITER"));
                post.setViews(rs.getInt("VIEWS"));
                post.setTitle(rs.getString("TITLE"));
                post.setContent(rs.getString("CONTENT"));
                post.setCreateDate(rs.getDate("CREATE_DATE"));
                post.setUpdateDate(rs.getDate("UPDATE_DATE"));
                post.setCategory(rs.getString("CATEGORY"));
                conn.close();

                return post;
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public List<PostDTO> selectPostsAll() {
        String sql = "SELECT POST.POST_ID, WRITER, CATEGORY, TITLE" +
                ", VIEWS, CREATE_DATE, UPDATE_DATE," +
                "CASE WHEN FILE.FILE_NAME IS NULL THEN 0 ELSE 1 END AS  FILES " +
                "FROM POST"
                +  " LEFT JOIN FILE FILE ON FILE.POST_ID = POST.POST_ID"
                  ;
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){

            ResultSet rs = pstmt.executeQuery();
            List<PostDTO> posts = new ArrayList<>();

            while(rs.next()) {
                PostDTO post = new PostDTO();
                post.setPostId(rs.getInt("POST_ID"));
                post.setWriter(rs.getString("WRITER"));
                post.setTitle(rs.getString("TITLE"));
                post.setViews(rs.getInt("VIEWS"));
                post.setCreateDate(rs.getDate("CREATE_DATE"));
                post.setUpdateDate(rs.getDate("UPDATE_DATE"));
                post.setCategory(rs.getString("CATEGORY"));
                post.setFiles(rs.getInt("FILES"));
                posts.add(post);

            }
            conn.close();
            return posts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<PostDTO> selectPostsSearch(String fDate, String tDate, String word) {
        String sql = "SELECT POST.POST_ID, WRITER, CATEGORY, TITLE" +
                ", VIEWS, CREATE_DATE, UPDATE_DATE," +
                "CASE WHEN FILE.FILE_NAME IS NULL THEN 0 ELSE 1 END AS  FILES " +
                "FROM POST"
                +  " LEFT JOIN FILE FILE ON FILE.POST_ID = POST.POST_ID" +
                " WHERE TITLE LIKE ? OR CONTENET LIKE ? OR WRITER LIKE ?"
                ;
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){


            ResultSet rs = pstmt.executeQuery();
            List<PostDTO> posts = new ArrayList<>();

            while(rs.next()) {
                PostDTO post = new PostDTO();
                post.setPostId(rs.getInt("POST_ID"));
                post.setWriter(rs.getString("WRITER"));
                post.setViews(rs.getInt("VIEWS"));
                post.setTitle(rs.getString("TITLE"));
                post.setCreateDate(rs.getDate("CREATE_DATE"));
                post.setUpdateDate(rs.getDate("UPDATE_DATE"));
                post.setCategory(rs.getString("CATEGORY"));
                post.setFiles(rs.getInt("FILES"));
                posts.add(post);
            }

            conn.close();
            return posts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public int addViews(int postId) {
        String sql = "UPDATE POST SET VIEWS = VIEWS+1 WHERE POST_ID = ?";
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1,postId);
            int rs = pstmt.executeUpdate();
            conn.close();
            return rs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
