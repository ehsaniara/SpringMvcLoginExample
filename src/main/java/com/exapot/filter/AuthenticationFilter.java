package com.exapot.filter;

import com.exapot.CustomerImplBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by moe on 6/26/17.
 * From http://www.ehsaniara.com
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"*.xhtml"})
public class AuthenticationFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        CustomerImplBean operatorBean =
                (CustomerImplBean) ((HttpServletRequest) req).getSession().getAttribute("operatorBean");
        String path = ((HttpServletRequest) req).getRequestURI();
        if (!path.contains("javax.faces.resource")) {
            if (operatorBean != null && operatorBean.isLogin()) {
                chain.doFilter(req, resp); // Just continue chain.
            } else {
                HttpServletResponse response = (HttpServletResponse) resp;
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.

                //if not login
                if (path.contains("/index.xhtml")) {
                    //Kill The Browser cache
                    System.out.println("Should Be Redirected");
                    req.getRequestDispatcher("/logout.xhtml?faces-redirect=true").forward(req, resp);
                } else {
                    chain.doFilter(req, resp);
                }
            }
        } else {
            chain.doFilter(req, resp);

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
