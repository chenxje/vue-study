package com.example.demo.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author xiaozhang
 * @date 2020/4/15
 * description
 *  update: linfengde
 *  @date 2020/5/14
 **/
@Getter
@NoArgsConstructor
public enum ResultCode {
    /**
     *
     */
    TASK_ERROR(700, "Flink的定时任务异常"),
    /**
     *
     */
    PARAM_CHECK_ERROR(701, "参数传输错误"),
    /**
     *
     */
    BUSINESS_ERROR(702, "业务出现错误"),
    /**
     *
     */
    UNDEFINE(-1, "未定义异常信息");


    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String msg(Integer code) {
        for (ResultCode m : ResultCode.values()) {
            if (m.getCode().equals(code)) {
                return m.getMsg();
            }
        }
        return UNDEFINE.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
