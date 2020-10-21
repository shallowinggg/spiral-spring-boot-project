/*
 * Copyright © 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.github.shallowinggg.boot.autoconfigure;

import io.github.shallowinggg.spiral.config.SpiralConstant;
import io.github.shallowinggg.spiral.spring.EnableSpiral;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author ding shimin
 */
@Configuration
@ConditionalOnProperty(prefix = SpiralProperties.SPIRAL_PREFIX, name = "enable")
@EnableConfigurationProperties(SpiralProperties.class)
public class SpiralAutoConfiguration {

	private final ConfigurableEnvironment env;

	public SpiralAutoConfiguration(ConfigurableEnvironment env) {
		this.env = env;
	}

	@Bean
	public SpiralProperties spiralProperties() {
		SpiralProperties spiralProperties = new SpiralProperties();
		boolean enable =
				env.getProperty(SpiralConstant.ENABLE_PROPERTY, Boolean.class, Boolean.FALSE);
		String tag = env.getProperty(SpiralConstant.TAG_PROPERTY);
		spiralProperties.setEnable(enable);
		if (enable) {
			spiralProperties.setTag(tag);
		}
		return spiralProperties;
	}

	@EnableSpiral
	@Configuration
	public static class Config {
	}
}
