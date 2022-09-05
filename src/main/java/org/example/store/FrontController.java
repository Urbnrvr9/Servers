package org.example.store;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.example.store.exception.FrontControllerException;
import org.example.store.stage.Stage;
import org.example.store.stage.impl.CartStage;
import org.example.store.stage.impl.CatalogStage;

import java.io.IOException;

@Slf4j
@WebServlet(name = "main", value = "/main")
public class FrontController extends HttpServlet {

    private static final String STAGE = "stage";
    private static final String UPLOAD = "upload";
    private static final String AUTH = "auth";
    private static final String CATALOG = "catalog";
    private static final String CART = "cart";
    private static final String FILE = "file";
    private static final String FILES = "files";

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        rs.setContentType("text/html; charset=UTF-8");
        rq.getParameterMap().forEach((k, v) -> {
            if (STAGE.equals(k)) {
                stageHandler(rq, rs);
            }
            if (UPLOAD.equals(k)) {
                uploadHandler(rq, rs);
            }
            if (AUTH.equals(k)) {
                authHandler(rq, rs);
            }
        });
    }

    private void authHandler(HttpServletRequest rq, HttpServletResponse rs) {
        try {
            var dispatcher = rq.getRequestDispatcher("authentication.jsp");
            dispatcher.forward(rq, rs);
        } catch (ServletException | IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    private void stageHandler(HttpServletRequest rq, HttpServletResponse rs) {
        try {
            var stage = getStage(rq.getParameter(STAGE));
            stage.execute(rq,rs);
        } catch (FrontControllerException e) {
            log.error(ExceptionUtils.getMessage(e));
        } catch (ServletException | IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }

    }

    private void uploadHandler(HttpServletRequest rq, HttpServletResponse rs) {
        try {
            var requestDispatcher = rq.getRequestDispatcher(getUploadJsp(rq.getParameter(UPLOAD)));
            requestDispatcher.forward(rq, rs);
        } catch (FrontControllerException e) {
            log.error(ExceptionUtils.getMessage(e));
        } catch (ServletException | IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    private Stage getStage(String stage) {
        switch (stage) {
            case(CATALOG) :
                return new CatalogStage();
            case(CART):
                return new CartStage();
            default:
                throw new FrontControllerException("В параметр stage передано неверное значение");
        }
    }

    private String getUploadJsp(String value) {
        switch (value) {
            case(FILE):
                return "fileUpload.jsp";
            case(FILES):
                return "filesUpload.jsp";
            default:
                throw new FrontControllerException("В параметр upload переданы не верные значения");
        }
    }
}
