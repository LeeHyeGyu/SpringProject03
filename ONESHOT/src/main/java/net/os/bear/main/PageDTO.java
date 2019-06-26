package net.os.bear.main;

import java.io.Serializable;
import java.util.Arrays;

public class PageDTO implements Serializable{
	private long startNum;
	private long endNum;
	private String search;
	private String[] arr;
	private String[] arr2;
	private String[] arr3;
	private String[] arr4;
	private String[] arr5;
	
	
	public PageDTO(String search,long startNum, long endNum ) {
		super();
		this.search = search;
		this.startNum = startNum;
		this.endNum = endNum;
	}

	public PageDTO( String[] arr, String[] arr2, String[] arr3,String[] arr4,String[] arr5,long startNum, long endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
		this.arr = arr;
		this.arr2 = arr2;
		this.arr3 = arr3;
		this.arr4 = arr4;
		this.arr5 = arr5;
	}
	public PageDTO( String[] arr, String[] arr2, String[] arr3,long startNum, long endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
		this.arr = arr;
		this.arr2 = arr2;
		this.arr3 = arr3;

	}

	public PageDTO(long startNum, long endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
	}
	public PageDTO(String[] arr, String[] arr2, String[] arr3) {
		super();
		this.arr = arr;
		this.arr2 = arr2;
		this.arr3 = arr3;
	}

	public PageDTO(String[] arr, String[] arr2, String[] arr3, String[] arr4, String[] arr5) {
		super();
		this.arr = arr;
		this.arr2 = arr2;
		this.arr3 = arr3;
		this.arr4 = arr4;
		this.arr5 = arr5;
	}

	public long getStartNum() {
		return startNum;
	}
	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}
	public long getEndNum() {
		return endNum;
	}
	public void setEndNum(long endNum) {
		this.endNum = endNum;
	}

	@Override
	public String toString() {
		return "PageDTO [startNum=" + startNum + ", endNum=" + endNum + ", search=" + search + ", arr="
				+ Arrays.toString(arr) + ", arr2=" + Arrays.toString(arr2) + ", arr3=" + Arrays.toString(arr3)
				+ ", arr4=" + Arrays.toString(arr4) + ", arr5=" + Arrays.toString(arr5) + "]";
	}


	
//	   /**페이지의 게시물 rownum 시작번호*/
//	   private int startNum;
//	   /**페이지의 게시물 rownum 끝번호*/
//	   private long endNum;
//	   /**총페이지*/
//	   private long totalPage;
//	   /**페이지 블럭의 시작번호*/
//	   private long startBlock;
//	   /**페이지 블럭의 끝번호*/
//	   private long endBlock;
//	   /**현재페이지*/
//	   private int page = 1;
//	   /**페이지사이즈*/
//	   private int pageSize = 10;
//	   /**블럭사이즈*/
//	   private int blockSize = 10;
//	   /**검색조건*/
//	   private String search;
//	   /**검색어*/
//	   private String text;
//	   /**카운트*/
//	   private long totalcount;
//	   public int getStartNum() {
//	      return startNum;
//	   }
//	   public void setStartNum(int startNum) {
//	      this.startNum = startNum;
//	   }
//	   public long getEndNum() {
//	      return endNum;
//	   }
//	   public void setEndNum(long endNum) {
//	      this.endNum = endNum;
//	   }
//	   public long getTotalPage() {
//	      return totalPage;
//	   }
//	   public void setTotalPage(long totalPage) {
//	      this.totalPage = totalPage;
//	   }
//	   public long getStartBlock() {
//	      return startBlock;
//	   }
//	   public void setStartBlock(long startBlock) {
//	      this.startBlock = startBlock;
//	   }
//	   public long getEndBlock() {
//	      return endBlock;
//	   }
//	   public void setEndBlock(long endBlock) {
//	      this.endBlock = endBlock;
//	   }
//	   public int getPage() {
//	      return page;
//	   }
//	   public void setPage(int page) {
//	      this.page = page;
//	   }
//	   public int getPageSize() {
//	      return pageSize;
//	   }
//	   public void setPageSize(int pageSize) {
//	      this.pageSize = pageSize;
//	   }
//	   public int getBlockSize() {
//	      return blockSize;
//	   }
//	   public void setBlockSize(int blockSize) {
//	      this.blockSize = blockSize;
//	   }
//	   public String getSearch() {
//	      return search;
//	   }
//	   public void setSearch(String search) {
//	      this.search = search;
//	   }
//	   public String getText() {
//	      return text;
//	   }
//	   public void setText(String text) {
//	      this.text = text;
//	   }
//	   public long getTotalcount() {
//	      return totalcount;
//	   }
//	   public void setTotalcount(long totalcount) {
//	      this.totalcount = totalcount;
//	   }
//	   public PageDTO(int page) {
//	      this.page = page;
//	      this.search = null;
//	      this.text = null;   
//	   }
//	   public PageDTO(int startNum, long endNum) {
//	      this.startNum = startNum;
//	      this.endNum = endNum;
//	   }
//	   public PageDTO(int page, String search, String text) {
//	      super();
//	      this.page = page;
//	      this.search = search;
//	      this.text = text;
//	   }
//	   @Override
//	   public String toString() {
//	      return "PageDTO [startNum=" + startNum + ", endNum=" + endNum + ", totalPage=" + totalPage + ", startBlock="
//	            + startBlock + ", endBlock=" + endBlock + ", page=" + page + ", pageSize=" + pageSize + ", blockSize="
//	            + blockSize + ", search=" + search + ", text=" + text + ", totalcount=" + totalcount + "]";
//	   }
}