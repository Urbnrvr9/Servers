package org.example.store.calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.store.JSP;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculatorServlet"})
public class CalculatorServlet extends HttpServlet {

    private static final String NUMBER = "number";
    private static final String SUM = "sum";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var number = Double.parseDouble(req.getParameter(NUMBER));
        var session = req.getSession();

        if (Objects.isNull(session.getAttribute(NUMBER))) {
            session.setAttribute(NUMBER, number);
            session.setMaxInactiveInterval(60 * 5);
            req.getRequestDispatcher(JSP.CALCULATOR_SECOND_NUMBER.getJspName()).forward(req, resp);
        } else {
            req.setAttribute(
                    SUM,
                    number + Double.parseDouble(session.getAttribute(NUMBER).toString()));
            session.removeAttribute(NUMBER);
            req.getRequestDispatcher(JSP.CALCULATOR_SUM.getJspName()).forward(req, resp);
        }
    }
}
