package org.example.store;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.store.stage.FrontStage;
import org.example.store.stage.impl.CartStage;
import org.example.store.stage.impl.CatalogStage;

import java.io.IOException;

@WebServlet(name = "FrontController", value = "/frontPage")
public class FrontController extends HttpServlet {

    private final FrontStage catalogStage = new CatalogStage();
    private final FrontStage cartStage = new CartStage();

    private final String STAGE = "stage";
    private final String CATALOG = "catalog";
    private final String CART = "cart";

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        FrontStage stage = getStage(rq);
        stage.execute(rq, rs);
    }

    private FrontStage getStage(HttpServletRequest rq) {
        String name = rq.getParameter(STAGE);
        switch (name) {
            case(CATALOG) :
                return catalogStage;
            case(CART):
                return cartStage;
            default:
                throw new RuntimeException();
        }


    }
}
