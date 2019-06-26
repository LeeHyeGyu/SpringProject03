package net.os.bear.board;

import java.sql.SQLException;
import java.util.List;

import net.os.bear.user.MsgDTO;

public interface BoardDAO {

	List<BoardDTO> getBoardList() throws SQLException;

	List<ArticleDTO> getArticleList(int boa_no) throws SQLException;

	BoardDTO getBoardInfo(int boa_no) throws SQLException;

	void insertArticle(ArticleDTO articleDTO) throws SQLException;

	ArticleDTO getArticle(int social_no) throws SQLException;

	int deleteArticle(ArticleDTO articleDTO) throws SQLException;

	void insertComment(CommentDTO commentDTO) throws SQLException;

	List<CommentDTO> getCommentList(CommentDTO commentDTO) throws SQLException;

	int deleteComment(CommentDTO commentDTO)throws SQLException;

	int updateComment(CommentDTO commentDTO) throws SQLException;

	DetailDTO getDetail(int social_no) throws SQLException;
	
	int updateArticle(ArticleDTO articleDTO) throws SQLException;

	void sendMsgg(MsgDTO msggDTO) throws SQLException;

}
