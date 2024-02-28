package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String timezone = request.getParameter("timezone");
        ZoneId zoneId = (timezone != null && !timezone.isEmpty()) ? ZoneId.of(timezone) : ZoneOffset.UTC;

        LocalDateTime now = LocalDateTime.now(zoneId);

        out.println("<html><body>");
        out.println("<h1>Current Time</h1>");
        out.println("<p>" + now + " " + zoneId + "</p>");
        out.println("</body></html>");
    }
}
