package com.gouwuche.bean;
/**
 * 购物车JAVAbean
 * @author Administrator
 *
 */
public class CartItem {
	private BookBean bookBean;//书
	private int count;//书本数量
	public BookBean getBookBean() {
		return bookBean;
	}
	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public CartItem(BookBean bookBean, int count) {
		this.bookBean = bookBean;
		this.count = count;
	}
	public CartItem(){}
}
