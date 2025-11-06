package mk.ukim.finki.wp.lab2.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.service.ChefService;
import mk.ukim.finki.wp.lab2.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "dishes", urlPatterns = "/dish")
public class DishServlet extends HttpServlet {

    public final SpringTemplateEngine templateEngine;
    public final DishService dishService;
    public final ChefService chefService;


    public DishServlet(SpringTemplateEngine templateEngine, DishService dishService, ChefService chefService) {
        this.templateEngine = templateEngine;
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(iWebExchange);

        context.setVariable("dishes", dishService.listDishes());
        String chefId = req.getParameter("id");
        context.setVariable("chefId", chefId);
        Chef chef = chefService.findById(Long.parseLong(chefId));
        String name = chef.firstName;
        context.setVariable("chefName", name);

        templateEngine.process("dishesList", context, resp.getWriter());

    }
}
