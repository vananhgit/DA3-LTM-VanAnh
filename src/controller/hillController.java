package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HillCipher;
import DAO.PlayfairCipher;

@WebServlet("/hillController")
public class hillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public hillController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String hillText = request.getParameter("hillText");
		String data = request.getParameter("data");
		
		String rs = (String) HillCipher.encryptedHill(hillText.toUpperCase(), data);
		response.setContentType("text/plain");
		response.getWriter().write(rs);
		
		//out.print(cipher_hill);
		//out.print("dfkh" +hill_plaintext);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

