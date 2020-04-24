package pl.gda.zsl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldWeb
 */
@WebServlet("/HelloWorldWeb")
public class HelloWorldWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB(name="HelloWorldBean")
    public void setHelloWorldBean(HelloWorldLocal helloWorldBean) {
    	this.helloWorldLocal = helloWorldBean;
    }
    
    private HelloWorldLocal helloWorldLocal;
    public HelloWorldWeb() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> translate = new HashMap<String, String>();
		translate.put("witam", "hi");
		String[] translator = {"hi", "what"};
		String[] accessWord = {"czesc", "co"};
		PrintWriter out = response.getWriter();
		out.append("<HTML><HEAD><TITLE>Hello World!</TITLE></HEAD>"
				+ "<BODY>Hello World!</BODY>");
				out.append("translation: " + translate.get(request.getParameter("word").toString()));
				out.append(helloWorldLocal.translate(request.getParameter("word").toString(), translator, accessWord));
				out.append("</HTML>");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
