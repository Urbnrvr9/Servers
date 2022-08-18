package org.example.store.stage.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.store.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CatalogStage implements Stage {

    private static final List<String> CATALOG = List.of("white shirt", "blue shirt", "black shirt");

    @Override
    public void execute(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        rq.setAttribute("catalog", CATALOG);
        var dispatcher = rq.getRequestDispatcher("catalog.jsp");
        dispatcher.forward(rq,rs);
    }
}
