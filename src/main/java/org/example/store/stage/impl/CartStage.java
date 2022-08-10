package org.example.store.stage.impl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.store.stage.FrontStage;

import java.io.IOException;
import java.util.List;

public class CartStage implements FrontStage {

    private final List<String> CART= List.of("white shirt", "black shirt");
    @Override
    public void execute(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        rq.setAttribute("cart", CART);
        RequestDispatcher dispatcher = rq.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
        dispatcher.forward(rq,rs);
    }
}
