package com.example.demo.controller.commom;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.HttpResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class CommomResDataAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        final String returnTypeName = returnType.getParameterType().getName();
        return !CommonResponse.EXECPTION_TYPE.equals(returnTypeName);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        final String returnTypeName = returnType.getParameterType().getName();
        if(CommonResponse.VOID.equals(returnTypeName)){
            return HttpResult.success();
        }else if(CommonResponse.HTTPRESULT_TYPE.equals(returnTypeName)){
            return body;
        }else if(body instanceof String) {
            return JSON.toJSONString(HttpResult.success(body));
        }else{
            return HttpResult.success(body);
        }
    }

    private static final class CommonResponse {
        public static final String HTTPRESULT_TYPE = "com.example.demo.common.HttpResult";
        public static final String EXECPTION_TYPE = "org.springframework.http.ResponseEntity";
        public static final String VOID = "void";
    }
}
