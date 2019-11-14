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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {

    private UserService service = UserService.getUserService(ConnectionProvider.getMysqlConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/AddUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = getUser(req, resp);
        if (service.addUser(user)) {
            req.setAttribute("AddUserLogin", user.getLogin());
        } else {
            req.setAttribute("wrongRequest", "User "+user.getLogin()+" Already Exist");
        }
        doGet(req, resp);
    }

    protected User getUser(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        Double amount = Double.parseDouble(req.getParameter("amount"));
        return new User(login, password, name, amount);

    }


}
