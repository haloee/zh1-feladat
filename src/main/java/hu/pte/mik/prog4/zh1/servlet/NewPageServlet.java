package hu.pte.mik.prog4.zh1.servlet;
import hu.pte.mik.prog4.zh1.service.FoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "NewfoodServlet", urlPatterns = {"/add-food"})
public class NewPageServlet extends HttpServlet{
    private final FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("foods", foodService.findAll());
        req.getRequestDispatcher("/addfood.jsp").forward(req, resp);
    }
}
