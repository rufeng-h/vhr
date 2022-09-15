package com.windcf.vhr;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author chunf
 * @time 2022-09-15 14:16
 * @package com.windcf.vhr
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8)));
    }
}
