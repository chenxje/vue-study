package com.example.demo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author linfengde
 * @date 2020/5/21
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HttpResult<T> implements Serializable {


    private Boolean success;

    private Long systemTime = System.currentTimeMillis();

    private T content;

    private Integer code;

    private String message;

    public static <T> HttpResult<T> success(){
        HttpResult<T> httpResult = new HttpResult<T>();
        httpResult.setSuccess(true);
        httpResult.setMessage("返回成功，无数据类型");
        httpResult.setCode(HttpStatus.OK.value());

        return httpResult;
    }

    public static <T> HttpResult<T> success(T content) {
        HttpResult<T> httpResult = new HttpResult<T>();
        httpResult.setSuccess(true);
        httpResult.setMessage("返回成功");
        httpResult.setContent(content);
        httpResult.setCode(HttpStatus.OK.value());
        return httpResult;
    }

    public static <T> HttpResult<T> fail(Integer code,String message){
        HttpResult<T> httpResult = new HttpResult<T>();
        httpResult.setSuccess(false);
        httpResult.setCode(code);
        httpResult.setMessage(message);
        return httpResult;
    }

    public static <T> HttpResult<T> fail(Integer code,String message,T content){
        HttpResult<T> httpResult = new HttpResult<T>();
        httpResult.setSuccess(false);
        httpResult.setCode(code);
        httpResult.setMessage(message);
        httpResult.setContent(content);
        return httpResult;
    }

    public  String buildResultJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", this.success);
        jsonObject.put("code", this.code);
        jsonObject.put("systemTime", this.systemTime);
        jsonObject.put("msg", this.message);
        jsonObject.put("content", this.content);
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }


}
