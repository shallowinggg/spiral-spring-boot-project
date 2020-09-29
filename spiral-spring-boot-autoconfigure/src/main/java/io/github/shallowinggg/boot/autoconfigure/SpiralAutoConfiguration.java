package io.github.shallowinggg.boot.autoconfigure;

import io.github.shallowinggg.spiral.spring.EnableSpiral;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ding shimin
 */
@Configuration
@ConditionalOnProperty(prefix = SpiralProperties.SPIRAL_PREFIX, name = "enable")
@EnableConfigurationProperties(SpiralProperties.class)
public class SpiralAutoConfiguration {

    @EnableSpiral
    @Configuration
    public static class Config {
    }
}
