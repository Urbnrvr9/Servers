package org.example.store.calculator;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;

@Slf4j
@WebFilter("/calculatorServlet")
public class CalculatorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain chain) throws IOException, ServletException {
        if (NumberUtils.isParsable(rq.getParameter("number"))) {
            chain.doFilter(rq, rs);
        } else {
            rq.getRequestDispatcher("calculatorError.jsp").forward(rq, rs);
        }
    }
}
