package org.example.store.stage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Stage {

    void execute(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException;
}
