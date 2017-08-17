package com.wg.controller.router;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wg.common.decrypt.AES;
import com.wg.common.logger.WGLoggerFactory;
import com.wg.common.logger.wgLogger;
import com.wg.common.util.ValidatorUtil;
import com.wg.controller.router.router.GatewayRouter;
import com.wg.dto.BasicReturnBO;
import com.wg.dto.GatewayRequestBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by xiewenge on 2017/7/21.
 */
@Controller
@RequestMapping(value = "/gateway", method = { RequestMethod.POST, RequestMethod.GET },produces = "text/json;charset=UTF-8")
public class GatewayController {

    private static final wgLogger logger = WGLoggerFactory.getLogger(GatewayController.class);
    @ResponseBody
    @RequestMapping(value = "", method = { RequestMethod.POST, RequestMethod.GET })
    public Object gateway(HttpServletRequest request, GatewayRequestBO requestBO,BindingResult bindingResult, HttpServletResponse response) throws ServletException, IOException {

        BasicReturnBO basicReturnBO = new BasicReturnBO();
        requestBO.setData(request.getParameter("data"));
        requestBO.setService(request.getParameter("service"));
        requestBO.setToken(request.getParameter("token"));
        requestBO.setType(request.getParameter("type"));
        logger.info("gateway请求参数：{}",requestBO);
        String validMsg = ValidatorUtil.valid(requestBO);
        if(StringUtils.isNotBlank(validMsg)){
            basicReturnBO.setReturnMsg(validMsg);
            return JSONObject.toJSONString(basicReturnBO);
        }
        //校验令牌
        Map<String, String> dataMap = new HashMap<String, String>();
       try{
           dataMap = (Map<String, String>) JSONObject.parse(requestBO.getData());
       }catch (Exception e){
           e.printStackTrace();
       }
        dataMap.put("service",requestBO.getService());
        try {
            String data = formatResponseBody(doGateway(dataMap), null, "", "");
            basicReturnBO.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        basicReturnBO.setReturnMsg("成功");
        basicReturnBO.setReturnCode("0000");
        return JSONObject.toJSONString(basicReturnBO);
    }
    /**
     *
     * @Description:通过service名称在Spring的context获得配置的服务路由器,再根据路由器配置动态调用服务(第三方反射包:reflectasm)
     * @Author:xiewenge@ucfgroup.com
     * @Since:2017-6-6下午5:16:49
     * @param dataMap
     * @return
     * @throws Exception
     */
    private Object doGateway(Map<String, String> dataMap) throws Exception {
        String serviceName = dataMap.get(GatewayRequestBO.SERVICE_NAME);
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        GatewayRouter gatewayRouter = (GatewayRouter) webApplicationContext.getBean(serviceName);
        return gatewayRouter.doAccess(dataMap);
    }
    /**
     *
     * @Description:将解密的data字符串(json格式)转化构建成Map<String,String>的数据结构
     * @Author:xiewenge@ucfgroup.com
     * @Since:2017-6-6下午5:20:24
     * @param decryptData
     * @return
     */
    private Map<String, String> buildDataMap(String decryptData) {
        Map<String, String> dataMap = new HashMap<String, String>();
        JSONObject o = (JSONObject) JSON.parse(decryptData);
        for (Map.Entry<String, Object> e : o.entrySet()) {
            dataMap.put(e.getKey(), String.valueOf(e.getValue()));
        }
        return dataMap;
    }
    /**
     *
     * @Description:格式化返回相应数据,返回对象toJSON+跨域访问(callback)
     * @Author:xiewenge@ucfgroup.com
     * @Since:2017-6-6下午5:22:21
     * @param
     * @return
     * @throws Exception
     */
    private String formatResponseBody(Object bizObj, String decryptedTM, String var, String type) throws Exception {
        if (bizObj != null) {
            String bizObjStr = JSONObject.toJSONString(bizObj);
            if (decryptedTM != null && !"1.0.0".equals(var)) {
                if(type != null && "H5".equals(type)){
                    bizObjStr = AES.aesDecrypt(bizObjStr, decryptedTM,"utf-8");

                }else{
                    bizObjStr = AES.aesEncrypt(bizObjStr, decryptedTM);
                }
            }
            return String.format(bizObjStr);
        }
        return null;
    }

}
