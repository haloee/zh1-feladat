package hu.pte.mik.prog4.zh1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FavouriteServlet", urlPatterns = {"/favorite-food"})
public class FavouriteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.isBlank()) {
            Cookie cookie = new Cookie("favoriteFoodId", id);
            cookie.setPath(req.getContextPath());  // elérhető legyen minden útvonalon
            cookie.setMaxAge(7 * 24 * 60 * 60);    // 1 hétig él
            resp.addCookie(cookie);
        }

        resp.sendRedirect(req.getContextPath() + "/foods");
    }
}
