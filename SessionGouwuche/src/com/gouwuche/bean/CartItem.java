package com.gouwuche.bean;
/**
 * ���ﳵJAVAbean
 * @author Administrator
 *
 */
public class CartItem {
	private BookBean bookBean;//��
	private int count;//�鱾����
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
