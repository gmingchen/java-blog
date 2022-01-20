package com.slipper.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author gumingchen
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtils {
    /**
     * 秘钥
     */
    private String secret;
    /**
     * 过期时间
     */
    private Long expire;

    /**
     * 生成jwt
     * @param id 用户id
     * @return
     */
    public String generate(int id) {
        // 头部
        Map<String, Object> headerMap = new HashMap<>(2);
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");
        // 荷载信息
        Map<String, Object> claimsMap = new HashMap<>(1);
        claimsMap.put("id", id);

        Date now = new Date();

        return Jwts.builder()
                .setHeader(headerMap)
                .setClaims(claimsMap)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expire * 1000))
                .setSubject(id + "")
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 获取 载荷 信息
     * @param token
     * @return
     */
    public Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 验证是否过期
     * @param token
     * @return
     */
    public boolean validate(String token) {
        Claims claims = getClaims(token);
        return claims != null && claims.getExpiration().after(new Date());
    }
}
