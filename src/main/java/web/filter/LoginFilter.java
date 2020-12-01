package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        String uri = request.getRequestURI();
//        System.out.println(uri);
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/js/")
                || uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/img/")) {
            chain.doFilter(req, resp);
        } else {
            String role = (String) request.getSession().getAttribute("role");
            Object user = request.getSession().getAttribute(role);
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
