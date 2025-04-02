package hu.pte.mik.prog4.zh1.servlet;

import hu.pte.mik.prog4.zh1.model.Food;
import hu.pte.mik.prog4.zh1.service.FoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "XMLServlet", urlPatterns = {"/xml"})
public class XMLServlet extends HttpServlet {

    private final FoodService foodService = new FoodService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isBlank()) {
            try {
                Long id = Long.parseLong(idParam);
                Food food = foodService.findById(id);
                if (food != null) {
                    foodService.convertToXml(food);
                }
            } catch (NumberFormatException e) {
                // rossz formátumú ID - semmi teendő
            }
        }

        resp.sendRedirect(req.getContextPath() + "/foods");
    }
}
