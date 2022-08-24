package org.example.store.exception;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "ExceptionHandlerServlet", urlPatterns = {"/exceptionhandler"})
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var writer = resp.getWriter();
        Arrays.stream(req.getCookies())
                .filter(cookie -> "code".equals(cookie.getName()))
                .forEach(code -> writer.printf("%s: %s", code.getName(), code.getValue()));
        writer.close();
    }
}
