package net.os.bear.order;

import java.io.Serializable;

public class OrderDetailDTO implements Serializable {
	private String ORDER_NO;
	private int ORDER_DETAIL_QTY;
	private int PRODUCT_NO;
	public String getORDER_NO() {
		return ORDER_NO;
	}
	public void setORDER_NO(String oRDER_NO) {
		ORDER_NO = oRDER_NO;
	}
	public int getORDER_DETAIL_QTY() {
		return ORDER_DETAIL_QTY;
	}
	public void setORDER_DETAIL_QTY(int oRDER_DETAIL_QTY) {
		ORDER_DETAIL_QTY = oRDER_DETAIL_QTY;
	}
	public int getPRODUCT_NO() {
		return PRODUCT_NO;
	}
	public void setPRODUCT_NO(int pRODUCT_NO) {
		PRODUCT_NO = pRODUCT_NO;
	}
	@Override
	public String toString() {
		return "OrderDetailDTO [ORDER_NO=" + ORDER_NO + ", ORDER_DETAIL_QTY=" + ORDER_DETAIL_QTY + ", PRODUCT_NO="
				+ PRODUCT_NO + "]";
	}
}
