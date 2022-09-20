package com.windcf.vhr.service.impl;

import com.windcf.vhr.security.exception.AuthenticationException;
import com.windcf.vhr.service.EmailService;
import com.windcf.vhr.service.VerificationCodeService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author chunf
 * @time 2022-09-16 10:43
 * @package com.windcf.vhr.service.impl
 * @description code service
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    private final EmailService emailService;
    private final StringRedisTemplate stringRedisTemplate;
    private final SecureRandom random = new SecureRandom();


    private static final int CODE_LEN = 4;

    public VerificationCodeServiceImpl(EmailService emailService, StringRedisTemplate stringRedisTemplate) {
        this.emailService = emailService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void sendEmailCode(String to) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LEN; i++) {
            sb.append(random.nextInt(10));
        }
        String code = sb.toString();
        emailService.sendSimpleMail(to, "登录验证码", String.format("验证码为：%s，5分钟内有效", code));
        stringRedisTemplate.opsForValue().set(to, code, 300, TimeUnit.SECONDS);
    }

    @Override
    public void validateEmailCode(String email, String code) {
        String c = stringRedisTemplate.opsForValue().get(email);
        if (!code.equals(c)) {
            throw new AuthenticationException("验证码错误或不存在!");
        }
    }
}
