package com.example.mockedclientweb;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //testing merge rule
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}