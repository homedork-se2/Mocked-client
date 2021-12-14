package com.example.mockedclientweb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "statusServlet", value = "/status")
public class StatusServlet extends HttpServlet {

    StringBuilder stringBuilder;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        stringBuilder = new StringBuilder();
        getStatusCommands(0,"Stress", "stressed.PNG", "Radio", "Living room Lamp", "Heating", "");
        getStatusCommands(1,"Happy", "happy.PNG","Bedroom Lamp", "Living room Lamp", "Heating", "Kitchen Lamp");
        getStatusCommands(2,"Tired", "tired.PNG", "Bedroom Lamp", "Radio", "Fan", "");

        String moodButtons = stringBuilder.toString();

        request.setAttribute("moodButtons", moodButtons);
        request.getRequestDispatcher("/status.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String moodId = request.getParameter("download");
        System.out.println("moodId "+ moodId);

        stringBuilder = new StringBuilder();
        getStatusCommands(0,"Stress", "stressed.PNG", "Radio", "Living room Lamp", "Heating", "");
        getStatusCommands(1,"Happy", "happy.PNG","Bedroom Lamp", "Living room Lamp", "Heating", "Kitchen Lamp");
        getStatusCommands(2,"Tired", "tired.PNG", "Bedroom Lamp", "Radio", "Fan", "");

        String moodButtons = stringBuilder.toString();
        request.setAttribute("moodButtons", moodButtons);
        request.getRequestDispatcher("/status.jsp").forward(request, response);
    }



    public void getStatusCommands(int moodId,String moodName, String blissImg, String device1, String device2, String device3, String device4){

        stringBuilder.append("<div class=\"rectangle\" onclick=\"transferCallToServlet("+ moodId +")\">" +
                "<div class=\"moodHeader\"><p class=\"moodTitle\">" + moodName +"</p><img class=\"blissImg\" src=\""+ blissImg +"\"/></div>" +
                "<hr class=\"line\">" +
                "<p class=\"moodDevice\">" + device1 +"</p>" +
                "<p class=\"moodDevice\">" + device2 +"</p>" +
                "<p class=\"moodDevice\">" + device3 +"</p>" +
                "<p class=\"moodDevice\">" + device4 +"</p>" +
                "</div>");
    }


}
