package com.gouwuche.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gouwuche.bean.BookBean;
import com.gouwuche.bean.CartItem;
import com.gouwuche.service.BookService;
import com.gouwuche.service.impl.BookServiceImpl;

public class BookAction extends HttpServlet {

	private BookService bookService=new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//声明全局变量
		HttpSession session=request.getSession();
		
		String action = request.getParameter("action");
		//显示首页全部商品信息
		if("all".equals(action)){
			List<BookBean> booklist=bookService.getAll();
			session.setAttribute("booklist", booklist);
			request.getRequestDispatcher("/WEB-INF/book/index.jsp").forward(request, response);
		}
		
		//根据图书编号查询单个商品详情
		if("one".equals(action)){
			String isbn=request.getParameter("isbn");
			List<BookBean> booklist=(List<BookBean>)session.getAttribute("booklist");
			for(BookBean bookBean :booklist){
				if(isbn.equals(bookBean.getIsbn())){
					//把这本书存放到session中
					session.setAttribute("book",bookBean);
					break;
				}
			}
			request.getRequestDispatcher("/WEB-INF/book/detail.jsp").forward(request, response);
		}
//		if("one".equals(action)){
//			String isbn=request.getParameter("isbn");
//			BookBean book=bookService.getById(isbn);
//			session.setAttribute("book", book);
//			request.getRequestDispatcher("/WEB-INF/book/detail.jsp").forward(request, response);
//		}
		
		//加入购物车
		if("cart".equals(action)){
			//首先要知道要将那一本书放入购物车
			BookBean bookBean=(BookBean) session.getAttribute("book");
			
			//你必须要有购物车（创建一个购物车的JAVAbean--->CartItem）    集合可以做容器
//			Map<String,CartItem> cartItem=new HashMap<String ,CartItem>();
//			cartItem.put(bookBean.getIsbn(),new CartItem(bookBean,1));
//			session.setAttribute("cartItem", cartItem);
			if(session==null){
				request.getRequestDispatcher("/WEB-INF/book/index.jsp").forward(request, response);
			}
			//先从session中去取购物车
			Map<String , CartItem> cartItem=(Map<String ,CartItem>) session.getAttribute("cartItem");
			if(cartItem==null)
			{
				cartItem=new HashMap<String ,CartItem>();
				session.setAttribute("cartItem", cartItem);
			}
			CartItem cart = cartItem.get(bookBean.getIsbn());
			if(cart==null){
				cartItem.put(bookBean.getIsbn(), new CartItem(bookBean,1));
			}else{
				cart.setCount(cart.getCount()+1);
			}
			request.getRequestDispatcher("/WEB-INF/book/cart.jsp").forward(request, response);
		}
		
		if("show".equals(action)){
			request.getRequestDispatcher("/WEB-INF/book/cart.jsp").forward(request, response);
		}
	}

}
