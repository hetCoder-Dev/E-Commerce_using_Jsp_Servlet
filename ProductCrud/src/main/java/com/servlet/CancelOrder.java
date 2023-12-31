package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PurchaseDao;

@WebServlet("/cancelOrder")
public class CancelOrder extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try (PrintWriter out = resp.getWriter()) {
			String id = req.getParameter("id");
			int pId = Integer.parseInt(id);
			if (id != null) {
				PurchaseDao.cancelOrder(pId);
			}
			resp.sendRedirect("orders.jsp");
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
	}
}
