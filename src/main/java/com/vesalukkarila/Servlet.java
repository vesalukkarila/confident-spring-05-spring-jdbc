package com.vesalukkarila;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet extends HttpServlet {

    private InvoiceService invoiceService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.invoiceService = new InvoiceService();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getRequestURI().equals("/")){
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
        else if (req.getRequestURI().equalsIgnoreCase("/invoices")){
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print("[]");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equalsIgnoreCase("/invoices")){
            String userId = req.getParameter("user_id");
            Integer amount = Integer.valueOf(req.getParameter("amount"));

            Invoice invoice = invoiceService.create(userId, amount);

            resp.setContentType("application/json; charset=UTF-8");
            String json = objectMapper.writeValueAsString(invoice);
            resp.getWriter().print(json);
        }else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
