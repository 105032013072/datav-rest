package com.bosssoft.platform.datav.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSON;
import com.bosssoft.platform.datav.vo.BasicResponseContentVo;


/**
 * 封装统一的响应格式
 * 
 * @author huangxw
 * @date 2020/01/06
 */
@ControllerAdvice
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
        Class<? extends HttpMessageConverter<?>> converter, ServerHttpRequest httpRequest,
        ServerHttpResponse httpResponse) {

        if (body instanceof Byte|| body instanceof byte[]) {
            return body;
        } else if (body instanceof BasicResponseContentVo) {
            return body;
        } else if (body instanceof String) {
            return JSON.toJSONString(new BasicResponseContentVo<Object>(body));
        } else {
            return new BasicResponseContentVo<Object>(body);
        }

    }

    @Override
    public boolean supports(MethodParameter paramMethodParameter, Class<? extends HttpMessageConverter<?>> paramClass) {
        boolean isIntercept = true;

        String methodDeclaringClass = paramMethodParameter.getMethod().getDeclaringClass().getName();
        if (methodDeclaringClass.contains("swagger"))
            isIntercept = false;

        return isIntercept;
    }

}
