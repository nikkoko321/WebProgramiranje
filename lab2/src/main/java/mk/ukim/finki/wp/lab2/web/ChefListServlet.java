package mk.ukim.finki.wp.lab2.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab2.service.ChefService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "chefs", urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {

    public final SpringTemplateEngine templateEngine;
    public final ChefService chefService;

    public ChefListServlet(SpringTemplateEngine springTemplateEngine, ChefService chefService) {
        this.templateEngine = springTemplateEngine;
        this.chefService = chefService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(iWebExchange);
        context.setVariable("chefs", chefService.listChefs());

        templateEngine.process("listChefs", context, resp.getWriter());

    }
}
