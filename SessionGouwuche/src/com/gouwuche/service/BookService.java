package com.gouwuche.service;

import java.util.List;

import com.gouwuche.bean.BookBean;

public interface BookService {

	List<BookBean> getAll();

	BookBean getById(String isbn);

}
