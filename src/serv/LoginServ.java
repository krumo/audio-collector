package serv;

import implementation.userimpl;
import pojo.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by krumo on 2016/3/1.
 */
@WebServlet(name = "LoginServ")
public class LoginServ extends HttpServlet {
    userimpl urimpl=new userimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        user ur=new user();
        ur.setUserName(username);
        ur.setUserPwd(password);
        ur.setAudionum(-1);
        List<user> urs=urimpl.checkuser(ur);
        if(!urs.isEmpty())
        {
            ur=urs.get(0);
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("userID",ur.getUserID());
            session.setAttribute("lasttext",ur.getLasttext());
            session.setAttribute("sex",ur.getUserSex());
            session.setAttribute("type",ur.getUserType());
            response.sendRedirect("./page/record.jsp");
            //request.getRequestDispatcher("./page/record.jsp").forward(request,response);
        }
        else
        {
            request.setAttribute("error","登陆失败");
            request.getRequestDispatcher("./errors/LoginErr.jsp").forward(request,response);
            //response.sendRedirect("./errors/LoginErr.jsp");
        }
    }
}
