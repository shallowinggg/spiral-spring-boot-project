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
