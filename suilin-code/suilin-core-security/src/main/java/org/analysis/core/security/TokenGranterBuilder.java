package org.analysis.core.security;

import lombok.AllArgsConstructor;
import util.Func;
import util.SpringUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/29 11:22
 */
@AllArgsConstructor
public class TokenGranterBuilder {

    private static final Map<String, ITokenGranter> GRANTER_POOL = new ConcurrentHashMap<>();

    static {
        GRANTER_POOL.put(PasswordTokenGranter.GRANT_TYPE, SpringUtil.getBean(PasswordTokenGranter.class));
//        GRANTER_POOL.put(SocialTokenGranter.GRANT_TYPE, SpringUtil.getBean(SocialTokenGranter.class));
    }

    /**
     * 获取具体的TokenGranter
     *
     * @param grantType 授权类型
     * @return ITokenGranter
     */
    public static ITokenGranter getGranter(String grantType) {
        ITokenGranter tokenGranter = GRANTER_POOL.get(Func.toStr(grantType, PasswordTokenGranter.GRANT_TYPE));
        if (tokenGranter == null) {
            throw new RuntimeException("no grantType was found");
        } else {
            return tokenGranter;
        }
    }
}
