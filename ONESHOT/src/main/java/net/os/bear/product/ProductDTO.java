package net.os.bear.product;

import java.io.Serializable;
import java.util.Date;

public class ProductDTO implements Serializable {
	private int 	product_no;
	private String 	product_name;
	private int 	product_price;
	private int 	product_sales_qty;
	private int 	product_stock_qty;
	private int   	product_alc;
	private int   	product_size;
	private String 	product_info;
	private Date 	product_date;
	private String 	product_taste;
	private String 	product_taste2;
	private String  product_taste3;
	private String  product_flavor;
	private String  product_type;
	private String  product_country;
	private String  product_ename;
	private int cnt;
	private int rownum;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_sales_qty() {
		return product_sales_qty;
	}
	public void setProduct_sales_qty(int product_sales_qty) {
		this.product_sales_qty = product_sales_qty;
	}
	public int getProduct_stock_qty() {
		return product_stock_qty;
	}
	public void setProduct_stock_qty(int product_stock_qty) {
		this.product_stock_qty = product_stock_qty;
	}
	public int getProduct_alc() {
		return product_alc;
	}
	public void setProduct_alc(int product_alc) {
		this.product_alc = product_alc;
	}
	public int getProduct_size() {
		return product_size;
	}
	public void setProduct_size(int product_size) {
		this.product_size = product_size;
	}
	public String getProduct_info() {
		return product_info;
	}
	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}
	public Date getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
	public String getProduct_taste() {
		return product_taste;
	}
	public void setProduct_taste(String product_taste) {
		this.product_taste = product_taste;
	}
	public String getProduct_taste2() {
		return product_taste2;
	}
	public void setProduct_taste2(String product_taste2) {
		this.product_taste2 = product_taste2;
	}
	public String getProduct_taste3() {
		return product_taste3;
	}
	public void setProduct_taste3(String product_taste3) {
		this.product_taste3 = product_taste3;
	}
	public String getProduct_flavor() {
		return product_flavor;
	}
	public void setProduct_flavor(String product_flavor) {
		this.product_flavor = product_flavor;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProduct_country() {
		return product_country;
	}
	public void setProduct_country(String product_country) {
		this.product_country = product_country;
	}

	@Override
	public String toString() {
		return "ProductDTO [product_no=" + product_no + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_sales_qty=" + product_sales_qty + ", product_stock_qty="
				+ product_stock_qty + ", product_alc=" + product_alc + ", product_size=" + product_size
				+ ", product_info=" + product_info + ", product_date=" + product_date + ", product_taste="
				+ product_taste + ", product_taste2=" + product_taste2 + ", product_taste3=" + product_taste3
				+ ", product_flavor=" + product_flavor + ", product_type=" + product_type + ", product_country="
				+ product_country + ", product_ename=" + product_ename + ", cnt=" + cnt + ", rownum=" + rownum + "]";
	}
	public String getProduct_ename() {
		return product_ename;
	}
	public void setProduct_ename(String product_ename) {
		this.product_ename = product_ename;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	
}
