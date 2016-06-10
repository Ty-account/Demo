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
		//����ȫ�ֱ���
		HttpSession session=request.getSession();
		
		String action = request.getParameter("action");
		//��ʾ��ҳȫ����Ʒ��Ϣ
		if("all".equals(action)){
			List<BookBean> booklist=bookService.getAll();
			session.setAttribute("booklist", booklist);
			request.getRequestDispatcher("/WEB-INF/book/index.jsp").forward(request, response);
		}
		
		//����ͼ���Ų�ѯ������Ʒ����
		if("one".equals(action)){
			String isbn=request.getParameter("isbn");
			List<BookBean> booklist=(List<BookBean>)session.getAttribute("booklist");
			for(BookBean bookBean :booklist){
				if(isbn.equals(bookBean.getIsbn())){
					//���Ȿ���ŵ�session��
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
		
		//���빺�ﳵ
		if("cart".equals(action)){
			//����Ҫ֪��Ҫ����һ������빺�ﳵ
			BookBean bookBean=(BookBean) session.getAttribute("book");
			
			//�����Ҫ�й��ﳵ������һ�����ﳵ��JAVAbean--->CartItem��    ���Ͽ���������
//			Map<String,CartItem> cartItem=new HashMap<String ,CartItem>();
//			cartItem.put(bookBean.getIsbn(),new CartItem(bookBean,1));
//			session.setAttribute("cartItem", cartItem);
			if(session==null){
				request.getRequestDispatcher("/WEB-INF/book/index.jsp").forward(request, response);
			}
			//�ȴ�session��ȥȡ���ﳵ
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
