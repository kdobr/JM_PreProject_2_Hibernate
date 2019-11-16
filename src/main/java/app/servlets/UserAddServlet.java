package app.servlets;

import app.enties.User;
import app.service.UserService;
import app.service.UserServiceImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {

    private UserService service = UserServiceImpl.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = getUser(req, resp);
        if (service.addUser(user)) {
            resp.sendRedirect("/list?addUserLogin="+user.getLogin());
        } else {
            resp.sendRedirect("/list?wrongRequest="+user.getLogin());
        }
    }

    private User getUser(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        Double amount = Double.parseDouble(req.getParameter("amount"));
        return new User(login, password, name, amount);
    }
}
