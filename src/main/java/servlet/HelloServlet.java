package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lance on 7/11/16.
 */
public class HelloServlet extends HttpServlet {

    public HelloServlet(){

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(request, response);
        System.out.println("处理get请求");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<strong>HelloServlet!</strong>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);
    }
}
