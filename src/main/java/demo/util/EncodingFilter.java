package demo.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author mingfei.net@Gmail.com
 *         00:02, 4/16/15.
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

    private static final String CHARSET = "UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(CHARSET);
        response.setCharacterEncoding(CHARSET);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
