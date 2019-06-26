package net.os.bear.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.os.bear.user.MsgDTO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}

	@Override
	public List<ArticleDTO> getArticleList(int boa_no) throws Exception {
		return boardDAO.getArticleList(boa_no);
	}

	@Override
	public BoardDTO getBoardInfo(int boa_no) throws Exception {
		return boardDAO.getBoardInfo(boa_no);
	}

	@Override
	public void insertArticle(ArticleDTO articleDTO) throws Exception {
		boardDAO.insertArticle(articleDTO);
	}

	@Override
	public ArticleDTO getArticle(int social_no) throws Exception {
		ArticleDTO articleDTO = boardDAO.getArticle(social_no);
		if (articleDTO == null) {
			throw new RuntimeException(social_no + "번 글이 존재하지 않습니다.");
		}
		return articleDTO;
	}
	
	@Override
	public void deleteArticle(ArticleDTO articleDTO) throws Exception {
		if (boardDAO.deleteArticle(articleDTO) == 0) {
			throw new RuntimeException("존재하지 않거나 접근 권한이 없습니다.");
		}
	}
	
	@Override
	public void insertComment(CommentDTO commentDTO) throws Exception {
		boardDAO.insertComment(commentDTO);
	}

	@Override
	public List<CommentDTO> getCommentList(CommentDTO commentDTO) throws Exception {
		return boardDAO.getCommentList(commentDTO);
	}@Override
	public void deleteComment(CommentDTO commentDTO) throws Exception {
		if(boardDAO.deleteComment(commentDTO)==0){
			throw new RuntimeException("존재하지 않거나 접근 권한이 없습니다.");
		}
		
		
	}
	@Override
	public void updateComment(CommentDTO commentDTO) throws Exception {
		if(boardDAO.updateComment(commentDTO)==0){
			throw new RuntimeException("존재하지 않거나 접근 권한이 없습니다.");
		}
		
	}

	@Override
	public DetailDTO getDetail(int social_no) throws Exception {
		return boardDAO.getDetail(social_no);
	}

	@Override
	public void updateArticle(ArticleDTO articleDTO) throws Exception {
		System.out.println(articleDTO.toString());
		System.out.println(boardDAO.updateArticle(articleDTO));
	}

	@Override
	public void sendMsgg(MsgDTO msggDTO) throws Exception {
		boardDAO.sendMsgg(msggDTO);
		
	}

}
