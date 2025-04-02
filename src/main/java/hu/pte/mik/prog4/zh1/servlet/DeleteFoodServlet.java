package hu.pte.mik.prog4.zh1.servlet;

import hu.pte.mik.prog4.zh1.service.FoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteFoodServlet", urlPatterns = {"/delete-food"})
public class DeleteFoodServlet extends HttpServlet {

    private final FoodService foodService = new FoodService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isBlank()) {
            try {
                Long id = Long.parseLong(idParam);
                foodService.delete(id);
            } catch (NumberFormatException ignored) {
                // invalid az ID - (nem csinál semmit)
            }
        }
        resp.sendRedirect(req.getContextPath() + "/foods");
    }
}
