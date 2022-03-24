package com.example.demo.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author linfengde
 * @date 2020/4/13
 */

@NoArgsConstructor
@Data
@Component
public class Result<T> {


    private Integer code;
    private String message;
    private T content;


    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.content = data;
    }


    public static <T> Result<T> responseOK(T data) {
        Result<T> result = new Result<>();
        result.setMessage("success");
        result.setContent(data);
        result.setCode(HttpStatus.SC_OK);
        return result;
    }

    public static <T> Result<T> responseOK(String message,T data) {
        Result<T> result = new Result<>();
        result.setMessage(message);
        result.setContent(data);
        result.setCode(HttpStatus.SC_OK);
        return result;
    }


    public static <T> Result<T> responseFail(String message) {
        Result<T> result = new Result<>();
        result.setCode(HttpStatus.SC_BAD_REQUEST);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> responseFail(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setMessage(message);
        result.setCode(code);
        return result;
    }


}
