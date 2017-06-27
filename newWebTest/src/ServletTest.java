

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//判断Session是否过期
		if(null ==  request.getSession(false)){
			System.out.println("Session has been invalidated");
		}else{
			System.out.println("Session is active!");
		}
		
		HttpSession session = request.getSession();
		//设置为-1时永不过期
		session.setMaxInactiveInterval(-1);
		session.setAttribute("name","tom");
		String name = (String)session.getAttribute("name");
		System.out.println(name);
		
		//生成Cookie
		Cookie cookie = new Cookie("address","myAddress");
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		
		ServletContext application =  this.getServletContext();
		application.setAttribute("myName", "test");
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
