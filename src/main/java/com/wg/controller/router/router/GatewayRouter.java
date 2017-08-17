package com.wg.controller.router.router;

import com.esotericsoftware.reflectasm.MethodAccess;

import java.util.Map;

/**
 * 
 *@Description:网关路由器：根据spring/fundpay-gateway-router.xml文件中的路由器配置进行动态调用
 *@Author:miaozongpei@ucfgroup.com
 *@Since:2017-6-6下午5:24:59
 *@Version:1.0.0
 */
public class GatewayRouter {
	/**
	 * 调用对象
	 */
	private Object access;
	/**
	 * 调用方法
	 */
	private String method;
	/**
	 * 调用入参类型
	 */
	private String argClassName;
	
	/**
	 * 调用入参类型
	 */
	private String argName;
	
	/**
	 * 调用入参构造器
	 */
	private Argsbuilder argsBuilder;
	/**
	 * 
	 *@Description:利用第三方进行动态方法调用
	 *@Author:miaozongpei@ucfgroup.com
	 *@Since:2017-6-6下午5:31:20
	 *@param data
	 *@return
	 *@throws Exception
	 */
	public Object doAccess(Map<String, String> data) throws Exception {
		MethodAccess methodAccess = MethodAccess.get(access.getClass());
		// 默认使用默认构建期
		if (argsBuilder == null) {
			argsBuilder = new DefaultArgsbuilder(argClassName,argName);
		}
		Object arg=argsBuilder.arg(data);
		if(arg==null){
			return methodAccess.invoke(access, method);
		}
		return methodAccess.invoke(access, method, arg);
	}

	public Object getAccess() {
		return access;
	}

	public void setAccess(Object access) {
		this.access = access;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getArgClassName() {
		return argClassName;
	}

	public void setArgClassName(String argClassName) {
		this.argClassName = argClassName;
	}

	public Argsbuilder getArgsBuilder() {
		return argsBuilder;
	}

	public void setArgsBuilder(Argsbuilder argsBuilder) {
		this.argsBuilder = argsBuilder;
	}

	public String getArgName() {
		return argName;
	}

	public void setArgName(String argName) {
		this.argName = argName;
	}
	
}
