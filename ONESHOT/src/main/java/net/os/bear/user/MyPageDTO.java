package net.os.bear.user;

import net.os.bear.board.ArticleDTO;
import net.os.bear.board.BoardDTO;
import net.os.bear.board.CommentDTO;
import net.os.bear.board.DetailDTO;
import net.os.bear.cs.CSDTO;
import net.os.bear.product.OSPageDTO;
import net.os.bear.product.ProductDTO;
import net.os.bear.product.ReviewDTO;

public class MyPageDTO {
	private UserDTO userDTO;
	private ReviewDTO reviewDTO;
	private ProductDTO productDTO;
	private OrderDTO orderDTO;
	private CSDTO csDTO;
	private DetailDTO detailDTO;
	private CommentDTO commentDTO;
	private BoardDTO boardDTO;
	private ArticleDTO articleDTO;
	private OSPageDTO osPageDTO;
	private SocialDTO socialDTO;
	private MarkDTO markDTO;
	private MsgDTO msgDTO;
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public ReviewDTO getReviewDTO() {
		return reviewDTO;
	}
	public void setReviewDTO(ReviewDTO reviewDTO) {
		this.reviewDTO = reviewDTO;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public OrderDTO getOrderDTO() {
		return orderDTO;
	}
	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}
	public CSDTO getCsDTO() {
		return csDTO;
	}
	public void setCsDTO(CSDTO csDTO) {
		this.csDTO = csDTO;
	}
	public DetailDTO getDetailDTO() {
		return detailDTO;
	}
	public void setDetailDTO(DetailDTO detailDTO) {
		this.detailDTO = detailDTO;
	}
	public CommentDTO getCommentDTO() {
		return commentDTO;
	}
	public void setCommentDTO(CommentDTO commentDTO) {
		this.commentDTO = commentDTO;
	}
	public BoardDTO getBoardDTO() {
		return boardDTO;
	}
	public void setBoardDTO(BoardDTO boardDTO) {
		this.boardDTO = boardDTO;
	}
	public ArticleDTO getArticleDTO() {
		return articleDTO;
	}
	public void setArticleDTO(ArticleDTO articleDTO) {
		this.articleDTO = articleDTO;
	}
	public OSPageDTO getOsPageDTO() {
		return osPageDTO;
	}
	public void setOsPageDTO(OSPageDTO osPageDTO) {
		this.osPageDTO = osPageDTO;
	}
	public SocialDTO getSocialDTO() {
		return socialDTO;
	}
	public void setSocialDTO(SocialDTO socialDTO) {
		this.socialDTO = socialDTO;
	}
	public MarkDTO getMarkDTO() {
		return markDTO;
	}
	public void setMarkDTO(MarkDTO markDTO) {
		this.markDTO = markDTO;
	}
	public MsgDTO getMsgDTO() {
		return msgDTO;
	}
	public void setMsgDTO(MsgDTO msgDTO) {
		this.msgDTO = msgDTO;
	}
	@Override
	public String toString() {
		return "MyPageDTO [userDTO=" + userDTO + ", reviewDTO=" + reviewDTO + ", productDTO=" + productDTO
				+ ", orderDTO=" + orderDTO + ", csDTO=" + csDTO + ", detailDTO=" + detailDTO + ", commentDTO="
				+ commentDTO + ", boardDTO=" + boardDTO + ", articleDTO=" + articleDTO + ", osPageDTO=" + osPageDTO
				+ ", socialDTO=" + socialDTO + ", markDTO=" + markDTO + ", msgDTO=" + msgDTO + "]";
	}
	
	
}
