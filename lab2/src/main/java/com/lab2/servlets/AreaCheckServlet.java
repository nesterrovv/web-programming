package com.lab2.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

@WebServlet("/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    LinkedList<String> answer = new LinkedList<>();
    String message;
    Double x, y, r;
    String check;
    String xFormat, yFormat;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        check = request.getParameter("check");
        x = Double.parseDouble(request.getParameter("x"));
        y = Double.parseDouble(request.getParameter("y"));
        r = Double.parseDouble(request.getParameter("r"));

        if (checkNull()){
            if (check.equals("clear")) {
                answer = new LinkedList<>();
                servletContext.setAttribute("answer", answer);
                response.sendRedirect("update.jsp");
                return;
            }
            if (checkRange()) {
                String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                long startTime = System.nanoTime();

                checkResult(x, y, r);
                long timeResponse = (System.nanoTime() - startTime);
                answer.addFirst("<tr><td>" + x + "</td>" +
                        "<td>" + y + "</td>" +
                        "<td>" + r + "</td>" +
                        "<td>" + currentTime + "</td>" +
                        "<td>" + timeResponse + " ns" + "</td>" +
                        "<td>" + message + "</td></tr>");
            } else {
                message = "<td>Value is incorrect!</td>";
                answer.addFirst("<tr>" + message + message + message + message + message + message + "</tr>");
            }
            servletContext.setAttribute("answer", answer);
            response.sendRedirect("update.jsp");
        }
        else {
            response.setStatus(422);
        }
    }


    //calculation
    private void checkResult ( double x, double y, double r){
        if (    (x >= 0 && y >= 0 && x <= r && y <= r) ||                               // check for 1st coordinate axis
                (x <= 0 && y <= 0 && x <= r*(-1) && y <= r / 2 * (-1)) ||               // check for 3th coordinate axis
                (x >= 0 && y <= 0 && Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)) // check for 4th coordinate axis
        ) {
            message = "<span style='color: #0fc40f'>TRUE</span>";
        } else {
            message = "<span style='color: red'>FALSE</span>";
        }
    }


    //checking for unwanted values
    private boolean checkRange() {
        if (x < -5 || x > 3 || y <= -5 || y >= 5 || r < -1 || r > 3) {
            return false;
        }
        return true;
    }

    private boolean checkNull(){
        if (check != null && !check.trim().equals("") && (x != null && y != null && r != null)){
            return true;
        }
        return false;
    }
}

