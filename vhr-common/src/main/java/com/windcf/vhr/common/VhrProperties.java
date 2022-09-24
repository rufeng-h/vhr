package com.windcf.vhr.common;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

/**
 * @author rufeng
 * @time 2022-04-18 16:11
 * @package com.rufeng.healthman.config.properties
 * @description TODO
 */
@ConstructorBinding
@Getter
@ConfigurationProperties(prefix = "vhr")
@Validated
public class VhrProperties {
    private final String workDir;
    private final Duration uploadCacheControl;
    private final String uploadDir;
    private final String urlSeperator = "/";
    private final String uploadPrefix = "upload";

    public VhrProperties(@NotEmpty String workDir, Duration uploadCacheControl) {
        this.workDir = workDir;
        this.uploadCacheControl = uploadCacheControl;
        if (this.workDir != null) {
            Path path = Paths.get(this.workDir);
            if (!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (this.workDir != null) {
            this.uploadDir = this.workDir + File.separator + this.uploadPrefix;
        } else {
            this.uploadDir = null;
        }
    }
}
