package org.analysis.core.security;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import util.Func;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/29 11:24
 */
@Component
@AllArgsConstructor
public class PasswordTokenGranter implements ITokenGranter {

    public static final String GRANT_TYPE = "password";

    @Override
    public UserInfo grant(TokenParameter tokenParameter) {

        String account = tokenParameter.getArgs().getStr("account");
        String password = tokenParameter.getArgs().getStr("password");
        UserInfo userInfo = null;
        if (Func.isNoneBlank(account, password)) {
            // 获取用户类型
            String userType = tokenParameter.getArgs().getStr("userType");

            if(account.equals("admin") || password.equals("admin")) {
                userInfo = new UserInfo();
                userInfo.setAccount("admin");
                userInfo.setPassword("test-password");
            }
        }

        return userInfo;
    }
}
