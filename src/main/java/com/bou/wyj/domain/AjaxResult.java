package com.bou.wyj.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回类
 *
 * @Author xiaoquan
 * @Date 2023/7/12 15:23
 */
@Data
@Schema(description = "通用返回类")
public class AjaxResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "状态码")
    private Integer code;
    @Schema(description = "返回信息")
    private String msg;
    @Schema(description = "数据")
    private T data;


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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AjaxResult() {
        this.code = 200;
        this.msg = "success";
    }


    public static <T> AjaxResult<T> error(int code, String msg) {
        AjaxResult r = new AjaxResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> AjaxResult<T>  success(String msg) {
        AjaxResult r = new AjaxResult();
        r.setMsg(msg);
        return r;
    }

    public static <T> AjaxResult<T>  success(T obj) {
        AjaxResult r = new AjaxResult();
        r.setData(obj);
        return r;
    }

    public static <T> AjaxResult<T>  success() {
        return new AjaxResult();
    }


}

