package net.os.bear.orderdetail;

public class OrderDetailDTO {
	private String order_no;
	private int order_detail_qty;
	private long product_no;
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getOrder_detail_qty() {
		return order_detail_qty;
	}
	public void setOrder_detail_qty(int order_detail_qty) {
		this.order_detail_qty = order_detail_qty;
	}
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	@Override
	public String toString() {
		return "OrderDetailDTO [order_no=" + order_no + ", order_detail_qty=" + order_detail_qty + ", product_no="
				+ product_no + "]";
	}
	
	
}
