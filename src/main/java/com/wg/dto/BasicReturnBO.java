package com.wg.dto;

import java.io.Serializable;

/**
 * Created by 文歌 on 2017/7/27.
 */
public class BasicReturnBO<T> implements Serializable{
    private static final long serialVersionUID = -693122491555573638L;

    private String returnCode;

    private String returnMsg;

    private T data;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BasicReturnBO{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
