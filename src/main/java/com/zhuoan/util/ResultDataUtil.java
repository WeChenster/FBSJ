package com.zhuoan.util;

/**
 * @Description: 返回翻页详信息
 * @Author: lwt
 * @CreateDate: 2018/9/21
 * @Version: 1.0
 * {"total":10,"size":5,"page":1,"array":"[{"id":"1"},{"id":"2"}]"}
 *
 *
 */
public class ResultDataUtil<T> {

    //data详细分页
    private int total;
    private int size;
    private int page;
    private T array;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public T getArray() {
        return array;
    }

    public void setArray(T array) {
        this.array = array;
    }

    public ResultDataUtil(int total,int size,int page,T array){
        this.total = total;
        this.size = size;
        this.page = page;
        this.array = array;
    }

    //快速返回自定状态
    public <T>ResultDataUtil defaultPageUtil(int total,int size,int page,T array){
        return new ResultDataUtil<T>(total,size,page,array);
    }

}
