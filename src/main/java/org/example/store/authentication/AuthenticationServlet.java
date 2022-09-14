package org.example.store.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.store.JSP;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/authenticationServlet"})
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isEmpty(req.getParameter("login")) || isEmpty(req.getParameter("password"))) {
            var code = new Cookie("code", "400");
            code.setMaxAge(60*10);
            resp.addCookie(code);
            resp.sendError(400);
        }
        var dispatcher = req.getRequestDispatcher(JSP.HELLO.getJspName());
        dispatcher.forward(req, resp);
    }
}
