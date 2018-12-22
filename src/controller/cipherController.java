package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cipherController")
public class cipherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cipherController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		
		String cipher = request.getParameter("option").trim();
		String planttext2 = request.getParameter("planttext2");
		String key2 = request.getParameter("key2");
		

		
		
		response.setContentType("text/plain");
		response.getWriter().write("");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
