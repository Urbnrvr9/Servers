package org.example.store.database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.store.JSP;

import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(name = "product", value = "/product")
public class ProductController extends HttpServlet {

    private final ProductDao productDao;

    public ProductController() {
        productDao = new ProductDao(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> result = productDao.getAll();
        req.setAttribute("products", result);
        var message = result.isEmpty()
                ? JSP.GET_ALL_EMPTY.getJspName()
                : JSP.GET_ALL_PRODUCTS.getJspName();
        var dispatcher = req.getRequestDispatcher(message);
        dispatcher.forward(req,resp);
    }
}
