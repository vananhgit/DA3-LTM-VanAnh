package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VigennereCipher;

@WebServlet("/vigennereController")
public class vigennereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public vigennereController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String planttext2 = request.getParameter("planttext2");
		String key2 = request.getParameter("key2");
		
		String rs = (String) VigennereCipher.encryptedVigennere(planttext2.toUpperCase(), key2);
		
		response.setContentType("text/plain");
		response.getWriter().write(rs);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
