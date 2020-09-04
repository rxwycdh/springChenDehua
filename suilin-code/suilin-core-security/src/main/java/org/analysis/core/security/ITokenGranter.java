package org.analysis.core.security;


/**
 * 总系统与用户认真统一接口 有第三方认证、帐号密码认证实现
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/29 11:21
 */
public interface ITokenGranter {

    /**
     * 获取用户信息
     *
     * @param tokenParameter 授权参数
     * @return UserInfo
     */
    UserInfo grant(TokenParameter tokenParameter);
}
