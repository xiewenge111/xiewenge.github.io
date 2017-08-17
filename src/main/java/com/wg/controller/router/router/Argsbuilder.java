package com.wg.controller.router.router;

import java.util.Map;

/**
 * 
 *@Description:抽象参数构建器：将参数构造器方法抽象，通过所指定的argsClassName进行配置文件指定
 *@Author:miaozongpei@ucfgroup.com
 *@Since:2017-6-7下午3:30:06
 *@Version:1.0.0
 */
public abstract class Argsbuilder {
	protected  String argClassName;
	protected  String argName;
	
	public Argsbuilder(String argClassName, String argName) {
		this.argClassName = argClassName;
		this.argName = argName;
	}
	public abstract Object  arg(Map<String, String> data)throws Exception;
	public String getArgClassName() {
		return argClassName;
	}
	public void setArgClassName(String argClassName) {
		this.argClassName = argClassName;
	}
	public String getArgName() {
		return argName;
	}
	public void setArgName(String argName) {
		this.argName = argName;
	}
	
}
