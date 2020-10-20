package cn.lanjanha.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();//Enumeration用法相当于迭代器iterators
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            //System.out.println(name+"-----"+value);
        }

        //获取用户代理，即浏览器信息
        String user_agent = req.getHeader("user-agent");
        if(user_agent.contains("Chrome")){
            System.out.println("Chrome来了。。。。。");
        }else if(user_agent.contains("Firefox")){
            System.out.println("Firefox来了。。。。");
        }

        //获取请求路径，即请求从哪来？（用于流量分析和防盗链）
        String referer = req.getHeader("referer");
        System.out.println(referer);
        if(referer.contains("/servlet")){
            System.out.println("欢迎来到爱奇艺！！！");
        }else{
            System.out.println("想看吗？来爱奇艺吧！！！");
        }
    }
}
