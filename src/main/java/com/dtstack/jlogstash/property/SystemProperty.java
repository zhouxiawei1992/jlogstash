/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtstack.jlogstash.property;

import java.math.BigDecimal;


/**
 * 
 * Reason: TODO ADD REASON(可选)
 * Date: 2016年8月31日 下午1:27:36
 * Company: www.dtstack.com
 * @author sishu.yss
 *
 */
public class SystemProperty {
	
	static{
		System.setProperty("input", "com.dtstack.jlogstash.inputs");
		System.setProperty("filter", "com.dtstack.jlogstash.filters");
		System.setProperty("output", "com.dtstack.jlogstash.outputs");
		System.setProperty("annotationPlugin", "com.dtstack.jlogstash.annotation.plugin");
		System.setProperty("annotationPackage","com.dtstack.jlogstash.annotation");
	}
	
	public static String getSystemProperty(String key){
		return System.getProperty(key);
	}
	
	public static Double getInputProportion(){
	   BigDecimal bg = new BigDecimal(200f/1024);
       return bg.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static Double getOutputProportion(){
		   BigDecimal bg = new BigDecimal(500f/1024);
	       return bg.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
