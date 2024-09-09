package Tuan2.controllers;

import java.io.IOException;

import Tuan2.models.userModels;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WaitingController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			userModels u=(userModels) session.getAttribute("account");
			req.setAttribute("username", u.getUserName());
			if(u.getRoleid()==1) {
			resp.sendRedirect(req.getContextPath()+"/admin/home");
			}else if(u.getRoleid()==2) {
			resp.sendRedirect(req.getContextPath()+"/manager/home");
			}else {
			resp.sendRedirect(req.getContextPath()+"/home");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
			}
		}
}
