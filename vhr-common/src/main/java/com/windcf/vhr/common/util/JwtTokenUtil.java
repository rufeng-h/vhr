package com.windcf.vhr.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @author rufeng
 * @time 2022-03-05 17:55
 * @package com.rufeng.healthman.common
 * @description jwt工具类
 */
public class JwtTokenUtil {
    private static final SecretKey KEY = Keys.hmacShaKeyFor(
            Decoders.BASE64.decode("SyI/8w+X528KqE2S8JKU8Sv1Bb+coixCZrU/fYYKDqc="));

    public static String generateToken(Long id, String username, String userType) {
        return Jwts.builder()
                .setSubject(username)
                .setAudience(userType)
                .setId(String.valueOf(id))
                .setIssuedAt(new Date())
                .signWith(KEY)
                .compact();
    }

    public static String getId(String token) {
        return getClaimsBody(token).getId();
    }


    public static Claims getClaimsBody(String token) {
        return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody();
    }

    public static boolean isValid(String token) {
        try {
            getClaimsBody(token);
            return true;
        } catch (JwtException ignored) {
            return false;
        }
    }
}