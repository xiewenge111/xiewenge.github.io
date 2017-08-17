package com.wg.controller.router.router;


import com.wg.common.utils.MapToClassUtils;

import java.util.Map;

/**
 * 
 *@Description:默认入参构造器：通过MapToClass转换成成配置中所指定的入参对象
 *@Author:miaozongpei@ucfgroup.com
 *@Since:2017-6-7下午3:28:18
 *@Version:1.0.0
 */
public class DefaultArgsbuilder extends Argsbuilder {
	public DefaultArgsbuilder(String argClassName, String argName) {
		super(argClassName,argName);
	}

	@Override
	public Object arg(Map<String, String> data) throws Exception {
		if(this.argName!=null&&!"".equals(this.argName)){
			return data.get(this.argName);
		}
		if(this.argClassName==null||"".equals(this.argClassName)){
			return null;
		}
		return MapToClassUtils.map2Class(data, Class.forName(this.argClassName));
	}
}
