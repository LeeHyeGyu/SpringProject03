package net.os.bear.product;

import java.io.Serializable;

public class OSPageDTO implements Serializable{
	/**페이지의 게시물 rownum 시작번호*/
	private int startNum;
	/**페이지의 게시물 rownum 끝번호*/
	private long endNum;
	/**총페이지*/
	private long totalPage;
	/**페이지 블럭의 시작번호*/
	private long startBlock;
	/**페이지 블럭의 끝번호*/
	private long endBlock;
	/**현재페이지*/
	private int page = 1;
	/**페이지사이즈*/
	private int pageSize = 5;
	/**블럭사이즈*/
	private int blockSize = 5;
	/**검색조건*/
	private String search;
	/**검색어*/
	private String text;
	/**카운트*/
	private long totalcount;
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public long getEndNum() {
		return endNum;
	}
	public void setEndNum(long endNum) {
		this.endNum = endNum;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getStartBlock() {
		return startBlock;
	}
	public void setStartBlock(long startBlock) {
		this.startBlock = startBlock;
	}
	public long getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(long endBlock) {
		this.endBlock = endBlock;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(long totalcount) {
		this.totalcount = totalcount;
	}
	public OSPageDTO(int page) {
		this.page = page;
		this.search = null;
		this.text = null;	
	}
	public OSPageDTO(int startNum, long endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}
	public OSPageDTO(int page, String search, String text) {
		super();
		this.page = page;
		this.search = search;
		this.text = text;
	}
	@Override
	public String toString() {
		return "PageDTO [startNum=" + startNum + ", endNum=" + endNum + ", totalPage=" + totalPage + ", startBlock="
				+ startBlock + ", endBlock=" + endBlock + ", page=" + page + ", pageSize=" + pageSize + ", blockSize="
				+ blockSize + ", search=" + search + ", text=" + text + ", totalcount=" + totalcount + "]";
	}
	
	
	
	
	
}
