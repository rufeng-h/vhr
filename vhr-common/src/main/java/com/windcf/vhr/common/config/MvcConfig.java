package com.windcf.vhr.common.config;

import com.windcf.vhr.common.VhrProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author rufeng
 * @time 2022-04-18 15:53
 * @package com.rufeng.healthman.config
 * @description TODO
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private static final String FILE_PROTOCOL = "file:///";
    private final VhrProperties vhrProperties;

    public MvcConfig(VhrProperties vhrProperties) {
        this.vhrProperties = vhrProperties;
    }

    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
        if (vhrProperties.getUploadDir() != null) {
            registry.addResourceHandler("/upload/**")
                    .setCacheControl(CacheControl.maxAge(vhrProperties.getUploadCacheControl()))
                    .addResourceLocations(ensureSuffix(FILE_PROTOCOL + vhrProperties.getUploadDir()));
        }
    }

    private String ensureSuffix(String path) {
        if (!path.endsWith(vhrProperties.getUrlSeperator())) {
            return path + vhrProperties.getUrlSeperator();
        }
        return path;
    }
}
