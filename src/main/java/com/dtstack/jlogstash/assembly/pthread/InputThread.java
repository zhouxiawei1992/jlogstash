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
package com.dtstack.jlogstash.assembly.pthread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dtstack.jlogstash.inputs.BaseInput;

/**
 * 
 * Reason: TODO ADD REASON(可选)
 * Date: 2016年8月31日 下午1:25:29
 * Company: www.dtstack.com
 * @author sishu.yss
 *
 */
public class InputThread implements Runnable{
	
	private Logger logger = LoggerFactory.getLogger(InputThread.class);
	
	private BaseInput baseInput;
	
	private static ExecutorService inputExecutor;
	
	public InputThread(BaseInput baseInput){
		this.baseInput = baseInput;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(baseInput==null){
			logger.error("input plugin is not null");
			System.exit(1);
		}
		baseInput.emit();
	}
	
	public static void initInputThread(List<BaseInput> baseInputs) {
		// TODO Auto-generated method stub
		if(inputExecutor==null)inputExecutor= Executors.newFixedThreadPool(baseInputs.size());
		for(BaseInput input:baseInputs){
			inputExecutor.submit(new InputThread(input));
		}
	}
}
