package app.servlets;

import app.enties.User;
import app.service.UserService;
import app.service.UserServiceImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {

    private UserService service = UserServiceImpl.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/UpdateUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = getUser(req, resp);
        String password = req.getParameter("password");
        if (service.updateUser(user, password)) {
            resp.sendRedirect("/list?updatedLogin=" + user.getLogin());
        } else {
            resp.sendRedirect("/list?wrongUpdate=" + user.getLogin());
        }
    }

    private User getUser(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("newPassword");
        String name = req.getParameter("newName");
        Double amount = Double.parseDouble(req.getParameter("newAmount"));
        return new User(login, password, name, amount);
    }
}
