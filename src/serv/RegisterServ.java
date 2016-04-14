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
@WebServlet(name = "RegisterServ")
public class RegisterServ extends HttpServlet {
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
        //String usertype=request.getParameter("usertype");
        user ur=new user();
        ur.setUserName(username);
        ur.setUserID(0);
        ur.setAudionum(-1);
        List<user> urs=urimpl.checkuser(ur);
        if(!urs.isEmpty())
        {
            //request.setAttribute("error","注册失败");
            request.getSession().setAttribute("error","注册失败");
            response.sendRedirect(request.getContextPath()+"/errors/RegisterErr.jsp");
        }
        else
        {
            ur.setUserPwd(password);
            ur.setUserSex(gender);
            ur.setUserAge(age);
            ur.setUserBirthplace(birthplace);
            ur.setUserType(new String("普通用户"));
            ur.setLasttext(0);
            ur.setAudionum(0);
            urimpl.createuser(ur);
            urs=urimpl.checkuser(ur);
            if(urs.isEmpty())
            {
                //request.setAttribute("error","创建失败");
                request.getSession().setAttribute("error","创建失败");
                //request.getRequestDispatcher(request.getContextPath()+"/errors/RegisterErr.jsp").forward(request,response);
                response.sendRedirect(request.getContextPath()+"/errors/RegisterErr.jsp");
            }
            else
            {
                ur=urs.get(0);
                HttpSession session=request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("userID",ur.getUserID());
                session.setAttribute("lasttext",ur.getLasttext());
                session.setAttribute("sex",ur.getUserSex());
                session.setAttribute("type",ur.getUserType());
                response.sendRedirect(request.getContextPath()+"/success/RegSucc.jsp");
            }
        }

        System.out.println(request.getContextPath());
        //request.getRequestDispatcher("/page/record.jsp").forward(request,response);
    }
}
