package bg.BulgariaTripPlanner.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Locale;

public class CharacterEncodingInterceptor implements HandlerInterceptor {
    private final String encoding = "UTF-8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String language = request.getParameter("lang");
        if (language != null) {
            Locale locale = new Locale(language);
            request.setAttribute("locale", locale);
        }
        response.setCharacterEncoding("UTF-8");
        return true;
    }
}
