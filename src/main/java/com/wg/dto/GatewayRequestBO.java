package com.wg.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by xiewenge on 2017/7/21.
 */
public class GatewayRequestBO {
    /**
     * 签名参数名称
     */
    public static final String SIGN_NAME = "sign";
    /**
     * 服务参数名称
     */
    public static final String SERVICE_NAME = "service";

    public static final String REQID_NAME = "reqId";
    /**
     * 服务版本号
     */
    @NotBlank(message = "请求服务名称不能为空")
    private String service;

    /**
     * 请求数据
     */
    private String data;

    /**
     * 令牌
     */
    @NotBlank(message = "令牌不能为空")
    private String token;

    /**
     *   请求方式  H5 或者  sdk
     */
    private String type;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
