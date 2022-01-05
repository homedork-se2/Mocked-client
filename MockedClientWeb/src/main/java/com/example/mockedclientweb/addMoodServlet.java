package com.example.mockedclientweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "addMoodServlet", value = "/addMood")
public class addMoodServlet extends HttpServlet {

    ArrayList devices;
    StringBuilder stringBuilder;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        devices = new ArrayList();
        stringBuilder = new StringBuilder();

        getDeviceList();
        String deviceListHTML = transformDeviceList(devices);

        request.setAttribute("deviceList", deviceListHTML);
        request.getRequestDispatcher("/addMood.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // addMood contains the index of the devices that shall be added to new status mood button
        String addMood = request.getParameter("download");
        String nameMood = request.getParameter("moodName");

        System.out.println("addMood: "+ addMood);
        System.out.println("nameMood: " + nameMood);

        request.getRequestDispatcher("/addMood.jsp").forward(request, response);
    }

    public void getDeviceList(){
        devices.add("device1");
        devices.add("device2");
        devices.add("device3");
        devices.add("device4");
        devices.add("device5");
    }

    public String transformDeviceList(ArrayList deviceList){
        for(int i=0; i < deviceList.size(); i++) {
            stringBuilder.append("<li class=\"listItem\">"+ deviceList.get(i) +" <button onclick=\"addItem("+ i +")\">Add</button></li>");
            System.out.println("add device " + i);
        }
        return stringBuilder.toString();
    }

}
