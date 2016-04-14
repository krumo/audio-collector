package filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by krumo on 2016/3/24.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpSession session=request.getSession();
        if(session.getAttribute("userID")!=null)
            chain.doFilter(req, resp);
        else
            request.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
