package com.vesalukkarila;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getRequestURI().equals("/")) {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print(
                    """
                            <html>
                            <body>
                            <h1> Hello from hand made servlet</h1>
                            <p>This is the first one</p>
                            </body>
                            </html>
                                                    
                            """);
        }
        else if (req.getRequestURI().equalsIgnoreCase("/invoices")) {
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print("[]");
        }
    }
}
