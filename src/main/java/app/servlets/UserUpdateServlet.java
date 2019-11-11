package app.servlets;

import app.enties.User;
import app.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/UpdateUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = getUser(req, resp);
            if (service.updateUser(user)) {
                req.setAttribute("UpdateUserLogin", user.getLogin());
                req.setAttribute("User", user);
            } else {
                req.setAttribute("wrongRequest", "login/password not valid");
            }
            doGet(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected User getUser(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        Double amount = Double.parseDouble(req.getParameter("amount"));
        return new User(login, password, name, amount);
    }
}
