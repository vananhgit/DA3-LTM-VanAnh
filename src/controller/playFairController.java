package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PlayfairCipher;

@WebServlet("/playFairController")
public class playFairController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public playFairController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String key = request.getParameter("key").trim();
		String plantText = request.getParameter("plantText").trim();
		
		String rs = (String) PlayfairCipher.encryptedPlayfair(plantText.toUpperCase(), key);
		
		
		response.setContentType("text/plain");
		response.getWriter().write(rs);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
