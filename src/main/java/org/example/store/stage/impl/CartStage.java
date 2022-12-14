package org.example.store.stage.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.store.JSP;
import org.example.store.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CartStage implements Stage {

    private static final List<String> CART = List.of("white shirt", "black shirt");

    @Override
    public void execute(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        rq.setAttribute("cart", CART);
        var dispatcher = rq.getRequestDispatcher(JSP.CART.getJspName());
        dispatcher.forward(rq,rs);
    }
}
