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

/**
 * Created by krumo on 2016/3/1.
 */
@WebServlet(name = "PerSetServ")
public class PerSetServ extends HttpServlet {
    userimpl urimpl=new userimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender=request.getParameter("gender");
        String age=request.getParameter("age");
        String birthplace=request.getParameter("birthplace");

        user ur=new user();
        ur.setUserID((int) request.getSession().getAttribute("userID"));
        ur.setUserName(username);
        ur.setUserPwd(password);
        ur.setUserSex(gender);
        ur.setUserAge(age);
        ur.setUserBirthplace(birthplace);
        urimpl.updateuser(ur);
        HttpSession session=request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("userID",ur.getUserID());
        response.sendRedirect("/page/personalSetting.jsp");
        //request.getRequestDispatcher("/page/personalSetting.jsp").forward(request,response);
        //getServletContext().getRequestDispatcher("/page/personalSetting.jsp").forward(request,response);
    }
}
