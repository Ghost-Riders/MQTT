package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Controller_Entity.E_sender;

/**
 * Servlet implementation class SenderOne
 */
@WebServlet("/SenderOne")
public class SenderOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SenderOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sender_msg=request.getParameter("sendertext");
		String sender_area=request.getParameter("senderarea");
		System.out.println(sender_msg+sender_area);
		E_sender e_sender=new E_sender();
		
		int num_send=e_sender.sends(sender_msg);
		if(num_send>0) {
			response.sendRedirect("SenderOne.jsp");
		}else {
			response.sendRedirect("dummy.jsp");
		}
	}

}
