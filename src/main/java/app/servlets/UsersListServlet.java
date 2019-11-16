package app.servlets;

import app.enties.User;
import app.service.UserService;
import app.service.UserServiceImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class UsersListServlet extends HttpServlet {


    private UserService service = UserServiceImpl.getUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = service.getUsersList();
        request.setAttribute("usersList", users);
        request.getRequestDispatcher("views/list.jsp").forward(request, response);
    }
}
