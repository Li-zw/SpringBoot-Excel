package com.example.exceldemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 数据结果统一返回类
 */

@Data
@ApiModel("统一结果返回类")
public class Result<T> extends HashMap<String, Object> implements Serializable {

    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("响应信息")
    private String message;
    @ApiModelProperty("响应数据")
    private T data;


    /**
     * 成功的Result
     *
     * @param message
     */
    public Result(String message) {
        super.put("code", HttpStatus.OK.value());
        super.put("message", message);
    }

    /**
     * 失败的Result
     *
     * @param code
     * @param message
     */
    public Result(int code, String message) {
        super.put("code", code);
        super.put("message", message);
    }

    /**
     * 请求成功的Result
     *
     * @param message
     * @param data
     */
    public Result(String message, T data) {
        super.put("code", HttpStatus.OK.value());
        super.put("message", message);
        super.put("data", data);
    }


    /**
     * 请求成功返回响应信息
     *
     * @param message 响应信息
     * @return
     */
    public static Result buildSuccessMsg(String message) {
        return new Result(message);

    }

    /**
     * 请求成功返回响应数据
     *
     * @param data 响应数据
     * @return
     */
    public static Result buildSuccessData(String message, Object data) {
        return new Result(message, data);

    }

    /**
     * 响应失败的请求结果
     * @param code
     * @param message
     * @return
     */
    public static Result buildFailMsg(int code, String message) {
        return new Result(code, message);
    }

}
