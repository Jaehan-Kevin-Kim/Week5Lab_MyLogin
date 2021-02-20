
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 841898
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   HttpSession session = request.getSession();
        
        String logout = request.getParameter("logout");
        String msg = "You have successfully logged out.";
                if (logout != null){
                    request.setAttribute("message", msg);
                    session.invalidate();
                    session = request.getSession();


                }
//                User user = (User) session.getAttribute("user");
                String username = (String)session.getAttribute("username");
                if(username != null){
                              response.sendRedirect("/home");
                              return;
                }

                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        
        AccountService accountService = new AccountService();
        HttpSession session = request.getSession();
        String username= request.getParameter("username");
        session.setAttribute("username", username);
        
        
        String password=request.getParameter("password");
        
                
                
        
        if ((username != null || username.equals("")) && (password != null || password.equals(""))){
            User user = accountService.login(username, password);
//            session.setAttribute("user", user);
            
            System.out.println(user);
            if (user != null){
                response.sendRedirect("/home");
            } else {
                String errorMsg = "Invalid input";
                request.setAttribute("message", errorMsg);
                        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }
        
    }


}
