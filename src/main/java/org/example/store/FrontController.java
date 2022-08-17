package org.example.store;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.example.store.exception.FrontControllerException;
import org.example.store.stage.FrontStage;
import org.example.store.stage.impl.CartStage;
import org.example.store.stage.impl.CatalogStage;

import java.util.Objects;

@Slf4j
@WebServlet(name = "FrontController", value = "/")
public class FrontController extends HttpServlet {

    private static final String STAGE = "stage";
    private static final String CATALOG = "catalog";
    private static final String CART = "cart";

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        rs.setContentType("text/html");
        try {
            if (!Objects.nonNull(rq.getParameter(STAGE))) {
                throw new FrontControllerException("Параметр stage не передан");
            }
            var stage = getStage(rq.getParameter(STAGE));
            stage.execute(rq, rs);
        } catch (Throwable e) {
            log.error(ExceptionUtils.getMessage(e));
        }
    }

    private FrontStage getStage(String stage) throws FrontControllerException {
        switch (stage) {
            case(CATALOG) :
                return new CatalogStage();
            case(CART):
                return new CartStage();
            default:
                throw new FrontControllerException("В параметр stage передано неверное значение");
        }
    }
}
