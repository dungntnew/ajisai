package com.ajisai.boom.interceptor;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MDCInterceptor implements HandlerInterceptor {

    private static final String HEADER_REQUEST_ID = "X-Request-ID";

    private static final String REQUEST_ID_KEY = "requestId";

    private static final String ALT_REQUEST_ID_PREFIX = "";

    private String getAltRequestId() {
        return ALT_REQUEST_ID_PREFIX + java.util.UUID.randomUUID().toString();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String requestId = request.getHeader(HEADER_REQUEST_ID);

        if (StringUtils.isEmpty(requestId)) {
            requestId = getAltRequestId();
        }
        MDC.put(REQUEST_ID_KEY, requestId);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(REQUEST_ID_KEY);
    }
}
