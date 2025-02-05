/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.nacos.discovery;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.zuul.ZuulProxyMarkerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ruansheng
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(ZuulProxyMarkerConfiguration.class)
@AutoConfigureAfter(ZuulProxyMarkerConfiguration.class)
public class ZuulGatewayLocatorAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnBean(name = "zuulProxyMarkerBean")
	public GatewayLocatorHeartBeatPublisher gatewayLocatorHeartBeatPublisher(
			NacosDiscoveryProperties nacosDiscoveryProperties) {
		return new GatewayLocatorHeartBeatPublisher(nacosDiscoveryProperties);
	}

}
