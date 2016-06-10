package com.gouwuche.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gouwuche.bean.BookBean;
import com.gouwuche.service.BookService;
import com.gouwuche.util.DBUtil;

public class BookServiceImpl extends DBUtil implements BookService {

	@Override
	public List<BookBean> getAll() {
		List<BookBean> bookList=new ArrayList<BookBean>();
		String sql="select * from book";
		rs=connSelect(sql);
		try {
			while(rs.next()){
				BookBean book=new BookBean();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setEditionNumber(rs.getInt("editionNumber"));
				book.setCopyright(rs.getString("copyright"));
				book.setPublisherID(rs.getInt("publisherID"));
				book.setImageFile(rs.getString("imageFile"));
				book.setPrice(rs.getDouble("price"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	//根据id查询书本信息
	@Override
	public BookBean getById(String isbn) {
		BookBean book=new BookBean();
		String sql="select * from book where isbn=?";
		try {
			rs=connSelect(sql, isbn);
			if(rs.next()){
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setEditionNumber(rs.getInt("editionNumber"));
				book.setCopyright(rs.getString("copyright"));
				book.setPublisherID(rs.getInt("publisherID"));
				book.setImageFile(rs.getString("imageFile"));
				book.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	

}
