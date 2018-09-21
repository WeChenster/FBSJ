package com.zhuoan.util;
/**
 * @Description: 同意返回消息类
 * @Author: lwt
 * @CreateDate: 2018/9/21
 * @Version: 1.0
 * {"code":"1","msg":"xxxx","data":"{"id":"1"}"}
 */

public class ResultUtil<T> {

    private final static int SUCCESS_CODE = 1;
    private final static int ERROR_CODE = 0;
    private final static int SERVIER_ERROR = -1;
    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回内容
     */
    private T data;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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



    public ResultUtil(){
        this.code = SUCCESS_CODE;
        this.msg = "SUCCESS";
    }

    public ResultUtil(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultUtil(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //快速返回成功
    public static <T>ResultUtil success(){
        return new ResultUtil<T>(SUCCESS_CODE,"请求成功",null);
    }
    public static <T>ResultUtil success(T data){
        return new ResultUtil<T>(SUCCESS_CODE,"请求成功",data);
    }
    public static <T>ResultUtil success(String msg, T data){
        return new ResultUtil<T>(SUCCESS_CODE,msg,data);
    }

    //快速返回失败状态
    public static <T>ResultUtil fail(){
        return new ResultUtil<T>(ERROR_CODE,"请求失败",null);
    }

    public static <T>ResultUtil fail(T data){
        return new ResultUtil<T>(ERROR_CODE,"请求失败",data);
    }

    public <T>ResultUtil fail(String msg, T data){
        return new ResultUtil<T>(ERROR_CODE,msg,data);
    }

    //快速返回自定状态
    public <T>ResultUtil defaultSta(int code,String msg, T data){
        return new ResultUtil<T>(code,msg,data);
    }
}
