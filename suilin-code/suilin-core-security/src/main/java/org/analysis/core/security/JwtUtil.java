package org.analysis.core.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/29 11:50
 */
@Component
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * jwt密钥
     */
    private String secret = "LGro0RSqrzBnEGdCHupEiMlU2Pj5YQeO72tVwOfXvPL7YHT7Fu";

    /**
     * 过期时间(60*60*24)
     */
    private Long expiration = 604800L;

    public final static String CAPTCHA_HEADER_KEY = "Captcha-Key";
    public final static String CAPTCHA_HEADER_CODE = "Captcha-Code";
    public final static String CAPTCHA_NOT_CORRECT = "验证码不正确";
    public final static String TENANT_HEADER_KEY = "Tenant-Id";
    public final static String DEFAULT_TENANT_ID = "000000";
    public final static String USER_TYPE_HEADER_KEY = "User-Type";
    public final static String DEFAULT_USER_TYPE = "web";
    public final static String USER_NOT_FOUND = "用户名或密码错误";
    public final static String HEADER_KEY = "Authorization";
    public final static String HEADER_PREFIX = "Basic ";
    public final static String DEFAULT_AVATAR = "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png";

    /**
     * 创建jwt
     */
    public AuthInfo create(UserInfo userInfo) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // TODO 修改签名
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", userInfo.getUserName());
        claims.put("account", userInfo.getAccount());

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
//                .setSubject(subject)
                .signWith(signatureAlgorithm, secret);

        long expMillis = nowMillis + expiration;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);

        return convertToAuthInfo(builder.compact(), userInfo);
    }

    public AuthInfo convertToAuthInfo(String jwt, UserInfo userInfo) {

        AuthInfo authInfo = new AuthInfo();

        authInfo.setUserId(userInfo.getUserId());
        authInfo.setOauthId(userInfo.getOauthId());
        authInfo.setAccount(userInfo.getAccount());
        authInfo.setUserName(userInfo.getUserName());
        authInfo.setAccessToken(TokenConstant.BEARER + jwt);
//        authInfo.setExpiresIn(accessToken.getExpire());
        authInfo.setTokenType(TokenConstant.BEARER);
        authInfo.setLicense(TokenConstant.LICENSE_NAME);

        return authInfo;

    }


    /**
     * 从token中获取JWT中的负载
     */
    public Claims parse(String token) {
        Claims claims = null;

        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        }catch (Exception e) {
            LOGGER.info("[gateway] authentication not attempted");
        }

        return claims;
    }
}
