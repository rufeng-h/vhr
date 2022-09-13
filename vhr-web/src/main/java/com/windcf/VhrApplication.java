package com.windcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chunf
 * @time 2022-09-13 12:26
 * @package com.windcf
 * @description TODO
 */
@SpringBootApplication
@EnableTransactionManagement
public class VhrApplication {
    public static void main(String[] args) {
        SpringApplication.run(VhrApplication.class);
    }
}
