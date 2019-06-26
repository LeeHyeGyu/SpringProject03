package net.os.bear.board;

import java.util.List;

import net.os.bear.user.MsgDTO;

public interface BoardService {

	List<BoardDTO> getBoardList() throws Exception;

	List<ArticleDTO> getArticleList(int boa_no) throws Exception;

	BoardDTO getBoardInfo(int boa_no) throws Exception;

	void insertArticle(ArticleDTO articleDTO) throws Exception;

	ArticleDTO getArticle(int social_no) throws Exception;

	void deleteArticle(ArticleDTO articleDTO) throws Exception;

	void insertComment(CommentDTO commentDTO) throws Exception;

	List<CommentDTO> getCommentList(CommentDTO commentDTO) throws Exception;

	void deleteComment(CommentDTO commentDTO) throws Exception;

	void updateComment(CommentDTO commentDTO) throws Exception;

	DetailDTO getDetail(int social_no) throws Exception;

	void updateArticle(ArticleDTO articleDTO) throws Exception;

	void sendMsgg(MsgDTO msggDTO) throws Exception;

}
