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
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

/**
 * Configuration properties for Spiral.
 *
 * @author ding shimin
 */
@ConfigurationProperties(prefix = SpiralProperties.SPIRAL_PREFIX)
public class SpiralProperties {

	public static final String SPIRAL_PREFIX = "spiral";

	private String tag;

	private boolean enable = false;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		Assert.hasText(tag, "tag must has text");
		this.tag = tag;
		System.setProperty(SpiralConstant.TAG_PROPERTY, tag);
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
		System.setProperty(SpiralConstant.ENABLE_PROPERTY, String.valueOf(enable));
	}
}
