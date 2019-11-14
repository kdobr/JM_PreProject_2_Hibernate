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
import java.util.List;

@WebServlet("/list")
public class UsersListServlet extends HttpServlet {


    private UserService service = UserService.getUserService(ConnectionProvider.getMysqlConnection());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = service.getUsersList();
        request.setAttribute("users", users);
        request.getRequestDispatcher("views/list.jsp").forward(request, response);

    }


}
