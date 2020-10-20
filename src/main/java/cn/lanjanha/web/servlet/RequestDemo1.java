package cn.lanjanha.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/demo2")
//@WebServlet("/usr/demo2")
//@WebServlet({"/demo2","/usr/demo2"})
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Request对象的八大方法，用于获取请求行的数据信息

        String method = req.getMethod();
        System.out.println(method);
        //获取虚拟路径
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        //获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
        //URI：统一资源标识符
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        //URL：统一资源定位符
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        //获取协议及版本
        String protocol = req.getProtocol();
        System.out.println(protocol);
        //获取远程客户机的ip地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("dopost");
    }
}
