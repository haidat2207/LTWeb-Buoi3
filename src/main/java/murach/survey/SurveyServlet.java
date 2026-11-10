package murach.survey;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import murach.business.User;
//import murach.data.UserDB;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String url = "/index.html";
        String action = request.getParameter("action");

        if (action == null) {
            action = "join";
        }

        if (action.equals("join")) {
            url = "/index.html";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String hearAboutUs = request.getParameter("hearAboutUs");
            String[] announcements = request.getParameterValues("announcement"); // có thể null
            String contactBy = request.getParameter("contactBy");

            User user = new User(firstName, lastName, email);
//            UserDB.insert(user);

            request.setAttribute("user", user);
            request.setAttribute("dateOfBirth", dateOfBirth);
            request.setAttribute("hearAboutUs", hearAboutUs);
            request.setAttribute("announcements", announcements);
            request.setAttribute("contactBy", contactBy);

            url = "/thanks.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}