package com.vesalukkarila.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vesalukkarila.context.ApplicationConfiguration;
import com.vesalukkarila.model.Invoice;
import com.vesalukkarila.service.InvoiceService;
import com.vesalukkarila.service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Servlet extends HttpServlet {

    private ObjectMapper objectMapper;
    private UserService userService;
    private InvoiceService invoiceService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();
        this.objectMapper = context.getBean(ObjectMapper.class);
        this.userService = context.getBean(UserService.class);
        this.invoiceService = context.getBean(InvoiceService.class);

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
            String json = objectMapper.writeValueAsString(invoiceService.getInvoices());
            resp.getWriter().print(json);
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
