package org.analysis.core.security;

import lombok.Data;

/**
 * 测试
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/29 11:25
 */
@Data
public class UserInfo {

    private String userId;

    private String userName;

    private String account;

    private String password;

    private String oauthId;
}
