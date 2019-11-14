package app.servlets;

import app.enties.User;
import app.service.UserService;
import app.utils.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userGet")
public class UserGetServlet extends HttpServlet {

    private UserService service = UserService.getUserService(ConnectionProvider.getMysqlConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/GetUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = service.getUser(login, password);
        if (user!=null) {
            req.setAttribute("User", user);
        } else {
            req.setAttribute("wrongRequest", "login/password not valid");
        }
        doGet(req, resp);
    }
}
