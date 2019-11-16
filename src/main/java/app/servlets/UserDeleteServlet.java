package app.servlets;

import app.service.UserService;
import app.service.UserServiceImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userDelete")
public class UserDeleteServlet extends HttpServlet {

    private UserService service = UserServiceImpl.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter("login");
        service.deleteUser(login);
        req.setAttribute("DeleteUserLogin", login);
        resp.sendRedirect("/list?deletedLogin=" + login);
    }
}
